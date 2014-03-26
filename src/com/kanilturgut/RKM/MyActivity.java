package com.kanilturgut.RKM;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import com.kanilturgut.RKM.adapter.MyViewPagerAdapter;
import com.kanilturgut.RKM.page_model.Foursquare;
import com.kanilturgut.RKM.page_model.Instagram;
import com.kanilturgut.RKM.page_model.SocialNetwork;
import com.kanilturgut.RKM.page_model.Twitter;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class MyActivity extends FragmentActivity {

    public static List<SocialNetwork> socialNetworkList = new LinkedList<SocialNetwork>();

    ViewPager viewPager;
    MyViewPagerAdapter myViewPagerAdapter;

    Handler h = null;
    Runnable r = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //to hide system bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //starts application after 4 second to load UI components
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                init();
            }
        }, Constans.APPLICATLION_START_TIME);
    }

    private void init() {

        startFaking();

        viewPager = (ViewPager) findViewById(R.id.mViewPager);
        myViewPagerAdapter = new com.kanilturgut.RKM.adapter.MyViewPagerAdapter(getSupportFragmentManager(), MyActivity.this);

        /*
        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float v) {
                view.setRotationY(v * -30);
            }
        });
        */

        try {
            Field  mScrollerForAvatar;
            mScrollerForAvatar = ViewPager.class.getDeclaredField("mScroller");
            mScrollerForAvatar.setAccessible(true);
            FixedSpeedScroller scrollerForAvatar = new FixedSpeedScroller(viewPager.getContext());
            mScrollerForAvatar.set(viewPager, scrollerForAvatar);

        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }

        if (viewPager != null) {
            viewPager.setAdapter(myViewPagerAdapter);
        }


        h = new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                h.postDelayed(r, Constans.SHOW_TIME_PER_IMAGE);
            }
        };

         h.postDelayed(r, Constans.SHOW_TIME_PER_IMAGE);
    }

    private void startFaking() {

        Faker faker = new Faker(MyActivity.this);
        faker.createLists();

        List<Twitter> twitterList = faker.getTwitterList();
        List<Foursquare> foursquareList = faker.getFoursquareList();
        List<Instagram> instagramList = faker.getInstagramList();

        for (Twitter twitter: twitterList) {
            socialNetworkList.add(twitter);
        }

        for (Foursquare foursquare: foursquareList) {
            socialNetworkList.add(foursquare);
        }

        for (Instagram instagram: instagramList) {
            socialNetworkList.add(instagram);
        }

        Log.i("deneme", " " + socialNetworkList.size());
    }

    @Override
    protected void onStop() {
        super.onStop();
        h.removeCallbacks(r);
    }
}
