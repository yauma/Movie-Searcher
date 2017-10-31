package com.example.jaimequeraltgarrigos.moviesearcher.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.example.jaimequeraltgarrigos.moviesearcher.MovieSearcherApp;
import com.example.jaimequeraltgarrigos.moviesearcher.interactor.MoviesInteractor;
import com.example.jaimequeraltgarrigos.moviesearcher.io.api.MoviesServices;
import com.example.jaimequeraltgarrigos.moviesearcher.io.api.RestApiManager;
import com.example.jaimequeraltgarrigos.moviesearcher.view.adapter.MovieAdapter;
import com.example.jaimequeraltgarrigos.moviesearcher.viewModel.MovieSearcherVMFactory;
import com.example.jaimequeraltgarrigos.moviesearcher.viewModel.MovieSearcherViewModel;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjectionModule;
import retrofit.Retrofit;

/**
 * Created by jaimequeraltgarrigos on 24/10/17.
 */
@Module (includes = ViewModelModule.class)
public class ApplicationModule {

    @Provides
    @Singleton
    MoviesServices provideMoviesServices() {
        return RestApiManager.getInstance().create(MoviesServices.class);
    }

    @Provides
    @Singleton
    MoviesInteractor provideMoviesInteractor(MoviesServices moviesServices) {
        return new MoviesInteractor(moviesServices);
    }

}
