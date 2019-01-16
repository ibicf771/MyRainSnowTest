package com.unit.test.myrainsnowtest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {

//    private WeatherAnimView weatherAnimView;

    private WeatherDynamicView weatherDynamicView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        weatherAnimView = findViewById(R.id.weather_anim_view);
        weatherDynamicView = findViewById(R.id.weather_dynamic_view);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                weatherAnimView.start();
                weatherDynamicView.start();
            }
        });
    }
}
