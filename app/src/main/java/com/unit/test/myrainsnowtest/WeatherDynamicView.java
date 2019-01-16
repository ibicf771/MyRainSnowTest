package com.unit.test.myrainsnowtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by yangsimin on 2019/1/16.
 */

public class WeatherDynamicView extends RelativeLayout {

    private WeatherAnimView weatherAnimView;

    private ViewGroup weatherDynamicLayout;

    public WeatherDynamicView(Context context){
        this(context, null);
    }

    public WeatherDynamicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.weather_dynamic_view, this, true);
        weatherAnimView = new WeatherAnimView(context);
        weatherDynamicLayout = findViewById(R.id.weather_dynamic_layout);
    }

    public void start(){
        weatherDynamicLayout.addView(weatherAnimView);
        weatherAnimView.start(new WeatherAnimView.OnWeatherAnimListener() {
            @Override
            public void onWeatherAnimFinish() {
                weatherDynamicLayout.removeView(weatherAnimView);
            }
        });
    }

    public void stop(){
        weatherDynamicLayout.removeView(weatherAnimView);
    }
}
