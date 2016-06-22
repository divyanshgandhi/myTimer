package com.example.dg119.timer;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Clock extends AppCompatActivity {
    long time;
    TextView  timeTV = (TextView)findViewById(R.id.TimeTV);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        Intent intent = getIntent();
        time = SystemClock.currentThreadTimeMillis();
        String timeString = String.valueOf(time);
        timeTV.setText(timeString);
    }
}
