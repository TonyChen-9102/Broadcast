package com.demo.ck.broadcast.permission;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.ck.broadcast.R;

public class PermissionActivity extends AppCompatActivity {
    private Button button3;
    private MyPermissionReceiver receiver;

    public static void appStart(Context context) {
        Intent intent = new Intent(context, PermissionActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendStaticBroadcast();
            }
        });

        register();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegister();
    }

    private void register() {
        receiver = new MyPermissionReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyPermissionReceiver.ACTION);
        registerReceiver(receiver, filter, MyPermissionReceiver.PERMISSION, null);
    }

    private void unRegister() {
        unregisterReceiver(receiver);
    }

    private void sendStaticBroadcast() {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.setAction(MyPermissionReceiver.ACTION);
        sendBroadcast(intent, MyPermissionReceiver.PERMISSION);
    }
}
