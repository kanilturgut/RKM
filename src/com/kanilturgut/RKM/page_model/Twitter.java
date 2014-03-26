package com.kanilturgut.RKM.page_model;

import android.graphics.drawable.Drawable;
import com.kanilturgut.RKM.Page;

/**
 * Created by kanilturgut on 26/03/14, 15:11.
 */
public class Twitter extends SocialNetwork {

    SocialUser user;
    String hashtag;
    String tweet;
    Drawable imageOfTweet;

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

    public Drawable getImageOfTweet() {
        return imageOfTweet;
    }

    public void setImageOfTweet(Drawable imageOfTweet) {
        this.imageOfTweet = imageOfTweet;
    }

    @Override
    public int returnPageType() {
        return PAGE_TYPE_TWITTER;
    }
}
