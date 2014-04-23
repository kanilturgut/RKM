package com.kanilturgut.RKM.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.androidquery.callback.ImageOptions;
import com.kanilturgut.RKM.Constans;
import com.kanilturgut.RKM.Page;
import com.kanilturgut.RKM.R;
import com.kanilturgut.RKM.page_model.SocialNetwork;
import com.kanilturgut.RKM.page_model.Twitter;

import java.util.LinkedList;

/**
 *
 * Author : kanilturgut
 * Date : 23.04.2014
 * Time : 15:18
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    static Context context = null;
    Activity activity;
    public static final String ARG_PAGE = "page";
    static LinkedList<SocialNetwork> socialNetworkList;

    static MyViewPagerAdapter myViewPagerAdapter;

    public static MyViewPagerAdapter getInstance(FragmentManager fm, Activity c, LinkedList<SocialNetwork> list) {

        if (myViewPagerAdapter == null)
            myViewPagerAdapter = new MyViewPagerAdapter(fm, c, list);


        return myViewPagerAdapter;
    }

    public MyViewPagerAdapter(FragmentManager fm, Activity c, LinkedList<SocialNetwork> list) {
        super(fm);

        activity = c;
        context = c;
        socialNetworkList = list;
    }

    @Override
    public Fragment getItem(int position) {

        return PageFragment.create(position % Constans.NUMBER_OF_PAGE);
    }

    @Override
    public int getCount() {

        return Integer.MAX_VALUE;
    }


    //Fragments
    public static class PageFragment extends Fragment {

        AQuery aQuery;

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
            aQuery = new AQuery(context);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            Log.i("PageNumber", "myCurrentPageNumber is " + myPageNumber);

            View view = inflater.inflate(R.layout.layout_pager, container, false);

            SocialNetwork socialNetwork = socialNetworkList.get(myPageNumber);

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


            if (socialNetwork.returnPageType() == Page.PAGE_TYPE_TWITTER) {
                Twitter twitter = (Twitter) socialNetwork;

                layout_main.setBackgroundResource(R.drawable.transition_twitter);
                TransitionDrawable transition = (TransitionDrawable) layout_main.getBackground();
                transition.startTransition(6000);

                ivHeaderSocialIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.twitter_icon));
                //ivHeaderSocialIcon.startAnimation(animFadeIn);

                ImageOptions options = new ImageOptions();
                options.fileCache = true;
                options.memCache = true;
                options.targetWidth = 0;

                if (twitter.getUser().getAvatar().contains("http")) {

                    Bitmap bmp = aQuery.getCachedImage(twitter.getUser().getAvatar());
                    if (bmp == null)
                        aQuery.id(ivContentUserAvatar).image(twitter.getUser().getAvatar(), options);
                    else
                        ivContentUserAvatar.setImageBitmap(bmp);
                }

                if (twitter.getImageOfTweet().contains("http")) {

                    Log.i("TAG", "twitter.getImageOfTweet() returned true");
                    Log.i("TAG", "twitter.getImageOfTweet() is " + twitter.getImageOfTweet());

                    Bitmap bmp1 = aQuery.getCachedImage(twitter.getImageOfTweet());
                    if (bmp1 == null)
                        aQuery.id(ivContentPostImage).image(twitter.getImageOfTweet(), options);
                    else
                        ivContentPostImage.setImageBitmap(bmp1);
                }

                ivFooterSocialIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.twitter_icon));

                tvHeaderWriteUs.setText("#" + twitter.getHashtag());
                tvContentUserName.setText(twitter.getUser().getName() + " " + twitter.getUser().getSurname());
                tvContentUsername.setText("@" + twitter.getUser().getUsername());
                tvContentPost.setText(twitter.getTweet());
                tvFooterVia.setText("Just now via Twitter");

            }


/*
            SharedPreferences sp = MyActivity.sharedPreferences;
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("counter", MyActivity.counter);
            editor.commit();

            Toast.makeText(context, "count : " + MyActivity.counter, Toast.LENGTH_SHORT).show();
            MyActivity.counter++;
            */

            return view;
        }
    }



}
