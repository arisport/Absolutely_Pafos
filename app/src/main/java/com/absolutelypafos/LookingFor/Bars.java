package com.absolutelypafos.LookingFor;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
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


public class Bars extends AppCompatActivity {
    ListView list;
    String[] itemname = {

            "Friends Bar",
            "Flairs Bar",
            "Baywatch",
            "Different Bar",
            "Boogie's",
            "Waterhole Bar",
            "Sixties Bar",
            "Pingouino Cafe Lounge Bar ",
            "Alea Cafe Lounge Bar",
            "The Rose Pub",
            "Suite48 Grill & Lounge Bar",
            "The DOME - Molecular & Sushi Bar",
            "Crocodile Pub",
            "Metaxi mas Cafe Lounge"

    };

    String[] data = {

            "Bar St, Paphos, Cyprus",
            "Ayiou Antoniou, Paphos, Cyprus",
            "Ayiou Antoniou, Paphos, Cyprus",
            "Ayiou Antoniou, Paphos, Cyprus",
            "Ayiou Antoniou, Paphos, Cyprus",
            "Ayiou Antoniou, Paphos, Cyprus",
            "Ayiou Antoniou, Paphos, Cyprus",
            "Poseidonos Ave, Paphos, Cyprus",
            "Kato Paphos, Paphos, Cyprus",
            "Alkminis, Paphos, Cyprus",
            "Poseidonos Ave 48, Paphos",
            "Aliathon Plaza, Poseidonos Ave",
            " Danaes Ave, Paphos, Cyprus",
            "Kato Paphos, Paphos, Cyprus"

    };

    Integer[] imgid = {
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar,
            R.drawable.bar


    };

    private static final int REQUEST_CODE_LOCATION = 2;
    Button fullmap;
    TextView actionbarcentre;
    private GoogleMap map;
    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);
    private final LatLng LOCATION_FRIENDS = new LatLng(34.758062, 32.416607);
    private final LatLng LOCATION_FLAIRS = new LatLng(34.757461, 32.417627);
    private final LatLng LOCATION_BAYWATCH = new LatLng(34.758120, 32.416179);
    private final LatLng LOCATION_DIFFERENT = new LatLng(34.757818, 32.415889);
    private final LatLng LOCATION_BOGGIES = new LatLng(34.757157, 32.417713);
    private final LatLng LOCATION_WATERHOLE = new LatLng(34.758249, 32.415601);
    private final LatLng LOCATION_SIXTIES = new LatLng(34.758454, 32.417175);
    private final LatLng LOCATION_PINGIOUNO = new LatLng(34.756363, 32.416397);
    private final LatLng LOCATION_ALEA = new LatLng(34.755966, 32.415949);
    private final LatLng LOCATION_ROSE = new LatLng(34.756529, 32.414902);
    private final LatLng LOCATION_SUIT = new LatLng(34.746893, 32.424391);
    private final LatLng LOCATION_THEDOME = new LatLng(34.743967, 32.431327);
    private final LatLng LOCATION_CROD = new LatLng(34.748210, 32.426453);
    private final LatLng LOCATION_METAXI = new LatLng(34.755402, 32.420308);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_locations);


        /*getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbarcentre);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionbarcentre = (TextView) findViewById(R.id.mytext);
        actionbarcentre.setText("Bars"); */

        list = (ListView) findViewById(R.id.listView);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        map.addMarker(new MarkerOptions().position(LOCATION_FRIENDS).title("Friends Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_FLAIRS).title("Flairs Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_BAYWATCH).title("Baywatch Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_DIFFERENT).title("Different Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_BOGGIES).title("Boogie's Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_WATERHOLE).title("Waterhole Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_SIXTIES).title("Sixties Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_PINGIOUNO).title("Pingouino Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_ALEA).title("Alea Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_ROSE).title("The Rose pub").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_SUIT).title("Suite48 Grill & Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_THEDOME).title("The DOME - Molecular & Sushi Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_CROD).title("Crocodile Pub").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
        map.addMarker(new MarkerOptions().position(LOCATION_METAXI).title("Metaxi Mas Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));

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
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_FRIENDS, 17.0f));
                } else if (position == 1) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_FLAIRS, 17.0f));
                } else if (position == 2) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BAYWATCH, 17.0f));
                } else if (position == 3) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_DIFFERENT, 17.0f));
                } else if (position == 4) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_BOGGIES, 17.0f));
                } else if (position == 5) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_WATERHOLE, 17.0f));
                } else if (position == 6) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_SIXTIES, 17.0f));
                } else if (position == 7) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_PINGIOUNO, 17.0f));
                } else if (position == 8) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_ALEA, 17.0f));
                } else if (position == 9) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_ROSE, 17.0f));
                } else if (position == 10) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_SUIT, 17.0f));
                } else if (position == 11) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_THEDOME, 17.0f));
                } else if (position == 12) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_CROD, 17.0f));
                }else if (position == 13) {
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(LOCATION_METAXI, 17.0f));
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
