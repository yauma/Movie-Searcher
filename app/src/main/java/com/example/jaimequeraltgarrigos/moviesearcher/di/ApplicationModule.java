package com.example.jaimequeraltgarrigos.moviesearcher.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.example.jaimequeraltgarrigos.moviesearcher.MovieSearcherApp;
import com.example.jaimequeraltgarrigos.moviesearcher.io.api.RestApiManager;
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
    Context provideContext(MovieSearcherApp application) {
        return application;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return RestApiManager.getInstance();
    }
}
