package com.kanilturgut.RKM;

/**
 * Created by kanilturgut on 26/03/14, 15:08.
 */
public interface Page {

    public static final int PAGE_TYPE_TWITTER = 1;
    public static final int PAGE_TYPE_FOURSQUARE = 2;
    public static final int PAGE_TYPE_INSTAGRAM = 3;

    public int pageType = 0;

    public int returnPageType();
}
