package com.kanilturgut.RKM.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kanilturgut.RKM.MainActivity;
import com.kanilturgut.RKM.R;

/**
 * Author   : kanilturgut
 * Date     : 16/05/14
 * Time     : 17:23
 */
public class LoadingFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loading, null);

        TextView textView = (TextView) view.findViewById(R.id.tvLoading);
        textView.setText("Loading is " + String.valueOf(MainActivity.pageCount));



        return view;
    }
}
