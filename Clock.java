package com.example.dg119.timer;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;
import java.util.TimeZone;

public class Clock extends AppCompatActivity {
    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
    int seconds, minutes, hours, millisecond;
    TextView timeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        Intent intent = getIntent();
        timeTV = (TextView)findViewById(R.id.TimeTV);
        onRun();
    }

    public void onRun(){
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                hours = cal.get(Calendar.HOUR_OF_DAY);
                minutes = cal.get(Calendar.MINUTE);
                seconds = cal.get(Calendar.SECOND);
                millisecond = cal.get(Calendar.MILLISECOND);
                String timeOfDay = String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, millisecond);
                timeTV.setText(timeOfDay);
                handler.postDelayed(this, 1);
            }
        });
    }
}
