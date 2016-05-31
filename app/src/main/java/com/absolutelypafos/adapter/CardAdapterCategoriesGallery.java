package com.absolutelypafos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.absolutelypafos.Gallery;
import com.absolutelypafos.model.Movie;
import com.absolutelypafos.R;
import com.absolutelypafos.TimelinePhotos;

import java.util.ArrayList;
import java.util.List;

public class CardAdapterCategoriesGallery extends RecyclerView.Adapter<CardAdapterCategoriesGallery.ViewHolder>{

    List<Movie> mItems;
    private Activity activitystored;
    public CardAdapterCategoriesGallery(Activity activity) {
        super();
        mItems = new ArrayList<Movie>();
        activitystored = activity;

        Movie movie = new Movie();
        movie.setName("Timeline Photos");
        movie.setThumbnail(R.drawable.categorie1);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("National Theatre Live");
        movie.setThumbnail(R.drawable.categorie2);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Marathon through Antiquities");
        movie.setThumbnail(R.drawable.categorie3);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Peri Poleos");
        movie.setThumbnail(R.drawable.categorie4);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Hero-isms");
        movie.setThumbnail(R.drawable.categorie5);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Α Tribute to Nicolas Economou");
        movie.setThumbnail(R.drawable.categorie6);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("The Return of Dionysus");
        movie.setThumbnail(R.drawable.categorie7);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("In Ktima -3");
        movie.setThumbnail(R.drawable.categorie8);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Dionysis Savvopoulos");
        movie.setThumbnail(R.drawable.categorie9);
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Dancing in the Streets");
        movie.setThumbnail(R.drawable.categorie10);
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
                            Intent myIntent = new Intent(activitystored, TimelinePhotos.class);
                            activitystored.startActivity(myIntent);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 1:

                            Intent myIntent1 = new Intent(activitystored, Gallery.class);
                            activitystored.startActivity(myIntent1);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 2:
                            Intent myIntent2 = new Intent(activitystored, TimelinePhotos.class);
                            activitystored.startActivity(myIntent2);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 3:
                            Intent myIntent3 = new Intent(activitystored, TimelinePhotos.class);
                            activitystored.startActivity(myIntent3);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 4:
                            Intent myIntent4 = new Intent(activitystored, TimelinePhotos.class);
                            activitystored.startActivity(myIntent4);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 5:
                            Intent myIntent5 = new Intent(activitystored, TimelinePhotos.class);
                            activitystored.startActivity(myIntent5);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;

                        case 6:
                            Intent myIntent6 = new Intent(activitystored, TimelinePhotos.class);
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
