package com.demo.ck.broadcast.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 应用内广播
 */
public class MyLocalReceiver extends BroadcastReceiver {
    public static final String ACTION = "com.bsoft.ck.action.localdemo";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(ACTION,action)){
            Toast.makeText(context,"收到应用内广播",Toast.LENGTH_LONG).show();
        }
    }
}
