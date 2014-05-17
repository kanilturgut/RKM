package com.kanilturgut.RKM.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kanilturgut.RKM.Constans;
import com.kanilturgut.RKM.MainActivity;
import com.kanilturgut.RKM.R;

/**
 * Author   : kanilturgut
 * Date     : 16/05/14
 * Time     : 17:17
 */
public class FizzyFragment extends Fragment{

    Handler handler = null;
    Runnable runnable = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fizz, null);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                MainActivity.currentToCurrent();
                MainActivity.loadingToLoading();
                MainActivity.pageCount++;

                handler.postDelayed(runnable, Constans.SHOW_TIME_PER_IMAGE);
            }
        };
        handler.postDelayed(runnable, Constans.SHOW_TIME_PER_IMAGE);

        return view;
    }
}
