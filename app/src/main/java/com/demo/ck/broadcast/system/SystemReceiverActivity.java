package com.demo.ck.broadcast.system;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.ck.broadcast.R;

public class SystemReceiverActivity extends AppCompatActivity {
    private MySystemReceiver receiver;

    public static void appStart(Context context) {
        Intent intent = new Intent(context, SystemReceiverActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_receiver);
        register();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegister();
    }

    private void register() {
        receiver = new MySystemReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);//亮屏广播
        registerReceiver(receiver, filter);
    }

    private void unRegister() {
        unregisterReceiver(receiver);
    }
}
