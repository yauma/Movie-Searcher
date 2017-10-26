package com.example.jaimequeraltgarrigos.moviesearcher.view.activity;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jaimequeraltgarrigos.moviesearcher.MovieSearcherApp;
import com.example.jaimequeraltgarrigos.moviesearcher.R;
import com.example.jaimequeraltgarrigos.moviesearcher.interactor.MoviesInteractor;
import com.example.jaimequeraltgarrigos.moviesearcher.io.api.MoviesServices;
import com.example.jaimequeraltgarrigos.moviesearcher.viewModel.MovieSearcherVMFactory;
import com.example.jaimequeraltgarrigos.moviesearcher.viewModel.MovieSearcherViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit.Retrofit;

public class MovieSearcherActivity extends AppCompatActivity {
    @Inject
    MovieSearcherViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MovieSearcherApp) getApplication()).getAppComponent().inject(this);
        setContentView(R.layout.activity_movie_searcher);
    }
}
