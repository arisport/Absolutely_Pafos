package com.absolutelypafos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.absolutelypafos.Interact;
import com.absolutelypafos.R;
import com.absolutelypafos.attractions.TompOfTheKings;
import com.absolutelypafos.bus.Route601;
import com.absolutelypafos.bus.Route612;
import com.absolutelypafos.bus.Route613;
import com.absolutelypafos.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class CardAdapterRoutesAirport extends RecyclerView.Adapter<CardAdapterRoutesAirport.ViewHolder>{

    List<Movie> mItems;
    private Activity activitystored;
    public CardAdapterRoutesAirport(Activity activity) {
        super();
        mItems = new ArrayList<Movie>();
        activitystored = activity;

        Movie movie = new Movie();
        movie.setName("Bus Route 612");
        movie.setInfo("Harbour Station – Paphos Airport");
        movie.setThumbnail(R.drawable.bus2);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Bus Route 613");
        movie.setInfo("Pafos (Karavella) - Pafos Airport");
        movie.setThumbnail(R.drawable.bus2);
        mItems.add(movie);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup,final int i) {
        Movie movie = mItems.get(i);
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_bus, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
        final Movie movie = mItems.get(i);
        viewHolder.tvMovie.setText(movie.getName());
        viewHolder.tvMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(activitystored, "Hello from Text", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imgThumbnail.setImageResource(movie.getThumbnail());
        viewHolder.tvinfo.setText(movie.getInfo());

    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvMovie,url,tvinfo;
        public Button  button;

        public ViewHolder(final View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvMovie = (TextView)itemView.findViewById(R.id.tv_movie);
            tvinfo = (TextView)itemView.findViewById(R.id.tv_info);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    switch (position) {
                        case 0:
                            Intent intent = new Intent(activitystored, Route612.class);
                            activitystored.startActivity(intent);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 1:
                            Intent myIntent1 = new Intent(activitystored, Route613.class);
                            activitystored.startActivity(myIntent1);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;

                        default:
                            break;
                    }


                }
            });
        }


    }
}
