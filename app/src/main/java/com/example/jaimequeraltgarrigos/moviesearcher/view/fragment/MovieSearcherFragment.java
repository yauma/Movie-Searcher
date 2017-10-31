package com.example.jaimequeraltgarrigos.moviesearcher.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;

import com.example.jaimequeraltgarrigos.moviesearcher.MovieSearcherApp;
import com.example.jaimequeraltgarrigos.moviesearcher.R;
import com.example.jaimequeraltgarrigos.moviesearcher.model.Movie;
import com.example.jaimequeraltgarrigos.moviesearcher.view.adapter.MovieAdapter;
import com.example.jaimequeraltgarrigos.moviesearcher.viewModel.MovieSearcherViewModel;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieSearcherFragment extends Fragment {

    @Inject
    MovieSearcherViewModel viewModel;

    MovieAdapter adapter;

    EditText searchField;
    RecyclerView recyclerView;

    int page = 1;

    public MovieSearcherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_searcher, container, false);
        searchField = view.findViewById(R.id.searchEditText);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MovieAdapter(getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RxTextView.textChanges(searchField)
                  .filter(charSequence -> charSequence.length() > 2)
                  .map(CharSequence::toString)
                  .debounce(300, TimeUnit.MILLISECONDS)
                  .subscribe((String input) -> {
                      viewModel.init(input, page);
                      viewModel.getMoviesList().observe(this, movies -> {
                          adapter.addMovies((ArrayList<Movie>) movies.getMovies());
                      });
                  });

    }

}
