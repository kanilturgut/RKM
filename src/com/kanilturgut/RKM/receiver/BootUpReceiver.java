package com.kanilturgut.RKM.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import com.kanilturgut.RKM.MyActivity;

/**
 * Created by kanilturgut on 19/03/14.
 */
public class BootUpReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Boot Completed", Toast.LENGTH_LONG).show();
        Log.i("BOOT_OK", "in onReceive");

        Intent i = new Intent(context, MyActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}
