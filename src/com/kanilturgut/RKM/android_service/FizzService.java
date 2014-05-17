package com.kanilturgut.RKM.android_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.androidquery.AQuery;
import com.kanilturgut.RKM.helpers.AQueryOperation;

/**
 * Author   : kanilturgut
 * Date     : 16/05/14
 * Time     : 15:06
 */
public class FizzService extends Service{

    AQuery aQuery = null;

    // don't bind anything
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        aQuery = AQueryOperation.getInstance(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {




        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
