package com.example.lenovo.completeproj;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by lenovo on 2016/7/26.
 */
public class ThreadTestActivity extends AppCompatActivity implements  Runnable {
    int i=0;
    boolean shouldStop = false;
    boolean isRunning=false;
    Thread a;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_test);

        Button begin = (Button)findViewById(R.id.thread_test_begin);
        Button stop = (Button)findViewById(R.id.thread_test_stop);
        try {
            begin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isRunning) {
                        a = new Thread(ThreadTestActivity.this);
                        a.start();
                        Log.d("info!", "Running by button");
                        isRunning = true;
                    }
                }
            });
            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isRunning) {
                        shouldStop = true;
                        isRunning = false;
                        Log.d("info!", "Stopped by button");
                    }
                }
            });
        }
        catch(java.lang.NullPointerException e){

        }

    }

    @Override
    public void run() {
        Log.d("Information!","Begin to do counting");
        long current;
        long next;
        while (!shouldStop){
            Log.d("Information!",String.valueOf(ThreadTestActivity.this.i));
            current = System.currentTimeMillis();
            for(;;){
                next = System.currentTimeMillis();
                if((next-current)>1000)
                    break;
            }
            i++;
        }
        shouldStop = false;
    }
}
