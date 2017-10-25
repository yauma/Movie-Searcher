package com.example.jaimequeraltgarrigos.moviesearcher.interactor;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.jaimequeraltgarrigos.moviesearcher.io.api.MoviesServices;
import com.example.jaimequeraltgarrigos.moviesearcher.model.MoviesResponse;

import retrofit.http.Query;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jaimequeraltgarrigos on 22/10/17.
 */

public class MoviesInteractor {
    MoviesServices services;

    public MoviesInteractor(MoviesServices services) {
        this.services = services;
    }

    public LiveData<MoviesResponse> getSearchMovies(String apiKey, String query, int page) {
        final MutableLiveData<MoviesResponse> data = new MutableLiveData<>();
        services.getSearch(apiKey, query, page).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(moviesResponse -> {
                    data.setValue(moviesResponse);
                });

        return data;
    }

    ;
}
