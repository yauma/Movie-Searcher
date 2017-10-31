package com.example.jaimequeraltgarrigos.moviesearcher.viewModel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by jaimequeraltgarrigos on 26/10/17.
 */

public class MovieSearcherVMFactory implements ViewModelProvider.Factory {
    private MovieSearcherViewModel mViewModel;

    @Inject
    public MovieSearcherVMFactory(MovieSearcherViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MovieSearcherViewModel.class)) {
            return (T) mViewModel;
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
