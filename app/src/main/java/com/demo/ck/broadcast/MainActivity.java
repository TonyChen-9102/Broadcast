package com.demo.ck.broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.demo.ck.broadcast.active.ActiveBroadCastActivity;
import com.demo.ck.broadcast.local.LocalActivity;
import com.demo.ck.broadcast.order.OrderBroadCastActivity;
import com.demo.ck.broadcast.permission.PermissionActivity;
import com.demo.ck.broadcast.statics.MyStaticReceiver;
import com.demo.ck.broadcast.system.SystemReceiverActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendStaticBroadcast();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActiveBroadCastActivity.appStart(MainActivity.this);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SystemReceiverActivity.appStart(MainActivity.this);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderBroadCastActivity.appStart(MainActivity.this);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocalActivity.appStart(MainActivity.this);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermissionActivity.appStart(MainActivity.this);
            }
        });
    }

    private void sendStaticBroadcast() {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.setAction(MyStaticReceiver.STATIC_ACTION);
        sendBroadcast(intent);
    }
}
