package com.example.dg119.timer;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Stopwatch extends AppCompatActivity {
    TextView time;
    public long seconds = 0;
    public boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null){
            seconds = savedInstanceState.getLong("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        Intent intent = getIntent();
        runTimer();
    }
    public void start(View view){running = true;}
    public void stop(View view){running = false;}
    public void reset(View view){running = false;
                                 seconds = Long.valueOf(0);}

    private void runTimer(){
        time = (TextView) findViewById(R.id.timerTV);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                long secs = seconds%60;
                long minutes = (seconds%3600)/60;
                long hours = seconds/3600;
                String timerString = String.format("%d:%02d:%02d",hours,minutes,secs);
                time.setText(timerString);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        bundle.putBoolean("running", running);
        bundle.putLong("seconds", seconds);
    }
}
