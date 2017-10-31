package com.example.jaimequeraltgarrigos.moviesearcher;


import android.app.Activity;
import android.app.Application;

import com.example.jaimequeraltgarrigos.moviesearcher.di.DaggerMyAppComponent;
import com.example.jaimequeraltgarrigos.moviesearcher.view.adapter.MovieAdapter;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by jaimequeraltgarrigos on 24/10/17.
 */

public class MovieSearcherApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
    }
    public MovieSearcherApp() {
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    private void initializeComponent() {
        DaggerMyAppComponent.builder()
                          .application(this)
                          .build()
                          .inject(this);
    }
}
