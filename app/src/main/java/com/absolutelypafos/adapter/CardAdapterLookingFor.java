package com.absolutelypafos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.absolutelypafos.LookingFor.ATM;
import com.absolutelypafos.LookingFor.Cafe;
import com.absolutelypafos.LookingFor.Clubs;
import com.absolutelypafos.LookingFor.GasStations;
import com.absolutelypafos.LookingFor.Hospitals;
import com.absolutelypafos.LookingFor.Museums;
import com.absolutelypafos.LookingFor.Pharmacy;
import com.absolutelypafos.model.Movie;
import com.absolutelypafos.R;
import com.absolutelypafos.LookingFor.RestaurantLocations;
import com.absolutelypafos.LookingFor.Bars;

import java.util.ArrayList;
import java.util.List;

public class CardAdapterLookingFor extends RecyclerView.Adapter<CardAdapterLookingFor.ViewHolder>{

    List<Movie> mItems;
    private Activity activitystored;
    public CardAdapterLookingFor(Activity activity) {
        super();
        mItems = new ArrayList<Movie>();
        activitystored = activity;

        Movie movie = new Movie();
        movie.setName("Restaurants");
        movie.setThumbnail(R.drawable.look1);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Bars");
        movie.setThumbnail(R.drawable.look3);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Cafe");
        movie.setThumbnail(R.drawable.look2);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Night Clubs");
        movie.setThumbnail(R.drawable.look4);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("ATM/Banks");
        movie.setThumbnail(R.drawable.look5);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Pharmacy");
        movie.setThumbnail(R.drawable.look6);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Gas Stations");
        movie.setThumbnail(R.drawable.look7);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Museums");
        movie.setThumbnail(R.drawable.look8);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Hospitals/Doctors");
        movie.setThumbnail(R.drawable.look9);
        mItems.add(movie);

       /* movie = new Movie();
        movie.setName("Dancing in the Streets");
        movie.setThumbnail(R.drawable.categorie10);
        mItems.add(movie); */


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup,final int i) {
        Movie movie = mItems.get(i);
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_item_for_looking_for, viewGroup, false);
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
                            Intent myIntent = new Intent(activitystored, RestaurantLocations.class);
                            activitystored.startActivity(myIntent);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 1:

                            Intent myIntent1 = new Intent(activitystored, Bars.class);
                            activitystored.startActivity(myIntent1);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 2:
                            Intent myIntent2 = new Intent(activitystored, Cafe.class);
                            activitystored.startActivity(myIntent2);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 3:
                            Intent myIntent3 = new Intent(activitystored, Clubs.class);
                            activitystored.startActivity(myIntent3);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 4:
                            Intent myIntent4 = new Intent(activitystored, ATM.class);
                            activitystored.startActivity(myIntent4);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 5:
                            Intent myIntent5 = new Intent(activitystored, Pharmacy.class);
                            activitystored.startActivity(myIntent5);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;

                        case 6:
                            Intent myIntent6 = new Intent(activitystored, GasStations.class);
                            activitystored.startActivity(myIntent6);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;

                        case 7:
                            Intent myIntent7 = new Intent(activitystored, Museums.class);
                            activitystored.startActivity(myIntent7);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;

                        case 8:
                            Intent myIntent8 = new Intent(activitystored, Hospitals.class);
                            activitystored.startActivity(myIntent8);
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
