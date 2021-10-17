package com.example.calculator;


import android.app.Application;
import android.content.Context;

public class MainActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Context context = this;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}