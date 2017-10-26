package com.example.jaimequeraltgarrigos.moviesearcher;


import android.app.Application;

import com.example.jaimequeraltgarrigos.moviesearcher.di.DaggerMyAppComponent;
import com.example.jaimequeraltgarrigos.moviesearcher.di.MyAppComponent;

/**
 * Created by jaimequeraltgarrigos on 24/10/17.
 */

public class MovieSearcherApp extends Application {

    MyAppComponent mAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerMyAppComponent.builder().application(this).build();
    }

    public MyAppComponent getAppComponent() {
        return mAppComponent;
    }
}
