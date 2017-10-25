package com.example.jaimequeraltgarrigos.moviesearcher.di;


import com.example.jaimequeraltgarrigos.moviesearcher.view.activity.MovieSearcherActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jaimequeraltgarrigos on 24/10/17.
 */
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector (modules = MovieSearchActivityModule.class)
    abstract MovieSearcherActivity movieSearcherActivity();
}
