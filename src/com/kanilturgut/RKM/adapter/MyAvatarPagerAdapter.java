package com.kanilturgut.RKM.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kanilturgut.RKM.Constans;
import com.kanilturgut.RKM.R;
import com.kanilturgut.RKM.justification.TextViewEx;

/**
 * Created by kanilturgut on 19/03/14.
 */
public class MyAvatarPagerAdapter extends FragmentPagerAdapter {

    static Context context = null;
    public static final String ARG_PAGE = "page";

    public MyAvatarPagerAdapter(android.support.v4.app.FragmentManager fm, Context c) {
        super(fm);

        this.context = c;

    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        return PageFragmentForAvatar.create(position);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }


    //Fragments
    public static class PageFragmentForAvatar extends Fragment {

        ImageView tv;
        int myPageNumber;
        TextView textView;


        public static PageFragmentForAvatar create(int pageNumber) {
            PageFragmentForAvatar pageFragmentForAvatar = new PageFragmentForAvatar();
            Bundle bundle = new Bundle();
            bundle.putInt(ARG_PAGE, pageNumber);
            pageFragmentForAvatar.setArguments(bundle);

            return pageFragmentForAvatar;
        }

        public PageFragmentForAvatar() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            myPageNumber = getArguments().getInt(ARG_PAGE);

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment, container, false);
            tv = (ImageView) view.findViewById(R.id.ivImage);
            textView = (TextView) view.findViewById(R.id.tvTweets);

            switch (myPageNumber % Constans.NUMBER_OF_PAGE) {
                case 0:
                    tv.setImageDrawable(context.getResources().getDrawable(R.drawable.anil));
                    textView.setText("DÜZGÜN ADAM ARAMAKLA BULUNMAZ. ADAM ALINIR, DÜZELTİLİR, MUTLU OLUNUR :)");
                    break;
                case 1:
                    tv.setImageDrawable(context.getResources().getDrawable(R.drawable.muhammet));
                    textView.setText("KALBİ OLAN TEK ERKEK KUPA PAPAZIDIR...");
                    break;
                case 2:
                    tv.setImageDrawable(context.getResources().getDrawable(R.drawable.ozan));
                    textView.setText("BABAM HEP DERDİ Kİ; BAŞINI DİK TUT PRENSESİM, YOKSA TACIN DÜŞER.");
                    break;
                case 3:
                    tv.setImageDrawable(context.getResources().getDrawable(R.drawable.onur));
                    textView.setText("YA ABİ NASIL YAAAAA !!!");
                    break;
                case 4:
                    tv.setImageDrawable(context.getResources().getDrawable(R.drawable.can));
                    textView.setText("İSTEDİĞİMİ HAYATIMA, İSTEDİĞİMİN DE HAYATINA SOKARIM !!!!");
                    break;
            }

            return view;
        }
    }
}
