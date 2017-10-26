package com.example.jaimequeraltgarrigos.moviesearcher.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.jaimequeraltgarrigos.moviesearcher.viewModel.MovieSearcherVMFactory;
import com.example.jaimequeraltgarrigos.moviesearcher.viewModel.MovieSearcherViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by mertsimsek on 19/06/2017.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieSearcherViewModel.class)
    abstract ViewModel bindsMovieListViewModel(MovieSearcherViewModel movieListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(MovieSearcherVMFactory movieViewModelFactory);
}
