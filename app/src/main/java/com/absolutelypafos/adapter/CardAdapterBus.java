package com.absolutelypafos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
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
import com.absolutelypafos.bus.AirportRoutes;
import com.absolutelypafos.bus.PafosRoutes;
import com.absolutelypafos.bus.PaphosVillagesBusRoutes;
import com.absolutelypafos.bus.PolisLatchiRoutes;
import com.absolutelypafos.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class CardAdapterBus extends RecyclerView.Adapter<CardAdapterBus.ViewHolder>{

    List<Movie> mItems;
    private Activity activitystored;
    public final static String MESSAGE_ATTRACTIONS = "com.absolutelypafos.MESSAGE";
    public CardAdapterBus(Activity activity) {
        super();
        mItems = new ArrayList<Movie>();
        activitystored = activity;

        Movie movie = new Movie();
        movie.setName("Paphos City & Suburbs Routes");
        movie.setInfo("Bus route details, timetable and interactive map for Paphos City & Suburbs Routes.");
        movie.setThumbnail(R.drawable.bus1);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Paphos Villages Bus Routes");
        movie.setInfo("Bus route details, timetable and interactive map for Paphos Villages Bus Routes.");
        movie.setThumbnail(R.drawable.bus);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Polis & Latchi Bus Routes");
        movie.setInfo("Bus route details, timetable and interactive map for Polis & Latchi Bus Routes.");
        movie.setThumbnail(R.drawable.bus3);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Paphos Airport Bus Routes");
        movie.setInfo("Bus route details, timetable and interactive map for Paphos Airport Bus Routes.");
        movie.setThumbnail(R.drawable.bus2);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Main Bus Stations");
        movie.setInfo("- Karavella Main Bus Station\n" +
                "- Kato Paphos Main Bus Station\n" +
                "- Polis Main Bus Station");
        movie.setThumbnail(R.drawable.bus5);
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
        public TextView tvMovie,url, tvinfo;
        public Button  button;

        public ViewHolder(final View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvMovie = (TextView)itemView.findViewById(R.id.tv_movie);
            tvinfo = (TextView)itemView.findViewById(R.id.tv_info);
            tvMovie.setTextSize(14);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    switch (position) {
                        case 0:
                            Intent intent = new Intent(activitystored, PafosRoutes.class);
                            activitystored.startActivity(intent);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 1:
                            Intent myIntent1 = new Intent(activitystored, PaphosVillagesBusRoutes.class);
                            activitystored.startActivity(myIntent1);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 2:
                            Intent myIntent2 = new Intent(activitystored, PolisLatchiRoutes.class);
                            activitystored.startActivity(myIntent2);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 3:
                            Intent myIntent3 = new Intent(activitystored, AirportRoutes.class);
                            activitystored.startActivity(myIntent3);
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
