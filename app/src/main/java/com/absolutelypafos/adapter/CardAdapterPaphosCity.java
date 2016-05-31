package com.absolutelypafos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.absolutelypafos.CategoriesGalleryFragment;
import com.absolutelypafos.R;
import com.absolutelypafos.Videos;
import com.absolutelypafos.model.Movie;
import com.absolutelypafos.webviews.AboutCyprusWebView;
import com.absolutelypafos.webviews.EntryWebView;
import com.absolutelypafos.webviews.MessageWebView;
import com.absolutelypafos.webviews.OurLogoWebView;
import com.absolutelypafos.webviews.TheInstitutionWebView;

import java.util.ArrayList;
import java.util.List;

public class CardAdapterPaphosCity extends RecyclerView.Adapter<CardAdapterPaphosCity.ViewHolder>{

    List<Movie> mItems;
    private Activity activitystored;
    public CardAdapterPaphosCity(Activity activity) {
        super();
        mItems = new ArrayList<Movie>();
        activitystored = activity;
        Movie movie = new Movie();
        movie.setName("About Cyprus");
        movie.setThumbnail(R.drawable.aboutcyprus);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Entry requirements");
        movie.setThumbnail(R.drawable.aboutcyprus3);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Accessible Cyprus");
        movie.setThumbnail(R.drawable.aboutcyprus2);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Climate & weather");
        movie.setThumbnail(R.drawable.institution4);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Time, Working Hours & Holidays");
        movie.setThumbnail(R.drawable.institution5);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Health & Safety");
        movie.setThumbnail(R.drawable.institution6);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Travellers Handbook");
        movie.setThumbnail(R.drawable.institution7);
        mItems.add(movie);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup,final int i) {
        Movie movie = mItems.get(i);
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_visit, viewGroup, false);
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
            Typeface face = Typeface.createFromAsset(activitystored.getAssets(),
                    "fonts/note.ttf");
            tvMovie.setTypeface(face);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    switch (position) {
                        case 0:
                            Intent myIntent = new Intent(activitystored, AboutCyprusWebView.class);
                            activitystored.startActivity(myIntent);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 1:

                            Intent myIntent1 = new Intent(activitystored, EntryWebView.class);
                            activitystored.startActivity(myIntent1);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 2:
                            Intent myIntent2 = new Intent(activitystored, OurLogoWebView.class);
                            activitystored.startActivity(myIntent2);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 3:
                            Intent myIntent3 = new Intent(activitystored, TheInstitutionWebView.class);
                            activitystored.startActivity(myIntent3);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 4:
                            Intent myIntent4 = new Intent(activitystored, MessageWebView.class);
                            activitystored.startActivity(myIntent4);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 5:
                            Intent myIntent5 = new Intent(activitystored, CategoriesGalleryFragment.class);
                            activitystored.startActivity(myIntent5);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;

                        case 6:
                            Intent myIntent6 = new Intent(activitystored, Videos.class);
                            activitystored.startActivity(myIntent6);
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
