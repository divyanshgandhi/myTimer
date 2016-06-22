package com.example.dg119.timer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clock(View view){
        Intent clockIntent = new Intent(this, Clock.class);
        startActivity(clockIntent);
    }

    public void stopwatch(View view){
        Intent stopwatchIntent = new Intent(this, Stopwatch.class);
        startActivity(stopwatchIntent);
    }
}
