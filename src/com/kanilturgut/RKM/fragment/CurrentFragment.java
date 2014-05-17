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
 * Time     : 17:19
 */
public class CurrentFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current, null);

        TextView textView = (TextView) view.findViewById(R.id.tvCurrent);
        textView.setText("Current is " + String.valueOf(MainActivity.pageCount));



        return view;
    }
}
