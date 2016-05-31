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


public class Clubs extends AppCompatActivity {
    ListView list;
    String[] itemname = {
            "Loft Club",
            "Vibes",
            "Amnesia",
            "Summer Club",


    };

    String[] data = {

            "Kato Paphos, Paphos, Cyprus",
            "Ayiou Antoniou, Bar Street",
            "Ayiou Antoniou Bar Street",
            "Yeroskipou, Paphos, Cyprus",


    };

    Integer[] imgid = {
            R.drawable.club,
            R.drawable.club,
            R.drawable.club,
            R.drawable.club

    };

    private static final int REQUEST_CODE_LOCATION = 2;
    Button fullmap;
    private GoogleMap map;
    TextView actionbarcentre;
    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);
    private final LatLng LOCATION_LOFT = new LatLng(34.756573, 32.419720);
    private final LatLng LOCATION_VIBES = new LatLng(34.756237, 32.418606);
    private final LatLng LOCATION_AMNESIA = new LatLng(34.757833, 32.416635);
    private final LatLng LOCATION_SUMMER = new LatLng(34.734832, 32.450298);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_locations);
        list = (ListView) findViewById(R.id.listView);


       /* getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbarcentre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionbarcentre = (TextView) findViewById(R.id.mytext);
        actionbarcentre.setText("Clubs"); */

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.addMarker(new MarkerOptions().position(LOCATION_LOFT).title("Loft Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
        map.addMarker(new MarkerOptions().position(LOCATION_VIBES).title("Vibes Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
        map.addMarker(new MarkerOptions().position(LOCATION_AMNESIA).title("Amnesia Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
        map.addMarker(new MarkerOptions().position(LOCATION_SUMMER).title("Summer Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));


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
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_LOFT, 17.0f));
                } else if (position == 1) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_VIBES, 17.0f));
                } else if (position == 2) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_AMNESIA, 17.0f));
                } else if (position == 3) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_SUMMER, 17.0f));
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