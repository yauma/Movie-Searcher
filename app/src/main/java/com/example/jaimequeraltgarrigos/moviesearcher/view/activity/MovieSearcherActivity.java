package com.example.jaimequeraltgarrigos.moviesearcher.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.jaimequeraltgarrigos.moviesearcher.R;
import com.example.jaimequeraltgarrigos.moviesearcher.viewModel.MovieSearcherViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class MovieSearcherActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    @Inject
    MovieSearcherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setContentView(R.layout.activity_movie_searcher);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
