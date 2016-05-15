package com.absolutelypafos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    List<Movie> mItems;
    private Activity activitystored;
    public CardAdapter(Activity activity) {
        super();
        mItems = new ArrayList<Movie>();
        activitystored = activity;
        Movie movie = new Movie();
        movie.setName("The Amazing Spider-Man 2");
        movie.setThumbnail(R.drawable.ic_home);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("X-men: Days of Future Past");
        movie.setThumbnail(R.drawable.ic_home);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("The Hunger Game");
        movie.setThumbnail(R.drawable.ic_home);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Guardians of the Galaxy");
        movie.setThumbnail(R.drawable.ic_home);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Maleficent");
        movie.setThumbnail(R.drawable.ic_home);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("How to Train Your Dragon 2");
        movie.setThumbnail(R.drawable.ic_home);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("What If");
        movie.setThumbnail(R.drawable.ic_home);
        mItems.add(movie);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup,final int i) {
        Movie movie = mItems.get(i);
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        Movie movie = mItems.get(i);
        viewHolder.tvMovie.setText(movie.getName());
        viewHolder.imgThumbnail.setImageResource(movie.getThumbnail());

    }



    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvMovie;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvMovie = (TextView)itemView.findViewById(R.id.tv_movie);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    switch (position) {
                        case 0:
                            Intent myIntent = new Intent(activitystored, Test.class);
                            activitystored.startActivity(myIntent);
                            break;

                        default:
                            break;
                    }


                }
            });
        }
    }
}
