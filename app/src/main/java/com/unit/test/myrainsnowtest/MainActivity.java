package com.unit.test.myrainsnowtest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

    private View lightningLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lightningLayout = findViewById(R.id.lightning_layout);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                lightningLayout.setVisibility(View.VISIBLE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        lightningLayout.setVisibility(View.GONE);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                lightningLayout.setVisibility(View.VISIBLE);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        lightningLayout.setVisibility(View.GONE);
                                    }
                                }, 100);
                            }
                        }, 100);
                    }
                }, 100);
            }
        }, 1000);

//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                lightningLayout.setVisibility(View.VISIBLE);
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        lightningLayout.setVisibility(View.GONE);
//                    }
//                },200);
//            }
//        }, 1200);
//
//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//
//            }
//        };
//        timer.schedule(timerTask, 1000, 10);
    }
}
