package com.demo.ck.broadcast.active;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.ck.broadcast.R;

public class ActiveBroadCastActivity extends AppCompatActivity {
    private Button btn1;
    private MyActiveReceiver receiver;

    public static void appStart(Context context) {
        Intent intent = new Intent(context, ActiveBroadCastActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_broad_cast);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendStaticBroadcast();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unRegister();
    }

    private void register() {
        receiver = new MyActiveReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyActiveReceiver.ACTION);
        registerReceiver(receiver, filter);
    }

    private void unRegister() {
        unregisterReceiver(receiver);
    }

    private void sendStaticBroadcast() {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.setAction(MyActiveReceiver.ACTION);
        sendBroadcast(intent);
    }
}
