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
import android.widget.Toast;

import com.absolutelypafos.R;
import com.absolutelypafos.model.Movie;
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
import com.absolutelypafos.webviews.MoreInformation;

import java.util.ArrayList;
import java.util.List;

public class CardAdapterAttractions extends RecyclerView.Adapter<CardAdapterAttractions.ViewHolder>{

    List<Movie> mItems;
    private Activity activitystored;
    public final static String MESSAGE_ATTRACTIONS = "com.absolutelypafos.MESSAGE";
    public CardAdapterAttractions(Activity activity) {
        super();
        mItems = new ArrayList<Movie>();
        activitystored = activity;

        Movie movie = new Movie();
        movie.setName("Paphos Archaeological Park");
        movie.setThumbnail(R.drawable.attra1);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d527731-Reviews-Kato_Paphos_Archaeological_Park-Paphos_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Paphos Castle");
        movie.setThumbnail(R.drawable.attra2);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d2324885-Reviews-Paphos_Harbour_Castle-Paphos_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Tombs of the Kings");
        movie.setThumbnail(R.drawable.attra3);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d313655-Reviews-Tombs_of_the_Kings-Paphos_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("St Pauls's Pillar");
        movie.setThumbnail(R.drawable.attra4);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d4312361-Reviews-Saint_Paul_s_Pillar-Paphos_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Ayios Neofytos Monastery");
        movie.setThumbnail(R.drawable.attra5);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d531773-Reviews-Ayios_Neophytos_Monastery-Paphos_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Chrysoroyiatissa Monastery");
        movie.setThumbnail(R.drawable.attra6);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d2328352-Reviews-Chrysorrogiatissa_Monastery-Paphos_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Aphrodite's Rock");
        movie.setThumbnail(R.drawable.attra7);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g850702-d878112-Reviews-Aphrodite_s_Rock-Kouklia_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("The House of Dionysus");
        movie.setThumbnail(R.drawable.attra8);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d6755801-Reviews-The_House_of_Dionysus-Paphos_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Ayia Kyriaki Chrysopolitissa");
        movie.setThumbnail(R.drawable.attra9);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d6503324-Reviews-Church_of_Agia_Kyriaki_and_post_St_Paul-Paphos_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Lara Bay Turtle Conservation Station");
        movie.setThumbnail(R.drawable.attra10);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d3398669-Reviews-Lara_Bay_Turtle_Conservation_Station-Paphos_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Vouni Panayia Winery");
        movie.setThumbnail(R.drawable.attra11);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d4267898-Reviews-Vouni_Panayia_Winery-Paphos_Paphos_District.html");
        mItems.add(movie);

        movie = new Movie();
        movie.setName("Pafos Zoo");
        movie.setThumbnail(R.drawable.attra12);
        movie.setInfo("https://www.tripadvisor.co.uk/Attraction_Review-g190384-d675783-Reviews-Pafos_Zoo-Paphos_Paphos_District.html");
        mItems.add(movie);


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup,final int i) {
        Movie movie = mItems.get(i);
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_item_attractions, viewGroup, false);
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
        viewHolder.url.setText(movie.getInfo());
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
            url = (TextView) itemView.findViewById(R.id.Url);
            url.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(activitystored)
                            .setTitle("Internet Connection Access")
                            .setMessage("Do you have active internet connection?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    int position = getAdapterPosition();
                                    String content = mItems.get(position).getInfo();
                                    Intent intent = new Intent(activitystored, MoreInformation.class);
                                    intent.putExtra(MESSAGE_ATTRACTIONS, content);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    activitystored.startActivity(intent);
                                    activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    int position = getAdapterPosition();
                                    switch (position) {
                                        case 0:
                                            Intent intent = new Intent(activitystored, PaphosPark.class);
                                            activitystored.startActivity(intent);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;
                                        case 1:
                                            Intent myIntent1 = new Intent(activitystored, PaphosCastle.class);
                                            activitystored.startActivity(myIntent1);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;
                                        case 2:
                                            Intent myIntent2 = new Intent(activitystored, TompOfTheKings.class);
                                            activitystored.startActivity(myIntent2);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;
                                        case 3:
                                            Intent myIntent3 = new Intent(activitystored, SaintPaulsPillar.class);
                                            activitystored.startActivity(myIntent3);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;
                                        case 4:
                                            Intent myIntent4 = new Intent(activitystored, SaintNeofytosMonastery.class);
                                            activitystored.startActivity(myIntent4);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;
                                        case 5:
                                            Intent myIntent5 = new Intent(activitystored, ChrysorrogiatissaMonastery.class);
                                            activitystored.startActivity(myIntent5);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;

                                        case 6:
                                            Intent myIntent6 = new Intent(activitystored, RockofAphrodite.class);
                                            activitystored.startActivity(myIntent6);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;
                                        case 7:
                                            Intent myIntent7 = new Intent(activitystored, TheHouseOfDionysus.class);
                                            activitystored.startActivity(myIntent7);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;
                                        case 8:
                                            Intent myIntent8 = new Intent(activitystored, AyiaKyriakiChrysopolitissa.class);
                                            activitystored.startActivity(myIntent8);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;
                                        case 9:
                                            Intent myIntent9 = new Intent(activitystored, LaraBayTurtleConservationStation.class);
                                            activitystored.startActivity(myIntent9);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;
                                        case 10:
                                            Intent myIntent10 = new Intent(activitystored, VouniPanayiasWinery.class);
                                            activitystored.startActivity(myIntent10);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;
                                        case 11:
                                            Intent myIntent11 = new Intent(activitystored, PafosZoo.class);
                                            activitystored.startActivity(myIntent11);
                                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                                            break;

                                        default:
                                            break;
                                    }
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                    /*

                    //Toast.makeText(activitystored,"Position:"+position, Toast.LENGTH_SHORT).show(); */
                }
            });
           // button = (Button)itemView.findViewById(R.id.button1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    switch (position) {
                        case 0:
                            Intent intent = new Intent(activitystored, PaphosPark.class);
                            activitystored.startActivity(intent);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 1:
                            Intent myIntent1 = new Intent(activitystored, PaphosCastle.class);
                            activitystored.startActivity(myIntent1);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 2:
                            Intent myIntent2 = new Intent(activitystored, TompOfTheKings.class);
                            activitystored.startActivity(myIntent2);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 3:
                            Intent myIntent3 = new Intent(activitystored, SaintPaulsPillar.class);
                            activitystored.startActivity(myIntent3);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 4:
                            Intent myIntent4 = new Intent(activitystored, SaintNeofytosMonastery.class);
                            activitystored.startActivity(myIntent4);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 5:
                            Intent myIntent5 = new Intent(activitystored, ChrysorrogiatissaMonastery.class);
                            activitystored.startActivity(myIntent5);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;

                        case 6:
                            Intent myIntent6 = new Intent(activitystored, RockofAphrodite.class);
                            activitystored.startActivity(myIntent6);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 7:
                            Intent myIntent7 = new Intent(activitystored, TheHouseOfDionysus.class);
                            activitystored.startActivity(myIntent7);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 8:
                            Intent myIntent8 = new Intent(activitystored, AyiaKyriakiChrysopolitissa.class);
                            activitystored.startActivity(myIntent8);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 9:
                            Intent myIntent9 = new Intent(activitystored, LaraBayTurtleConservationStation.class);
                            activitystored.startActivity(myIntent9);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 10:
                            Intent myIntent10 = new Intent(activitystored, VouniPanayiasWinery.class);
                            activitystored.startActivity(myIntent10);
                            activitystored.overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                            break;
                        case 11:
                            Intent myIntent11 = new Intent(activitystored, PafosZoo.class);
                            activitystored.startActivity(myIntent11);
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
