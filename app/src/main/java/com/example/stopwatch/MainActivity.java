package com.example.stopwatch;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvCount;
    Button btStop, btStart, btReset;

    long milliSecond, startTime, timeBuff, updateTime = 0L;
    int seconds, minutes, milliSeconds;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();
        tvCount = findViewById(R.id.tvCount);

        //button
        btStart = findViewById(R.id.btStart);
        btReset = findViewById(R.id.btReset);
        btStop = findViewById(R.id.btStop);

        //listener bt start
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
            }
        });

    }

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
          milliSecond = SystemClock.uptimeMillis() - startTime;
          updateTime = timeBuff + milliSecond;
          seconds = (int)(updateTime / 1000);
          minutes = seconds / 60;
          seconds = seconds % 60;
          milliSeconds = (int)(updateTime % 1000);

          tvCount.setText(""+minutes+":"
          +String.format("%02d", seconds)+":"
          +String.format("%03d", milliSeconds));

          handler.postDelayed(this, 0);
        }
    };


}
