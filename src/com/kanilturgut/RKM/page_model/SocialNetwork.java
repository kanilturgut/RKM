package com.kanilturgut.RKM.page_model;

import com.kanilturgut.RKM.Page;

import java.util.LinkedList;

/**
 * Created by kanilturgut on 26/03/14, 17:35.
 */
public class SocialNetwork implements Page{

    public static LinkedList<SocialNetwork> socialNetworks = new LinkedList<SocialNetwork>();
    int pageType;

    @Override
    public int returnPageType() {
        return 0;
    }
}
