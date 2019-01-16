package com.unit.test.myrainsnowtest;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;

import com.unit.test.myrainsnowtest.panningview.PanningView;

/**
 * Created by yangsimin on 2019/1/15.
 */

public class WeatherAnimView extends RelativeLayout {

    private View lightningLayout;

    private PanningView cloudBehind, cloudHead;

    private final Handler handler = new Handler();

    public WeatherAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.weather_anim_view, this, true);


        lightningLayout = findViewById(R.id.lightning_layout);
        cloudBehind = findViewById(R.id.cloud_behind);
        cloudHead = findViewById(R.id.cloud_head);
    }

    public void start() {
        cloudBehind.start();
        cloudHead.start();
        lightning();
        setViewAppear();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setViewDisappear();
            }
        }, 6000);
    }

    private void lightning() {
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
        }, 2000);
    }

    public void setViewAppear() {
        /**
         * @param fromAlpha 开始的透明度，取值是0.0f~1.0f，0.0f表示完全透明， 1.0f表示和原来一样
         * @param toAlpha 结束的透明度，同上
         */
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
        //设置动画持续时长
        alphaAnimation.setDuration(1000);
        //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
        alphaAnimation.setFillAfter(true);
        //开始动画
        startAnimation(alphaAnimation);
        setVisibility(VISIBLE);
    }

    public void setViewDisappear() {
        /**
         * @param fromAlpha 开始的透明度，取值是0.0f~1.0f，0.0f表示完全透明， 1.0f表示和原来一样
         * @param toAlpha 结束的透明度，同上
         */
        AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);
        //设置动画持续时长
        alphaAnimation.setDuration(1000);
        //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
        alphaAnimation.setFillAfter(true);
        //开始动画
        startAnimation(alphaAnimation);
        setVisibility(GONE);
    }
}
