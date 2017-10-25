package com.example.jaimequeraltgarrigos.moviesearcher.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jaimequeraltgarrigos.moviesearcher.R;
import com.example.jaimequeraltgarrigos.moviesearcher.io.api.MoviesServices;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import retrofit.Retrofit;

public class MovieSearcherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_searcher);

    }
}
