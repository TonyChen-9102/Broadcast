package com.demo.ck.broadcast.statics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 静态广播
 */
public class MyStaticReceiver extends BroadcastReceiver {
    public static final String STATIC_ACTION = "com.bsoft.ck.action.staticdemo";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(STATIC_ACTION,action)){
            Toast.makeText(context,"收到静态广播",Toast.LENGTH_LONG).show();
        }
    }
}
