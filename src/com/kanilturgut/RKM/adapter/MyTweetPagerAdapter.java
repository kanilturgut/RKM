package com.kanilturgut.RKM.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kanilturgut.RKM.Constans;
import com.kanilturgut.RKM.R;

/**
 * Created by kanilturgut on 19/03/14.
 */
public class MyTweetPagerAdapter extends FragmentPagerAdapter {

    static Context context = null;
    public static final String ARG_PAGE = "page";

    public MyTweetPagerAdapter(android.support.v4.app.FragmentManager fm, Context c) {
        super(fm);

        context = c;

    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        return PageFragmentForTwitter.create(position);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }


    //Fragments
    public static class PageFragmentForTwitter extends Fragment {

        TextView tv;
        int myPageNumber;


        public static PageFragmentForTwitter create(int pageNumber) {
            PageFragmentForTwitter pageFragmentForAvatar = new PageFragmentForTwitter();
            Bundle bundle = new Bundle();
            bundle.putInt(ARG_PAGE, pageNumber);
            pageFragmentForAvatar.setArguments(bundle);

            return pageFragmentForAvatar;
        }

        public PageFragmentForTwitter() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            myPageNumber = getArguments().getInt(ARG_PAGE);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.layout_for_tweet, container, false);
            if (view != null) {
                tv = (TextView) view.findViewById(R.id.tvTweets);
            }

            switch (myPageNumber % Constans.NUMBER_OF_PAGE) {
                case 0:
                    tv.setText("DÜZGÜN ADAM ARAMAKLA BULUNMAZ. ADAM ALINIR, DÜZELTİLİR, MUTLU OLUNUR :)");
                    break;
                case 1:
                    tv.setText("KALBİ OLAN TEK ERKEK KUPA PAPAZIDIR...");
                    break;
                case 2:
                    tv.setText("BABAM HEP DERDİ Kİ; BAŞINI DİK TUT PRENSESİM, YOKSA TACIN DÜŞER.");
                    break;
                case 3:
                    tv.setText("DEMİRDEN KORKSAK TRENE BİNMEZDİK");
                    break;
                case 4:
                    tv.setText("İSTEDİĞİMİ HAYATIMA, İSTEDİĞİMİN DE HAYATINA SOKARIM !!!!");
                    break;
            }

            return view;
        }
    }
}
