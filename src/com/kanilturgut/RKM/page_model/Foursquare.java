package com.kanilturgut.RKM.page_model;

import com.kanilturgut.RKM.Page;

/**
 * Created by kanilturgut on 26/03/14, 15:25.
 */
public class Foursquare extends SocialNetwork {

    SocialUser user;
    String post;
    byte[] imageOfPlace;
    boolean isMayor;

    public SocialUser getUser() {
        return user;
    }

    public void setUser(SocialUser user) {
        this.user = user;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public byte[] getImageOfPlace() {
        return imageOfPlace;
    }

    public void setImageOfPlace(byte[] imageOfPlace) {
        this.imageOfPlace = imageOfPlace;
    }

    public boolean isMayor() {
        return isMayor;
    }

    public void setMayor(boolean isMayor) {
        this.isMayor = isMayor;
    }

    @Override
    public int returnPageType() {
        return PAGE_TYPE_FOURSQUARE;
    }
}
