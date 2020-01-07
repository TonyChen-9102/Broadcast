package com.demo.ck.broadcast.permission;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 权限广播
 */
public class MyPermissionReceiver extends BroadcastReceiver {
    public static final String ACTION = "com.bsoft.ck.action.permissiondemo";
    public static final String PERMISSION = "com.bsoft.ck.permission.mydemo";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(ACTION,action)){
            Toast.makeText(context,"收到权限广播",Toast.LENGTH_LONG).show();
        }
    }
}
