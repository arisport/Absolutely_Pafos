package com.absolutelypafos.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.absolutelypafos.Interact;
import com.absolutelypafos.Map;
import com.absolutelypafos.R;
import com.absolutelypafos.Search;
import com.absolutelypafos.attractions.AyiaKyriakiChrysopolitissa;
import com.absolutelypafos.attractions.ChrysorrogiatissaMonastery;
import com.absolutelypafos.attractions.LaraBayTurtleConservationStation;
import com.absolutelypafos.attractions.PafosZoo;
import com.absolutelypafos.attractions.PaphosCastle;
import com.absolutelypafos.attractions.PaphosPark;
import com.absolutelypafos.attractions.RockofAphrodite;
import com.absolutelypafos.attractions.SaintNeofytosMonastery;
import com.absolutelypafos.attractions.SaintPaulsPillar;
import com.absolutelypafos.attractions.TheHouseOfDionysus;
import com.absolutelypafos.attractions.TompOfTheKings;
import com.absolutelypafos.attractions.VouniPanayiasWinery;
import com.absolutelypafos.model.Movie;
import com.absolutelypafos.webviews.MoreInformation;

import java.util.ArrayList;
import java.util.List;

public class CardAdapterMaps extends RecyclerView.Adapter<CardAdapterMaps.ViewHolder>{

    List<Movie> mItems;
    private Activity activitystored;
    public final static String MESSAGE_ATTRACTIONS = "com.absolutelypafos.MESSAGE";
    public CardAdapterMaps(Activity activity) {
        super();
        mItems = new ArrayList<Movie>();
        activitystored = activity;

        Movie movie = new Movie();
        movie.setName("All Locations");
        movie.setThumbnail(R.drawable.map);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Take Me There");
        movie.setThumbnail(R.drawable.map2);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Around me");
        movie.setThumbnail(R.drawable.map3);
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
        final Movie movie = mItems.get(i);
        viewHolder.tvMovie.setText(movie.getName());
        viewHolder.tvMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(activitystored, "Hello from Text", Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.imgThumbnail.setImageResource(movie.getThumbnail());

    }


    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvMovie,url;
        public Button  button;

        public ViewHolder(final View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvMovie = (TextView)itemView.findViewById(R.id.tv_movie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    switch (position) {
                        case 0:
                            Intent intent = new Intent(activitystored, Map.class);
                            activitystored.startActivity(intent);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 1:
                            Intent myIntent1 = new Intent(activitystored, Interact.class);
                            activitystored.startActivity(myIntent1);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 2:
                            Intent myIntent2 = new Intent(activitystored, Search.class);
                            activitystored.startActivity(myIntent2);
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
