package com.utifeinc.myshelter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        println("test1");
    }
}