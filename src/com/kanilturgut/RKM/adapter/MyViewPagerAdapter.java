package com.kanilturgut.RKM.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.kanilturgut.RKM.Constans;
import com.kanilturgut.RKM.MyActivity;
import com.kanilturgut.RKM.Page;
import com.kanilturgut.RKM.R;
import com.kanilturgut.RKM.page_model.Foursquare;
import com.kanilturgut.RKM.page_model.Instagram;
import com.kanilturgut.RKM.page_model.SocialNetwork;
import com.kanilturgut.RKM.page_model.Twitter;

import java.util.Random;

/**
 * Created by kanilturgut on 19/03/14.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    static Context context = null;
    public static final String ARG_PAGE = "page";

    static Random random = new Random();
    static int size = MyActivity.socialNetworkList.size();

    public MyViewPagerAdapter(android.support.v4.app.FragmentManager fm, Context c) {
        super(fm);

        context = c;

    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        return PageFragment.create(position);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }


    //Fragments
    public static class PageFragment extends Fragment {

        int myPageNumber;

        //layout components
        ImageView ivHeaderSocialIcon, ivContentUserAvatar, ivContentPostImage, ivFooterSocialIcon;
        TextView tvHeaderWriteUs, tvContentUserName, tvContentUsername, tvContentPost, tvFooterVia;

        RelativeLayout layout_main;


        public static PageFragment create(int pageNumber) {
            PageFragment pageFragment = new PageFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ARG_PAGE, pageNumber);
            pageFragment.setArguments(bundle);

            return pageFragment;
        }

        public PageFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            myPageNumber = getArguments().getInt(ARG_PAGE);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.layout_pager, container, false);

            layout_main = (RelativeLayout) view.findViewById(R.id.layout_main);

            ivHeaderSocialIcon = (ImageView) view.findViewById(R.id.ivHeaderSocialIcon);
            ivContentUserAvatar = (ImageView) view.findViewById(R.id.ivContentUserAvatar);
            ivContentPostImage = (ImageView) view.findViewById(R.id.ivContentPostImage);
            ivFooterSocialIcon = (ImageView) view.findViewById(R.id.ivFooterSocialIcon);

            tvHeaderWriteUs = (TextView) view.findViewById(R.id.tvHeaderWriteUs);
            tvContentUserName = (TextView) view.findViewById(R.id.tvContentUserName);
            tvContentUsername = (TextView) view.findViewById(R.id.tvContentUsername);
            tvContentPost = (TextView) view.findViewById(R.id.tvContentPost);
            tvFooterVia = (TextView) view.findViewById(R.id.tvFooterVia);

            SocialNetwork socialNetwork = MyActivity.socialNetworkList.get(random.nextInt(size));

            if (socialNetwork.returnPageType() == Page.PAGE_TYPE_TWITTER) {
                Twitter twitter = (Twitter) socialNetwork;

                layout_main.setBackgroundResource(R.drawable.transition_twitter);
                TransitionDrawable transition = (TransitionDrawable) layout_main.getBackground();
                transition.startTransition(6000);

                ivHeaderSocialIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.twitter_icon));
                //ivHeaderSocialIcon.startAnimation(animFadeIn);

                ivContentUserAvatar.setImageDrawable(twitter.getUser().getAvatar());
                //ivContentUserAvatar.startAnimation(animFadeIn);

                //ivContentPostImage.setImageDrawable(twitter.getImageOfTweet());
                ivFooterSocialIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.twitter_icon));
                //ivFooterSocialIcon.startAnimation(animFadeIn);

                tvHeaderWriteUs.setText("#tobbetu' ye yazabilirsiniz");
                tvContentUserName.setText(twitter.getUser().getName() + " " + twitter.getUser().getSurname());
                tvContentUsername.setText("@" + twitter.getUser().getUsername());
                tvContentPost.setText(twitter.getTweet());
                tvFooterVia.setText("Just now via Twitter");

            } else if (socialNetwork.returnPageType() == Page.PAGE_TYPE_INSTAGRAM) {

                Instagram instagram = (Instagram) socialNetwork;
                //load animation
                Animation animFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in);

                layout_main.setBackgroundResource(R.drawable.transition_instagram);
                TransitionDrawable transition = (TransitionDrawable) layout_main.getBackground();
                transition.startTransition(6000);

                ivHeaderSocialIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.instagram_icon));
                //ivHeaderSocialIcon.startAnimation(animFadeIn);

                ivContentUserAvatar.setImageDrawable(instagram.getUser().getAvatar());
                //ivContentUserAvatar.startAnimation(animFadeIn);

                ivContentPostImage.setImageDrawable(instagram.getImageOfInstagram());
                ivContentPostImage.startAnimation(animFadeIn);

                ivFooterSocialIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.instagram_icon));
                //ivFooterSocialIcon.startAnimation(animFadeIn);

                tvHeaderWriteUs.setText("#tobbetu' ye yazabilirsiniz");
                tvContentUserName.setText(instagram.getUser().getName() + " " + instagram.getUser().getSurname());
                tvContentUsername.setText("@" + instagram.getUser().getUsername());
                tvContentPost.setText(instagram.getPost());
                tvFooterVia.setText("Just now via Instagram");

            } else if (socialNetwork.returnPageType() == Page.PAGE_TYPE_FOURSQUARE) {

                Foursquare foursquare = (Foursquare) socialNetwork;

                layout_main.setBackgroundResource(R.drawable.transition_foursquare);
                TransitionDrawable transition = (TransitionDrawable) layout_main.getBackground();
                transition.startTransition(6000);

                ivHeaderSocialIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.foursquare_icon));
                //ivHeaderSocialIcon.startAnimation(animFadeIn);

                ivContentUserAvatar.setImageDrawable(foursquare.getUser().getAvatar());
                //ivContentUserAvatar.startAnimation(animFadeIn);

                //ivContentPostImage.setImageDrawable(twitter.getImageOfTweet());

                ivFooterSocialIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.foursquare_icon));
                //ivFooterSocialIcon.startAnimation(animFadeIn);

                tvHeaderWriteUs.setText("#tobbetu' ye yazabilirsiniz");
                tvContentUserName.setText(foursquare.getUser().getName() + " " + foursquare.getUser().getSurname());
                tvContentUsername.setText("@" + foursquare.getUser().getUsername());
                tvContentPost.setText(foursquare.getPost());
                tvFooterVia.setText("Just now via Foursquare");
            }

            return view;
        }
    }
}
