package com.example.jaimequeraltgarrigos.moviesearcher.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaimequeraltgarrigos.moviesearcher.R;
import com.example.jaimequeraltgarrigos.moviesearcher.model.Movie;
import com.example.jaimequeraltgarrigos.moviesearcher.utils.MyConstant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaimequeraltgarrigos on 6/11/16.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> mDataSet;
    private final Context context;

    /*
        private static MyClickListener myClickListener;
    */
    public MovieAdapter(Context context) {
        this.mDataSet = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(v);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        MovieViewHolder holder = (MovieViewHolder) viewHolder;
        Movie movie = mDataSet.get(position);
        try {
            holder.textViewMovie.setText(movie.getOriginalTitle());
            Picasso.with(context).load(MyConstant.IMAGE_BASE_URL + movie.getBackdropPath()).into(holder.imageViewMovie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public void addMovies(ArrayList<Movie> movieArrayList) {
        List<Movie> moviesFiltered = filterMovies(movieArrayList);
        mDataSet.clear();
        mDataSet.addAll(moviesFiltered);
        this.notifyDataSetChanged();
    }

    private List<Movie> filterMovies(ArrayList<Movie> movieArrayList) {
        List<Movie> moviesFiltered = new ArrayList<>();
        for (Movie movie : movieArrayList) {
            if ((movie.getAdult() != null) && movie.getBackdropPath() != null && movie.getOriginalTitle() != null) {
                moviesFiltered.add(movie);
            }
        }
        return moviesFiltered;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View v) {
            super(v);
        }
    }

    public static class MovieViewHolder extends ViewHolder {
        ImageView imageViewMovie;
        TextView textViewMovie;

        public MovieViewHolder(View itemView) {
            super(itemView);
            imageViewMovie = itemView.findViewById(R.id.imageViewMovie);
            textViewMovie = itemView.findViewById(R.id.textViewTitle);
        }

    }
}


