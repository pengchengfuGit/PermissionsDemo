package com.example.administrator.permissionstest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String TAG= "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView easy = (TextView) findViewById(R.id.easy);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EasyActivity.class));
            }
        });

        TextView rx = (TextView) findViewById(R.id.rx);
        rx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"showCameraWithCheck ");
                startActivity(new Intent(MainActivity.this,RxActivity.class));
            }
        });

        TextView dispath = (TextView) findViewById(R.id.dispath);
        dispath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"showCameraWithCheck ");
                startActivity(new Intent(MainActivity.this,DispatcherActivity.class));
            }
        });

    }
}