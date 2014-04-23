package com.kanilturgut.RKM.android_service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import com.kanilturgut.RKM.MyActivity;

import java.util.List;

/**
 * Created by kanilturgut on 04/04/14, 11:47.
 */
public class tt extends Service {

    private RunnableThread thread;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        thread.setIsContinue(false);
        stopSelf();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {
        try{


            if(thread==null) {
                thread = new RunnableThread();
                thread.setIsHeliosActive(true);
                thread.startThread();

            } else {
                thread.setIsHeliosActive(true);
            }
        }catch(Exception e){
            Log.e("AppTrackingService", "Exception: " + e.getMessage());
        }


        return (START_NOT_STICKY);

    }


    class RunnableThread extends Thread{
        Handler back_handler = new Handler();
        //These are two packages that i have exempted i.e if either of contacts or settings are opened than your activity will not come to front
        String settingsPackageName = "com.android.settings";
        String contactsPackageName = "com.android.contacts";
        boolean isHeliosActive = false;
        boolean isContinue = false;
        public RunnableThread(){
            isContinue = false;
        }

        public void setIsHeliosActive(boolean val) {
            this.isHeliosActive = val;
        }

        public void setIsContinue(boolean val){
            this.isContinue = val;
        }

        public void startThread(){
            isContinue = true;
            start();
        }


        public void run(){
            ActivityManager actMngr = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
            while(isContinue){
                try{
                    //Maintain a boolean "isyourapprunning" to know if your app was running or not....
                    if(isHeliosActive){
                        String runningAppPkg = actMngr.getRunningTasks(1).get(0).baseActivity.getPackageName();
                        if (!runningAppPkg.equalsIgnoreCase(getApplicationContext().getPackageName()) &&
                                !runningAppPkg.equalsIgnoreCase(contactsPackageName)) {
                            //If anoy other app is opened..bring our activity to front
                            launchAppOrBringToFront(getApplicationContext().getPackageName());
                        }
                        Thread.sleep(100);  //1 sec (Your activity will come to front every 1 sec if any other app other than your activity is open
                    }else{
                        isContinue = false;
                        stopSelf();
                    }

                }catch(Exception e){ }
            }//end of while loop
        }


        protected void launchAppOrBringToFront(String packageName) {

            //         This is the activity you need to bring in front
            Intent mIntent = new Intent(getApplicationContext(), MyActivity.class);
            mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (null != mIntent) {
                try {
                    startActivity(mIntent);
                } catch(Exception e) {
                    Log.e("AppTrackingService", e.getMessage(), e);
                }
            }
        }

    }

}
