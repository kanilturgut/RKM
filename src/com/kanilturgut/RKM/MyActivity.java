package com.kanilturgut.RKM;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.kanilturgut.RKM.adapter.MyViewPagerAdapter;
import com.kanilturgut.RKM.page_model.Foursquare;
import com.kanilturgut.RKM.page_model.Instagram;
import com.kanilturgut.RKM.page_model.SocialNetwork;
import com.kanilturgut.RKM.page_model.Twitter;
import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubError;
import com.pubnub.api.PubnubException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MyActivity extends FragmentActivity {

    LinkedList<SocialNetwork> socialNetworkList = new LinkedList<SocialNetwork>();

    ViewPager viewPager;
    MyViewPagerAdapter myViewPagerAdapter;

    Handler h = null;
    Runnable r = null;

    public static int counter = 0;

    // public static SharedPreferences sharedPreferences;
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    AQuery aq;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        context = this;

        /*
        sharedPreferences = getSharedPreferences("logs", Context.CONTEXT_IGNORE_SECURITY);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("starting_time", sdf.format(new Date()));
        editor.commit();
*/
        aq = new AQuery(this);

        //starts application after 6 second to load UI components
        init();
    }

    private void init() {


        //startService(new Intent(context, tt.class));

        //to hide system bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

//        startFaking();

        viewPager = (ViewPager) findViewById(R.id.mViewPager);

        String url = "http://onurcansert.com:3000/initialTweets";
        aq.ajax(url, JSONArray.class, new AjaxCallback<JSONArray>() {

            @Override
            public void callback(String url, JSONArray object, AjaxStatus status) {
                if (object != null) {

                    for (int i = 0; i < object.length(); i++) {

                        try {
                            JSONObject jsonObject = object.getJSONObject(i);
                            socialNetworkList.add(Twitter.fromJSON(jsonObject));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    setViewPagerAdapter();
                    startPubnup();

                } else {
                    //ajax error, show error code
                    Toast.makeText(aq.getContext(), "Error:" + status.getCode(), Toast.LENGTH_LONG).show();
                }
            }
        });


        //startPubnup();

        /*
        viewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View view, float v) {
                view.setRotationY(v * -30);
            }
        });
        */

    }

    void setViewPagerAdapter() {

        if (myViewPagerAdapter != null)
            h.removeCallbacks(r);

        myViewPagerAdapter = MyViewPagerAdapter.getInstance(getSupportFragmentManager(), MyActivity.this, socialNetworkList);

        try {
            Field mScrollerForAvatar;
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

        Faker faker = new Faker(context);
        faker.createLists();

        List<Twitter> twitterList = faker.getTwitterList();
        List<Foursquare> foursquareList = faker.getFoursquareList();
        List<Instagram> instagramList = faker.getInstagramList();

        for (Twitter twitter : twitterList) {
            socialNetworkList.add(twitter);
        }

        for (Foursquare foursquare : foursquareList) {
            socialNetworkList.add(foursquare);
        }

        for (Instagram instagram : instagramList) {
            socialNetworkList.add(instagram);
        }

        Log.i("deneme", " " + socialNetworkList.size());
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (h != null)
            h.removeCallbacks(r);

        //  SharedPreferences.Editor editor = sharedPreferences.edit();
        //  editor.putString("end_time", sdf.format(new Date()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        onCreate(null);
    }


    void startPubnup() {

        String publishKey = "pub-c-13b31cee-ef79-440f-b46d-e3804f3d5435";
        String subscribeKey = "sub-c-3a5a7350-b28d-11e3-b8c3-02ee2ddab7fe";
        final String channel = "fizz";

        Pubnub pubnub = new Pubnub(publishKey, subscribeKey);

        try {
            pubnub.subscribe(channel, new Callback() {

                @Override
                public void connectCallback(String channel, Object message) {
                    Log.i("Pubnup", "SUBSCRIBE : CONNECT on channel:" + channel
                            + " : " + message.getClass() + " : "
                            + message.toString());
                }

                @Override
                public void disconnectCallback(String channel, Object message) {
                    Log.i("Pubnup", "SUBSCRIBE : DISCONNECT on channel:" + channel
                            + " : " + message.getClass() + " : "
                            + message.toString());
                }

                @Override
                public void successCallback(String channel, Object message) {

                    final String msg = message.toString();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {

                                LinkedList temp = socialNetworkList;

                                Twitter twitter = Twitter.fromJSON(new JSONObject(msg));

                                socialNetworkList.removeLast();
                                socialNetworkList.addFirst(twitter);

                                setViewPagerAdapter();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });


                }

                @Override
                public void errorCallback(String s, PubnubError pubnubError) {

                    Log.e("Pubnup", "SUBSCRIBE : ERROR on channel " + channel
                            + " : " + pubnubError.toString());
                }
            });
        } catch (PubnubException e) {
            e.printStackTrace();
        }

    }


}
