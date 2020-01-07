package com.demo.ck.broadcast.order;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.ck.broadcast.R;

public class OrderBroadCastActivity extends AppCompatActivity {
    private Button button;
    private MyOrder1Receiver myOrder1Receiver;
    private MyOrder2Receiver myOrder2Receiver;
    private MyOrder3Receiver myOrder3Receiver;

    public static void appStart(Context context) {
        Intent intent = new Intent(context, OrderBroadCastActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_broad_cast);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
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

    private void sendStaticBroadcast() {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.setAction(MyOrder1Receiver.ACTION);
        sendOrderedBroadcast(intent, null);
    }

    private void register() {
        myOrder1Receiver = new MyOrder1Receiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyOrder1Receiver.ACTION);
        filter.setPriority(1);
        registerReceiver(myOrder1Receiver, filter);

        myOrder2Receiver = new MyOrder2Receiver();
        IntentFilter filter2 = new IntentFilter();
        filter2.addAction(MyOrder1Receiver.ACTION);
        filter2.setPriority(2);
        registerReceiver(myOrder2Receiver, filter);

        myOrder3Receiver = new MyOrder3Receiver();
        IntentFilter filter3 = new IntentFilter();
        filter3.addAction(MyOrder1Receiver.ACTION);
        filter3.setPriority(3);
        registerReceiver(myOrder3Receiver, filter);
    }

    private void unRegister() {
        unregisterReceiver(myOrder1Receiver);
        unregisterReceiver(myOrder2Receiver);
        unregisterReceiver(myOrder3Receiver);
    }
}
