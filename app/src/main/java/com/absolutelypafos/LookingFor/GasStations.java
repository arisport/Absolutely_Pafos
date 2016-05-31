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


public class GasStations extends AppCompatActivity {

    ListView list;
    String[] itemname = {

            "EKO Gas Station",
            "Petrolina Service Station",
            "LUKOIL Gas Station",
            "ESSO Gas Station",
            "ESSO Gas Station",
            "EKO Gas Station",



    };

    String[] data = {

            "Evagora Pallikaridi, Paphos, Cyprus",
            "Evagora Pallikaridi, Paphos, Cyprus",
            "Andrea Geroudi, Paphos, Cyprus",
            "Andrea Geroudi, Paphos, Cyprus",
            "Propyleon, Paphos, Cyprus",
            "Paphos, Cyprus",


    };

    Integer[] imgid = {
            R.drawable.gas,
            R.drawable.gas,
            R.drawable.gas,
            R.drawable.gas,
            R.drawable.gas,
            R.drawable.gas,



    };

    private static final int REQUEST_CODE_LOCATION = 2;
    Button fullmap;
    private GoogleMap map;
    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);

    private final LatLng LOCATION_GAS1 = new LatLng(34.776692, 32.423093);
    private final LatLng LOCATION_GAS2 = new LatLng(34.777353, 32.423588);
    private final LatLng LOCATION_GAS3 = new LatLng(34.777862, 32.424076);
    private final LatLng LOCATION_GAS4 = new LatLng(34.777977, 32.423566);
    private final LatLng LOCATION_GAS5 = new LatLng(34.775770, 32.442584);
    private final LatLng LOCATION_GAS6 = new LatLng(34.781704, 32.444560);



    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_locations);

        /*getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbarcentre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.test);


        test = (TextView) findViewById(R.id.mytext);
        test.setText("Gas Stations"); */
        list = (ListView) findViewById(R.id.listView);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.addMarker(new MarkerOptions().position(LOCATION_GAS1).title("EKO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
        map.addMarker(new MarkerOptions().position(LOCATION_GAS2).title("Petrolina Service Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
        map.addMarker(new MarkerOptions().position(LOCATION_GAS3).title("LUKOIL Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
        map.addMarker(new MarkerOptions().position(LOCATION_GAS4).title("ESSO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
        map.addMarker(new MarkerOptions().position(LOCATION_GAS5).title("ESSO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
        map.addMarker(new MarkerOptions().position(LOCATION_GAS6).title("EKO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));



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
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_GAS1, 17.0f));
                } else if (position == 1) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_GAS2, 17.0f));
                } else if (position == 2) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_GAS3, 17.0f));
                } else if (position == 3) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_GAS4, 17.0f));
                } else if (position == 4) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_GAS5, 17.0f));
                } else if (position == 5) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_GAS6, 17.0f));
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