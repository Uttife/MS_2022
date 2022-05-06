package com.utifeinc.myshelter;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //simulating app initialization by making thread pause for 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //I dey set the theme back to the regular theme after splashScreen
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

    }
}