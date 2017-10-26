package com.example.jaimequeraltgarrigos.moviesearcher.view.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.jaimequeraltgarrigos.moviesearcher.R;
import com.example.jaimequeraltgarrigos.moviesearcher.viewModel.MovieSearcherViewModel;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import io.reactivex.functions.Function;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieSearcherFragment extends Fragment {

    private MovieSearcherViewModel viewModel;
    EditText searchField;

    int page = 1;

    public MovieSearcherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_searcher, container, false);
        searchField = view.findViewById(R.id.searchEditText);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewModel = ViewModelProviders.of(this).get(MovieSearcherViewModel.class);
        RxTextView.textChanges(searchField)
                  .filter(charSequence -> charSequence.length() > 2)
                  .map(CharSequence::toString)
                  .debounce(300, TimeUnit.MILLISECONDS)
                  .subscribe(input -> {
                      viewModel.init(input, page);
                      viewModel.getMoviesList().observe(this, movies -> {

                      });
                  });

    }

}
