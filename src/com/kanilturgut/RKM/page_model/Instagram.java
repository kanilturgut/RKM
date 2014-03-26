package com.kanilturgut.RKM.page_model;

import android.graphics.drawable.Drawable;
import com.kanilturgut.RKM.Page;

/**
 * Created by kanilturgut on 26/03/14, 15:28.
 */
public class Instagram extends SocialNetwork {

    SocialUser user;
    Drawable imageOfInstagram;
    String post;
    int numberOfLike;

    public SocialUser getUser() {
        return user;
    }

    public void setUser(SocialUser user) {
        this.user = user;
    }

    public Drawable getImageOfInstagram() {
        return imageOfInstagram;
    }

    public void setImageOfInstagram(Drawable imageOfInstagram) {
        this.imageOfInstagram = imageOfInstagram;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getNumberOfLike() {
        return numberOfLike;
    }

    public void setNumberOfLike(int numberOfLike) {
        this.numberOfLike = numberOfLike;
    }

    @Override
    public int returnPageType() {
        return PAGE_TYPE_INSTAGRAM;
    }
}
