package com.kanilturgut.RKM;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.kanilturgut.RKM.adapter.MyAvatarPagerAdapter;
import com.kanilturgut.RKM.adapter.MyTweetPagerAdapter;

import java.lang.reflect.Field;

public class MyActivity extends FragmentActivity {

    ViewPager tweetPager, avatarPager;
    //MyTweetPagerAdapter myTweetPagerAdapter;
    MyAvatarPagerAdapter myAvatarPagerAdapter;

    Handler h = null;
    Runnable r = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        Log.i("BOOT_OK", "in onCreate of MyActivity");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                init();
            }
        }, 2000);
    }

    private void init() {
        //tweetPager = (ViewPager) findViewById(R.id.mViewPagerForTweet);
        //myTweetPagerAdapter = new MyTweetPagerAdapter(getSupportFragmentManager(), MyActivity.this);

        avatarPager = (ViewPager) findViewById(R.id.mViewPagerForAvatar);
        myAvatarPagerAdapter = new MyAvatarPagerAdapter(getSupportFragmentManager(), MyActivity.this);


        try {
            Field mScrollerForTwetter, mScrollerForAvatar;
            /*
            mScrollerForTwetter = ViewPager.class.getDeclaredField("mScroller");
            mScrollerForTwetter.setAccessible(true);
            FixedSpeedScroller scrollerForTwitter = new FixedSpeedScroller(tweetPager.getContext());
            mScrollerForTwetter.set(tweetPager, scrollerForTwitter);
*/
            mScrollerForAvatar = ViewPager.class.getDeclaredField("mScroller");
            mScrollerForAvatar.setAccessible(true);
            FixedSpeedScroller scrollerForAvatar = new FixedSpeedScroller(avatarPager.getContext());
            mScrollerForAvatar.set(avatarPager, scrollerForAvatar);


        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }

        if (avatarPager != null) {
            //tweetPager.setAdapter(myTweetPagerAdapter);
            avatarPager.setAdapter(myAvatarPagerAdapter);
        }


        h = new Handler();
        r = new Runnable() {
            @Override
            public void run() {

                //tweetPager.setCurrentItem(tweetPager.getCurrentItem() + 1);
                avatarPager.setCurrentItem(avatarPager.getCurrentItem() + 1);

                h.postDelayed(r, 8000);

            }
        };

         h.postDelayed(r, 8000);

    }

    @Override
    protected void onStop() {
        super.onStop();
        h.removeCallbacks(r);
    }


}
