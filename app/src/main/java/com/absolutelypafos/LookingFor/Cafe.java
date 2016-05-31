package com.absolutelypafos.LookingFor;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
import com.google.android.gms.maps.model.MarkerOptions;

public class Cafe extends AppCompatActivity {
    ListView list;
    String[] itemname = {


            "Metaxi Mas Cafe Lounge",
            "The Harbour",
            "Hobo",
            "Starbucks",
            "Muse",
            "Steve's Cafe",
            "Cafe Vienna",
            "Pingouino Cafe Lounge Bar ",
            "Alea Cafe Lounge Bar",
            "La Boite '67",
            "Suite48 Grill & Lounge Bar",
            "Arabica Coffee House",
            "Omnia 1912",
            "Hamam"

    };

    String[] data = {

            "Kato Paphos, Paphos, Cyprus",
            "Poseidonos Ave, Paphos, Cyprus",
            "Paphos Harbour",
            "Poseidonos Ave, Paphos, Cyprus",
            "Andrea Ioannou, Paphos, Cyprus",
            "Paphos Harbour",
            "Poseidonos Ave, Paphos, Cyprus",
            "Poseidonos Ave, Paphos, Cyprus",
            "Poseidonos Ave, Paphos, Cyprus",
            "Paphos Harbour",
            "Poseidonos Ave 48, Paphos",
            "Neofytou Nicolaide 1, Paphos 8011",
            "25 Martiou, Paphos, Cyprus",
            "Paphos, Cyprus"

    };

    Integer[] imgid = {
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe


    };

    private static final int REQUEST_CODE_LOCATION = 2;
    Button fullmap;
    private GoogleMap map;
    TextView actionbarcentre;
    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);
    private final LatLng LOCATION_METAXI = new LatLng(34.755402, 32.420308);
    private final LatLng LOCATION_THEHARBOUR = new LatLng(34.756043, 32.411273);
    private final LatLng LOCATION_HOBO = new LatLng(34.754816, 32.407437);
    private final LatLng LOCATION_STARBUCKS = new LatLng(34.756413, 32.417122);
    private final LatLng LOCATION_MUSE = new LatLng(34.772795, 32.419658);
    private final LatLng LOCATION_STEVES = new LatLng(34.755411, 32.407760);
    private final LatLng LOCATION_VIENNA = new LatLng(34.756209, 32.417174);
    private final LatLng LOCATION_PINGIOUNO = new LatLng(34.756363, 32.416397);
    private final LatLng LOCATION_ALEA = new LatLng(34.755966, 32.415949);
    private final LatLng LOCATION_BOIT = new LatLng(34.755308, 32.407685);
    private final LatLng LOCATION_SUIT = new LatLng(34.746893, 32.424391);
    private final LatLng LOCATION_ARABICA = new LatLng(34.775772, 32.426529);
    private final LatLng LOCATION_OMNIA = new LatLng(34.773515, 32.421774);
    private final LatLng LOCATION_HAMAM = new LatLng(34.777475, 32.419696);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_locations);

        /*getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbarcentre);

        actionbarcentre = (TextView) findViewById(R.id.mytext);
        actionbarcentre.setText("Cafe"); */

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list = (ListView) findViewById(R.id.listView);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.addMarker(new MarkerOptions().position(LOCATION_METAXI).title("Metaxi Mas Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_THEHARBOUR).title("The Harbour Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_HOBO).title("Hobo Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_STARBUCKS).title("Starbucks Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_MUSE).title("Muse Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_STEVES).title("Steve's Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_VIENNA).title("Vienna Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_PINGIOUNO).title("Pingouino Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_ALEA).title("Alea Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_BOIT).title("La Boite '67").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_SUIT).title("Suite48 Grill & Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_ARABICA).title("Arrabica Coffee shop").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_OMNIA).title("Omnia 1912 Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
        map.addMarker(new MarkerOptions().position(LOCATION_HAMAM).title("Hamam").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));

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


        fullmap = (Button) findViewById(R.id.buttonmap);
        fullmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13));
            }
        });

        CustomListAdapterRestaurants adapter = new CustomListAdapterRestaurants(this, itemname, imgid, data);
        list = (ListView) findViewById(R.id.listmap);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub

                if (position == 0) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_METAXI, 17.0f));
                } else if (position == 1) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_THEHARBOUR, 17.0f));
                } else if (position == 2) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_HOBO, 17.0f));
                } else if (position == 3) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_STARBUCKS, 17.0f));
                } else if (position == 4) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_MUSE, 17.0f));
                } else if (position == 5) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_STEVES, 17.0f));
                } else if (position == 6) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_VIENNA, 17.0f));
                } else if (position == 7) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_PINGIOUNO, 17.0f));
                } else if (position == 8) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_ALEA, 17.0f));
                } else if (position == 9) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BOIT, 17.0f));
                } else if (position == 10) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_SUIT, 17.0f));
                } else if (position == 11) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_ARABICA, 17.0f));
                } else if (position == 12) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_OMNIA, 17.0f));
                }else if (position == 13) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_HAMAM, 17.0f));
                }

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == android.R.id.home){
            this.finish();
            overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}