package com.unit.test.myrainsnowtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.unit.test.myrainsnowtest.snowfall.SnowfallView;
import com.unit.test.myrainsnowtest.snowfall.TestClass;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SnowfallView snowfallView = new SnowfallView(MainActivity.this,null);
        TestClass testClass = new TestClass();
    }
}
