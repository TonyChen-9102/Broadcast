package com.demo.ck.broadcast.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

public class MySystemReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(Intent.ACTION_SCREEN_ON, action)) {
            Toast.makeText(context, "收到亮屏广播", Toast.LENGTH_LONG).show();
        }
    }
}
