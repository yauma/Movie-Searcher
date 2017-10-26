package com.example.jaimequeraltgarrigos.moviesearcher.di;

import android.arch.lifecycle.ViewModelProvider;

import com.example.jaimequeraltgarrigos.moviesearcher.interactor.MoviesInteractor;
import com.example.jaimequeraltgarrigos.moviesearcher.io.api.MoviesServices;
import com.example.jaimequeraltgarrigos.moviesearcher.viewModel.MovieSearcherVMFactory;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * Created by jaimequeraltgarrigos on 25/10/17.
 */

@Module
class MovieSearchActivityModule {
    @Provides
    MoviesInteractor provideMainViewModel(Retrofit retrofit) {
        return new MoviesInteractor(retrofit.create(MoviesServices.class));
    }


}
