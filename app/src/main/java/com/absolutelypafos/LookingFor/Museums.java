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

public class Museums extends AppCompatActivity {
    ListView list;
    String[] itemname = {

            "Pafos District Archaeological Museum",
            "Byzantine Museum",
            "Ethnographical Museum",
            "Ethnographical Museum of Pafos",
            "The Steni Museum of Village Life",
            "Museum Pallaipafou Kouklia",


    };

    String[] data = {

            "Β6 43, Paphos, Cyprus",
            "Andrea Ioannou, Paphos, Cyprus",
            "1, Paphos, Cyprus",
            "Exo Vrisis 1, Paphos 8047, Cyprus",
            "Steni Village, Cyprus",
            "Kouklia Village,Paphos, Cyprus",


    };

    Integer[] imgid = {
            R.drawable.museum,
            R.drawable.museum,
            R.drawable.museum,
            R.drawable.museum,
            R.drawable.museum,
            R.drawable.museum,



    };

    private static final int REQUEST_CODE_LOCATION = 2;
    Button fullmap;
    private GoogleMap map;
    private final LatLng LOCATION_GENERAL = new LatLng(34.767930, 32.429412);

    private final LatLng LOCATION_MUS1 = new LatLng(34.771725, 32.430178);
    private final LatLng LOCATION_MUS2 = new LatLng(34.772860, 32.419689);
    private final LatLng LOCATION_MUS3 = new LatLng(34.780855, 32.408511);
    private final LatLng LOCATION_MUS4 = new LatLng(34.771731, 32.424066);
    private final LatLng LOCATION_MUS5 = new LatLng(34.998144, 32.471663);
    private final LatLng LOCATION_MUS6 = new LatLng(34.698304, 32.593929);



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
        test.setText("Museums");
        list = (ListView) findViewById(R.id.listView);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.addMarker(new MarkerOptions().position(LOCATION_MUS1).title("Pafos District Archaeological Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
        map.addMarker(new MarkerOptions().position(LOCATION_MUS2).title("Byzantine Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
        map.addMarker(new MarkerOptions().position(LOCATION_MUS3).title("Ethnographical Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
        map.addMarker(new MarkerOptions().position(LOCATION_MUS4).title("Ethnographical Museum of Pafos").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
        map.addMarker(new MarkerOptions().position(LOCATION_MUS5).title("The Steni Museum of Village Life").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
        map.addMarker(new MarkerOptions().position(LOCATION_MUS6).title("Kouklia Village,Paphos, Cyprus").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));



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
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_MUS1, 17.0f));
                } else if (position == 1) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_MUS2, 17.0f));
                } else if (position == 2) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_MUS3, 17.0f));
                } else if (position == 3) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_MUS4, 17.0f));
                } else if (position == 4) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_MUS5, 17.0f));
                } else if (position == 5) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_MUS6, 17.0f));
                }

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_museums, menu);
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
