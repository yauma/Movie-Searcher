package com.example.jaimequeraltgarrigos.moviesearcher.di;

import com.example.jaimequeraltgarrigos.moviesearcher.io.api.MoviesServices;
import com.example.jaimequeraltgarrigos.moviesearcher.io.api.RestApiManager;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * Created by jaimequeraltgarrigos on 24/10/17.
 */

@Module
class MovieSearcherActivityModule {
    @Provides
    MoviesServices providesRetrofit() {
        return RestApiManager.getInstance().create(MoviesServices.class);
    }
}
