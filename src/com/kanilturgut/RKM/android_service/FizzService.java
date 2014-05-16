package com.kanilturgut.RKM.android_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Author   : kanilturgut
 * Date     : 16/05/14
 * Time     : 15:06
 */
public class FizzService extends Service{

    // don't bind anything
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //set
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
