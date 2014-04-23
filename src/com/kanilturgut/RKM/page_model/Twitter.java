package com.kanilturgut.RKM.page_model;

import android.graphics.drawable.Drawable;
import com.kanilturgut.RKM.Page;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kanilturgut on 26/03/14, 15:11.
 */
public class Twitter extends SocialNetwork {

    SocialUser user;
    String hashtag;
    String tweet;
    String imageOfTweet;

    public SocialUser getUser() {
        return user;
    }

    public void setUser(SocialUser user) {
        this.user = user;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getImageOfTweet() {
        return imageOfTweet;
    }

    public void setImageOfTweet(String imageOfTweet) {
        this.imageOfTweet = imageOfTweet;
    }

    @Override
    public int returnPageType() {
        return PAGE_TYPE_TWITTER;
    }

    public static Twitter fromJSON(JSONObject jsonObject) throws JSONException {

        Twitter twitter = new Twitter();
        SocialUser socialUser = new SocialUser();

        socialUser.setName(jsonObject.optString("name"));
        socialUser.setSurname("");
        socialUser.setAvatar(jsonObject.optString("profileImage"));
        socialUser.setUsername(jsonObject.optString("screen_name"));

        twitter.setUser(socialUser);
        //twitter.setHashtag(jsonObject.optString("hashtag"));
        twitter.setTweet(jsonObject.optString("text"));
        twitter.setImageOfTweet(jsonObject.optString("tweetImage"));

        JSONArray jsonArray = jsonObject.getJSONArray("hashtags");
        twitter.setHashtag(jsonArray.getJSONObject(0).getString("text"));

        return twitter;
    }
}
