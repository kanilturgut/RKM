package com.kanilturgut.RKM;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.kanilturgut.RKM.fragment.CurrentFragment;
import com.kanilturgut.RKM.fragment.FizzyFragment;
import com.kanilturgut.RKM.fragment.LoadingFragment;
import com.kanilturgut.RKM.fragment.SplashFragment;

/**
 * Author   : kanilturgut
 * Date     : 16/05/14
 * Time     : 17:01
 */
public class MainActivity extends FragmentActivity {

    final String TAG = "MainActivity";
    Context context = null;
    static FragmentManager fragmentManager = null;
    public static int pageCount = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = this;

        fragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void onStart() {
        super.onStart();

        //to hide system bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mainToFizzFragment();
            }
        }, Constans.SHOW_TIME_PER_IMAGE);

    }

    public static void mainToSplash() {
        SplashFragment splashFragment = new SplashFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFrame, splashFragment);
        fragmentTransaction.commit();
        clearBackStack();
    }

    public static void mainToFizzFragment(){
        FizzyFragment fizzyFragment = new FizzyFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFrame, fizzyFragment);
        fragmentTransaction.commit();
        clearBackStack();
    }

    public static void currentToCurrent() {
        CurrentFragment currentFragment = new CurrentFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.currentFragment, currentFragment);
        fragmentTransaction.commit();
        clearBackStack();
    }

    public static void loadingToLoading() {
        LoadingFragment loadingFragment = new LoadingFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.loadingFragment, loadingFragment);
        fragmentTransaction.commit();
        clearBackStack();
    }

    private static void clearBackStack() {
        if (fragmentManager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = fragmentManager.getBackStackEntryAt(0);
            fragmentManager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
}