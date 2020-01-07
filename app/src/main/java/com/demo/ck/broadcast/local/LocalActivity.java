package com.demo.ck.broadcast.local;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.demo.ck.broadcast.R;

public class LocalActivity extends AppCompatActivity {
    private Button button2;
    private MyLocalReceiver myLocalReceiver;
    private LocalBroadcastManager manager;

    public static void appStart(Context context) {
        Intent intent = new Intent(context, LocalActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        manager = LocalBroadcastManager.getInstance(this);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
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
        unregister();
    }

    private void register() {
        myLocalReceiver = new MyLocalReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyLocalReceiver.ACTION);
        manager.registerReceiver(myLocalReceiver, filter);

    }

    private void unregister() {
        manager.unregisterReceiver(myLocalReceiver);
    }

    private void sendStaticBroadcast() {
        Intent intent = new Intent();
        intent.setAction(MyLocalReceiver.ACTION);
        manager.sendBroadcast(intent);
    }
}
