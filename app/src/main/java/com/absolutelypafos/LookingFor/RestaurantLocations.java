package com.absolutelypafos.LookingFor;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.absolutelypafos.R;
import com.absolutelypafos.adapter.CustomListAdapterRestaurants;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class RestaurantLocations extends AppCompatActivity {

    ListView list;
    private static final int REQUEST_CODE_LOCATION = 2;
    Button fullmap;
    private GoogleMap map;
    TextView actionbarcentre;
    String[] itemname = {

            "Ficardo",
            "Theo's Fish Restaurant",
            "Poseidon Restaurant",
            "Mandra Tavern",
            "Hondros",
            "La vista di Daria",
            "Fiesta Bar & Grill Restaurant",
            "Poco Loco Mexican Restaurant ",
            "7 St. Georges Tavern",
            "Fettas Tavern",
            "Agora Tavern",
            "Kouridis Restaurant",
            "Vasano"

    };

    String[] data = {

            "Posidonos Ave 50A | Next to Amphora Hotel, Paphos 8042, Cyprus",
            "Apostolou Pavlou Ave, Paphos, Cyprus",
            "Apostolou Pavlou Ave, Paphos, Cyprus",
            "Dionysou, Paphos, Cyprus",
            "Apostolou Pavlou Ave, Paphos, Cyprus",
            "Kato Paphos, Paphos, Cyprus",
            "Poseidonos Cycling Lane, Paphos, Cyprus",
            "Poseidonos Cycling Lane, Paphos, Cyprus",
            "Anthipolochagou Georgiou Savva, Yeroskipou, Cyprus",
            "Paphos, Cyprus",
            "6,, Kenedy Square, Paphos 8027, Cyprus",
            "Charalampou Mouskou 1",
            "Agapinoros 26, Agapinoros, Paphos, Cyprus"

    };

    Integer[] imgid = {
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest,
            R.drawable.rest


    };
    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);
    private final LatLng LOCATION_FICARDOS = new LatLng(34.747735, 32.425675);
    private final LatLng LOCATION_THEOS = new LatLng(34.755600, 32.408305);
    private final LatLng LOCATION_POSIDONAS = new LatLng(34.755153, 32.408108);
    private final LatLng LOCATION_MANDRA = new LatLng(34.757122, 32.416374);
    private final LatLng LOCATION_HONDROS = new LatLng(34.757880, 32.412003);
    private final LatLng LOCATION_LAVISTA = new LatLng(34.755205, 32.419771);
    private final LatLng LOCATION_FIESTA = new LatLng(34.745794, 32.429291);
    private final LatLng LOCATION_POCOLOCO = new LatLng(34.743758, 32.431107);
    private final LatLng LOCATION_7GEORGE = new LatLng(34.761889, 32.441404);
    private final LatLng LOCATION_FETTAS = new LatLng(34.774059, 32.421671);
    private final LatLng LOCATION_AGORA = new LatLng(34.775247, 32.421923);
    private final LatLng LOCATION_KOURIDES = new LatLng(34.777191, 32.423446);
    private final LatLng LOCATION_VASANO = new LatLng(34.767405, 32.419095);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_locations);

        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.actionbarcentre);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //actionbarcentre = (TextView) findViewById(R.id.mytext);
        //actionbarcentre.setText("Restaurants");


        list = (ListView) findViewById(R.id.listView);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Check Permissions Now

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Display UI and wait for user interaction
            } else {
                ActivityCompat.requestPermissions(
                        this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_CODE_LOCATION);
            }
        } else {
            // permission has been granted, continue as usual
            map.setMyLocationEnabled(true);
        }



        list = (ListView) findViewById(R.id.listView);
        CustomListAdapterRestaurants adapter = new CustomListAdapterRestaurants(this, itemname, imgid, data);
        list = (ListView) findViewById(R.id.listmap);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

                if (position == 0) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_FICARDOS, 17.0f));
                } else if (position == 1) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_THEOS, 17.0f));
                } else if (position == 2) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_POSIDONAS, 17.0f));
                } else if (position == 3) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_MANDRA, 17.0f));
                } else if (position == 4) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_HONDROS, 17.0f));
                } else if (position == 5) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_LAVISTA, 17.0f));
                } else if (position == 6) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_FIESTA, 17.0f));
                } else if (position == 7) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_POCOLOCO, 17.0f));
                } else if (position == 8) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_7GEORGE, 17.0f));
                } else if (position == 9) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_FETTAS, 17.0f));
                } else if (position == 10) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_AGORA, 17.0f));
                } else if (position == 11) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_KOURIDES, 17.0f));
                } else if (position == 12) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_VASANO, 17.0f));
                }

            }

        });



        fullmap = (Button) findViewById(R.id.buttonmap);
        fullmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13));
            }
        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_FICARDOS)
                .title("Ficardo Restaurant")
                .snippet("Poseidonos ave 50A, 8042\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "+357 26 960184")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_THEOS)
                .title("Theo's Seafood Restaurant")
                .snippet("Paphos Harbor, 8046\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "+35726932829")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_POSIDONAS)
                .title("Poseidonas Restaurant")
                .snippet("Paphos Harbor, 8046\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "+35726939400")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_MANDRA)
                .title("Mandra Tavern")
                .snippet("4, Dionysou Str 8041\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "00357-26934129")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_HONDROS)
                .title("Hondros Tavern")
                .snippet("96 Apostolos Pavlos Ave, 8020,\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "00357-26934256")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_LAVISTA)
                .title("La vista Tavern")
                .snippet("Iasonos Ave,8025,\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "00357-26934256")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_FIESTA)
                .title("Fiesta Bar & Grill")
                .snippet("Avanti Village\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_POCOLOCO)
                .title("Poco Loco Mexican Restaurant ")
                .snippet("Poseidonos Cycling Lane,Yeroskipou\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "+357 99 424441")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_7GEORGE)
                .title("7 St. Georges Tavern")
                .snippet("Anthipolochagou Georgiou Savva\n" +
                        "\n" +
                        ", Yeroskipou, Cyprus\n" +
                        "\n" +
                        "+357 26 963176")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_FETTAS)
                .title("Fettas Tavern")
                .snippet("6, Kenedy Square\n" +
                        "\n" +
                        "Paphos 8027, Cyprus\n" +
                        "\n" +
                        "2693 7822")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_AGORA)
                .title("Agora Tavern")
                .snippet("6, Kenedy Square\n" +
                        "\n" +
                        "Paphos 8047, Cyprus\n" +
                        "\n" +
                        "99611817")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_KOURIDES)
                .title("Kouridis Restaurant")
                .snippet("Charalampou Mouskou 1\n" +
                        "\n" +
                        "Paphos 8010, Cyprus\n" +
                        "\n" +
                        "+357 26 249182")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        map.addMarker(new MarkerOptions()
                .position(LOCATION_VASANO)
                .title("Vasano Restaurant")
                .snippet("Agapinoros 26 \n" +
                        "\n" +
                        "Kato Paphos, Cyprus\n" +
                        "\n" +
                        "+357 26 942635")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_restaurants_locations, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
