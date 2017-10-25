package com.example.jaimequeraltgarrigos.moviesearcher.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.jaimequeraltgarrigos.moviesearcher.interactor.MoviesInteractor;
import com.example.jaimequeraltgarrigos.moviesearcher.io.api.MoviesServices;
import com.example.jaimequeraltgarrigos.moviesearcher.io.api.RestApiManager;
import com.example.jaimequeraltgarrigos.moviesearcher.model.MoviesResponse;
import com.example.jaimequeraltgarrigos.moviesearcher.utils.MyConstant;

/**
 * Created by jaimequeraltgarrigos on 22/10/17.
 */

public class MovieSearcherViewModel extends ViewModel {
    LiveData<MoviesResponse> moviesList;
    MoviesInteractor interactor;

    public MovieSearcherViewModel() {
        interactor = new MoviesInteractor(RestApiManager.getInstance().create(MoviesServices.class));
    }

    public void init(String name, int page) {
        moviesList = interactor.getSearchMovies(MyConstant.API_KEY, name, page);
    }

    public LiveData<MoviesResponse> getMoviesList() {
        return moviesList;
    }
}
