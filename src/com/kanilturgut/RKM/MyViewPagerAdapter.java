package com.kanilturgut.RKM;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by kanilturgut on 19/03/14.
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter{

    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
}
