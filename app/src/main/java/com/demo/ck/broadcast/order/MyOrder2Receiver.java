package com.demo.ck.broadcast.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

/**
 * 有序广播
 */
public class MyOrder2Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (TextUtils.equals(MyOrder1Receiver.ACTION, action)) {
            Bundle bundle = getResultExtras(true);
            String extra = null;
            if (bundle != null) {
                extra = bundle.getString("extra");
            }
            Log.i("chenkaid", "收到有序广播 2 " + extra);

            //拦截
            abortBroadcast();
        }
    }
}
