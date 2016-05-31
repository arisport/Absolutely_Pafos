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


public class ATM extends AppCompatActivity {

    ListView list;
    String[] itemname = {

            "Bank of Cyprus 0660",
            "Bank of Cyprus 0669",
            "Bank of Cyprus 0678",
            "Ethniki Bank 5451",
            "Pireus Bank",
            "Alpha Bank",
            "Bank of Cyprus 0603",
            "Hellenic Bank",
            "Bank of Cyprus",
            "Hellenic Bank",
            "National Bank of Greece (Cyprus)",


    };

    String[] data = {

            "Euagora Pallikaridi,Paphos,Cyprus",
            "Tombs of the Kings Ave 26, Paphos 8046, Cyprus",
            "1, Akamantidos str., Paphos 8020, Cyprus",
            "Arch Makariou III Avenue 55, Yeroskipou 8200, Cyprus",
            "Theodorou Kolokotroni, Paphos,Cyprus",
            "Poseidonos Ave, Paphos, Cyprus",
            "Poseidonos Ave & Danaes, Blue Horizon Court",
            "Danae's Triangle, Paphos, Cyprus",
            "Poseidonos Ave, Paphos, Cyprus",
            "Nicodemou Milona, Paphos, Cyprus",
            "Arch. Makariou III Ave, Paphos, Cyprus",

    };

    Integer[] imgid = {
            R.drawable.atm,
            R.drawable.atm,
            R.drawable.atm,
            R.drawable.atm,
            R.drawable.atm,
            R.drawable.atm,
            R.drawable.atm,
            R.drawable.atm,
            R.drawable.atm,
            R.drawable.atm,
            R.drawable.atm


    };

    private static final int REQUEST_CODE_LOCATION = 2;
    Button fullmap;
    private GoogleMap map;
    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);
    private final LatLng LOCATION_BANK = new LatLng(34.776965, 32.422842);
    private final LatLng LOCATION_BANK2 = new LatLng(34.768164, 32.410696);
    private final LatLng LOCATION_BANK3 = new LatLng(34.787516, 32.423101);
    private final LatLng LOCATION_BANK4 = new LatLng(34.776918, 32.420978);
    private final LatLng LOCATION_BANK5 = new LatLng(34.773711, 32.428823);
    private final LatLng LOCATION_BANK6 = new LatLng(34.756097, 32.417396);
    private final LatLng LOCATION_BANK7 = new LatLng(34.747738, 32.426014);
    private final LatLng LOCATION_BANK8 = new LatLng(34.748579, 32.426209);
    private final LatLng LOCATION_BANK9 = new LatLng(34.756108, 32.415468);
    private final LatLng LOCATION_BANK10 = new LatLng(34.776297, 32.419110);
    private final LatLng LOCATION_BANK11 = new LatLng(34.776831, 32.420985);


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
        test.setText("ATM/Banks");  */
        list = (ListView) findViewById(R.id.listView);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.addMarker(new MarkerOptions().position(LOCATION_BANK).title("Bank of Cyprus 0660").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
        map.addMarker(new MarkerOptions().position(LOCATION_BANK2).title("Bank of Cyprus 0669").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
        map.addMarker(new MarkerOptions().position(LOCATION_BANK3).title("Bank of Cyprus 0678").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
        map.addMarker(new MarkerOptions().position(LOCATION_BANK4).title("Ethniki Bank 5451").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
        map.addMarker(new MarkerOptions().position(LOCATION_BANK5).title("Pireus Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
        map.addMarker(new MarkerOptions().position(LOCATION_BANK6).title("Alpha Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
        map.addMarker(new MarkerOptions().position(LOCATION_BANK7).title("Bank of Cyprus 0603").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
        map.addMarker(new MarkerOptions().position(LOCATION_BANK8).title("Hellenic Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
        map.addMarker(new MarkerOptions().position(LOCATION_BANK9).title("Bank of Cyprus").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
        map.addMarker(new MarkerOptions().position(LOCATION_BANK10).title("Hellenic Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
        map.addMarker(new MarkerOptions().position(LOCATION_BANK11).title("National Bank of Greece (Cyprus)").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));



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
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK, 17.0f));
                } else if (position == 1) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK2, 17.0f));
                } else if (position == 2) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK3, 17.0f));
                } else if (position == 3) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK4, 17.0f));
                } else if (position == 4) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK5, 17.0f));
                } else if (position == 5) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK6, 17.0f));
                } else if (position == 6) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK7, 17.0f));
                } else if (position == 7) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK8, 17.0f));
                } else if (position == 8) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK9, 17.0f));
                } else if (position == 9) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK10, 17.0f));
                } else if (position == 10) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BANK11, 17.0f));
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
