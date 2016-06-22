package com.example.dg119.timer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Stopwatch extends AppCompatActivity {
    TextView time;
    public int miliSeconds = 0;
    public boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null){
            miliSeconds = savedInstanceState.getInt("miliSeconds");
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
                                 miliSeconds = 0;}

    private void runTimer(){
        time = (TextView) findViewById(R.id.timerTV);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int milisecs = miliSeconds%1000;
                int seconds = (miliSeconds/1000)%60;
                int minutes = (seconds%3600)/60;
                int hours = minutes/60;
                String timerString = String.format("%d:%02d:%02d:%03d",hours,minutes,seconds,milisecs);
                time.setText(timerString);
                if(running){
                    miliSeconds++;
                }
                handler.postDelayed(this,1);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle bundle){
        bundle.putBoolean("running", running);
        bundle.putInt("miliSeconds", miliSeconds);
    }
}
