package com.demo.ck.broadcast.active;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 动态广播
 */
public class MyActiveReceiver extends BroadcastReceiver {
    public static final String ACTION = "com.bsoft.ck.action.activedemo";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(ACTION,action)){
            Toast.makeText(context,"收到动态广播",Toast.LENGTH_LONG).show();
        }
    }
}
