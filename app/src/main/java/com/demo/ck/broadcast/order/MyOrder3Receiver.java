package com.demo.ck.broadcast.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * 有序广播
 */
public class MyOrder3Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(MyOrder1Receiver.ACTION,action)){
            Log.i("chenkaid","收到有序广播 3");
        }
    }
}
