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


public class Hospitals extends AppCompatActivity {
    ListView list;
    String[] itemname = {

            "Paphos General Hospital",
            "Iasis Private Hospital",
            "Elpis Medical Centre",
            "Blue Cross Medical Center",
            "Evangelismos Private Hospital",
            "Polis Hospital",
            "Peyia Medical Centre"



    };

    String[] data = {

            "Anavargos, Paphos, Cyprus",
            "Voriou Ipirou, 8, Paphos 8069, Cyprus",
            "Agapinoros 68, Paphos 61567, Cyprus",
            "Propyleon, Paphos, Cyprus",
            "87, Vasileos Konstantinou, Paphos 8062, Cyprus",
            "Thessalonikis, Poli Crysochous, Cyprus",
            "E709 58C&D, Peyia, Cyprus"


    };

    Integer[] imgid = {
            R.drawable.hospitals,
            R.drawable.hospitals,
            R.drawable.hospitals,
            R.drawable.hospitals,
            R.drawable.hospitals,
            R.drawable.hospitals,
            R.drawable.hospitals



    };

    private static final int REQUEST_CODE_LOCATION = 2;
    Button fullmap;
    private GoogleMap map;
    private final LatLng LOCATION_GENERAL = new LatLng(34.767930, 32.429412);

    private final LatLng LOCATION_HO1 = new LatLng(34.788938, 32.445816);
    private final LatLng LOCATION_HO2 = new LatLng(34.762777, 32.438376);
    private final LatLng LOCATION_HO3 = new LatLng(34.762624, 32.417803);
    private final LatLng LOCATION_HO4 = new LatLng(34.776441, 32.442686);
    private final LatLng LOCATION_HO5 = new LatLng(34.786543, 32.437999);
    private final LatLng LOCATION_HO6 = new LatLng(35.039136, 32.424377);
    private final LatLng LOCATION_HO7 = new LatLng(34.874919, 32.379171);



    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_locations);

       /* getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbarcentre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.test);


        test = (TextView) findViewById(R.id.mytext);
        test.setText("Hospitals/Doctors"); */
        list = (ListView) findViewById(R.id.listView);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.addMarker(new MarkerOptions().position(LOCATION_HO1).title("Paphos General Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
        map.addMarker(new MarkerOptions().position(LOCATION_HO2).title("Iasis Private Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
        map.addMarker(new MarkerOptions().position(LOCATION_HO3).title("Elpis Medical Centre").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
        map.addMarker(new MarkerOptions().position(LOCATION_HO4).title("Blue Cross Medical Center").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
        map.addMarker(new MarkerOptions().position(LOCATION_HO5).title("Evangelismos Private Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
        map.addMarker(new MarkerOptions().position(LOCATION_HO6).title("Polis Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
        map.addMarker(new MarkerOptions().position(LOCATION_HO7).title("Peyia Medical Centre").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));



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
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_HO1, 17.0f));
                } else if (position == 1) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_HO2, 17.0f));
                } else if (position == 2) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_HO3, 17.0f));
                } else if (position == 3) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_HO4, 17.0f));
                } else if (position == 4) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_HO5, 17.0f));
                } else if (position == 5) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_HO6, 17.0f));
                } else if (position == 6) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_HO7, 17.0f));
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