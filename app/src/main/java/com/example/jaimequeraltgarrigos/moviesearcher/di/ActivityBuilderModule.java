package com.example.jaimequeraltgarrigos.moviesearcher.di;


import com.example.jaimequeraltgarrigos.moviesearcher.view.activity.MovieSearcherActivity;
import com.example.jaimequeraltgarrigos.moviesearcher.view.fragment.MovieSearcherFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jaimequeraltgarrigos on 24/10/17.
 */
@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract MovieSearcherActivity movieSearcherActivity();

    @ContributesAndroidInjector
    abstract MovieSearcherFragment contributeMovieSearcherFragment();
}
