package com.demo.ck.broadcast.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * 有序广播
 */
public class MyOrder1Receiver extends BroadcastReceiver {
    public static final String ACTION = "com.bsoft.ck.action.orderdemo";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(ACTION,action)){
            Log.i("chenkaid","收到有序广播 1");

            //传值
            Bundle twobundle = new Bundle();
            twobundle.putString("extra","来自Order1");
            setResultExtras(twobundle);
        }
    }
}
