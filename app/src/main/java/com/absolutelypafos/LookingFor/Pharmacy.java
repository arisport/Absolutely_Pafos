package com.absolutelypafos.LookingFor;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pafos.paphosguide.R;

public class Pharmacy extends AppCompatActivity {

    ListView list;
    String[] itemname = {

            "George Manolis Pharmacy",
            "Christofi Niki Pharmacy",
            "Sofia Roidi Pharmacy",
            "Pharmacy H''Charalambous Dora",
            "Pharmacy H''Charalambous Kleopas",
            "Lia Perikenti Pharmacy",



    };

    String[] data = {

            "30 Miltiade Stylianou Str, 8047, Tala",
            "85 Poseidonos Ave, West Park 1, Shop 34, 8042, Pafos",
            "Agion Anargiron 21 Kato Paphos,",
            "Ellados 104",
            "Demokratias 51",
            "Apostolou Pavlou Ave 44, Paphos, Cyprus",


    };

    Integer[] imgid = {
            R.drawable.pharmacy,
            R.drawable.pharmacy,
            R.drawable.pharmacy,
            R.drawable.pharmacy,
            R.drawable.pharmacy,
            R.drawable.pharmacy,



    };

    private static final int REQUEST_CODE_LOCATION = 2;
    Button fullmap;
    private GoogleMap map;
    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);

    private final LatLng LOCATION_PHARM1 = new LatLng(34.832643, 32.428899);
    private final LatLng LOCATION_PHARM2 = new LatLng(34.748074, 32.425965);
    private final LatLng LOCATION_PHARM3 = new LatLng(34.762610, 32.417378);
    private final LatLng LOCATION_PHARM4 = new LatLng(34.789684, 32.434403);
    private final LatLng LOCATION_PHARM5 = new LatLng(34.776425, 32.442982);
    private final LatLng LOCATION_PHARM6 = new LatLng(34.769319, 32.416903);



    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_locations);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbarcentre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.test);


        test = (TextView) findViewById(R.id.mytext);
        test.setText("Pharmacy Services");
        list = (ListView) findViewById(R.id.listView);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.addMarker(new MarkerOptions().position(LOCATION_PHARM1).title("George Manolis Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
        map.addMarker(new MarkerOptions().position(LOCATION_PHARM2).title("Christofi Niki Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
        map.addMarker(new MarkerOptions().position(LOCATION_PHARM3).title("Sofia Roidi Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
        map.addMarker(new MarkerOptions().position(LOCATION_PHARM4).title("Pharmacy H''Charalambous Dora").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
        map.addMarker(new MarkerOptions().position(LOCATION_PHARM5).title("Pharmacy H''Charalambous Kleopas").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
        map.addMarker(new MarkerOptions().position(LOCATION_PHARM6).title("Lia Perikenti Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));



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
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_PHARM1, 17.0f));
                } else if (position == 1) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_PHARM2, 17.0f));
                } else if (position == 2) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_PHARM3, 17.0f));
                } else if (position == 3) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_PHARM4, 17.0f));
                } else if (position == 4) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_PHARM5, 17.0f));
                } else if (position == 5) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_PHARM6, 17.0f));
                }

            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pharmacy, menu);
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
