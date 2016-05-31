package com.absolutelypafos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.absolutelypafos.helper.DirectionsJSONParser;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Interact extends AppCompatActivity {

    GoogleMap map;
    ArrayList<LatLng> markerPoints;
    String distance;
    String duration;
    RadioButton rbDriving;
    RadioButton rbBiCycling;
    RadioButton rbWalking;
    RadioGroup rgModes;
    int mMode = 0;
    private ArrayList<String> routeInstructions = new ArrayList<String>();
    private Button getDirections;
    private Button getSearch;
    final int MODE_DRIVING = 0;
    final int MODE_BICYCLING = 1;
    final int MODE_WALKING = 2;
    private static final int REQUEST_CODE_LOCATION = 2;
    TextView actionbarcentre;
    private CoordinatorLayout coordinatorLayout;


    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);
    //Restaurants
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
    // Bars
    private final LatLng LOCATION_FRIENDS = new LatLng(34.758062, 32.416607);
    private final LatLng LOCATION_FLAIRS = new LatLng(34.757461, 32.417627);
    private final LatLng LOCATION_BAYWATCH = new LatLng(34.758120, 32.416179);
    private final LatLng LOCATION_DIFFERENT = new LatLng(34.757818, 32.415889);
    private final LatLng LOCATION_BOGGIES = new LatLng(34.757157, 32.417713);
    private final LatLng LOCATION_WATERHOLE = new LatLng(34.758249, 32.415601);
    private final LatLng LOCATION_SIXTIES = new LatLng(34.758454, 32.417175);
    private final LatLng LOCATION_ROSE = new LatLng(34.756529, 32.414902);
    private final LatLng LOCATION_THEDOME = new LatLng(34.743967, 32.431327);
    private final LatLng LOCATION_CROD = new LatLng(34.748210, 32.426453);

    //clubs
    private final LatLng LOCATION_LOFT = new LatLng(34.756573, 32.419720);
    private final LatLng LOCATION_VIBES = new LatLng(34.756237, 32.418606);
    private final LatLng LOCATION_AMNESIA = new LatLng(34.757833, 32.416635);
    private final LatLng LOCATION_SUMMER = new LatLng(34.734832, 32.450298);

    //atms/banks
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

    //pharmacy
    private final LatLng LOCATION_PHARM1 = new LatLng(34.832643, 32.428899);
    private final LatLng LOCATION_PHARM2 = new LatLng(34.748074, 32.425965);
    private final LatLng LOCATION_PHARM3 = new LatLng(34.762610, 32.417378);
    private final LatLng LOCATION_PHARM4 = new LatLng(34.789684, 32.434403);
    private final LatLng LOCATION_PHARM5 = new LatLng(34.776425, 32.442982);
    private final LatLng LOCATION_PHARM6 = new LatLng(34.769319, 32.416903);

    //museums
    private final LatLng LOCATION_MUS1 = new LatLng(34.771725, 32.430178);
    private final LatLng LOCATION_MUS2 = new LatLng(34.772860, 32.419689);
    private final LatLng LOCATION_MUS3 = new LatLng(34.780855, 32.408511);
    private final LatLng LOCATION_MUS4 = new LatLng(34.771731, 32.424066);
    private final LatLng LOCATION_MUS5 = new LatLng(34.998144, 32.471663);
    private final LatLng LOCATION_MUS6 = new LatLng(34.698304, 32.593929);

    //hospitals
    private final LatLng LOCATION_HO1 = new LatLng(34.788938, 32.445816);
    private final LatLng LOCATION_HO2 = new LatLng(34.762777, 32.438376);
    private final LatLng LOCATION_HO3 = new LatLng(34.762624, 32.417803);
    private final LatLng LOCATION_HO4 = new LatLng(34.776441, 32.442686);
    private final LatLng LOCATION_HO5 = new LatLng(34.786543, 32.437999);
    private final LatLng LOCATION_HO6 = new LatLng(35.039136, 32.424377);
    private final LatLng LOCATION_HO7 = new LatLng(34.874919, 32.379171);

    //gasstations
    private final LatLng LOCATION_GAS1 = new LatLng(34.776692, 32.423093);
    private final LatLng LOCATION_GAS2 = new LatLng(34.777353, 32.423588);
    private final LatLng LOCATION_GAS3 = new LatLng(34.777862, 32.424076);
    private final LatLng LOCATION_GAS4 = new LatLng(34.777977, 32.423566);
    private final LatLng LOCATION_GAS5 = new LatLng(34.775770, 32.442584);
    private final LatLng LOCATION_GAS6 = new LatLng(34.781704, 32.444560);

    //cafe
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
        setContentView(R.layout.activity_interact);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);


     /*
        // Getting reference to getDirections
        getSearch = (Button) findViewById(R.id.getSearch);
        getSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Search.class);
                startActivity(intent);
                overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
            }
        });
        
        */
        getDirections = (Button) findViewById(R.id.getDirections);


        // OnClick of getDirections button
        View.OnClickListener directionsListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                // Create a new Intent and startActivity DirectionsActivity which will show the route instructions on a ListView
                Intent intent = new Intent(Interact.this,
                        DirectionsActivity.class);
                intent.putStringArrayListExtra("directions", routeInstructions);
                startActivity(intent);
            }
        };

        getDirections.setOnClickListener(directionsListener);

        /////////////////////////////////////
        // Getting reference to rb_driving
        rbDriving = (RadioButton) findViewById(R.id.rb_driving);

        // Getting reference to rb_bicylcing
        //rbBiCycling = (RadioButton) findViewById(R.id.rb_bicycling);

        // Getting reference to rb_walking
        rbWalking = (RadioButton) findViewById(R.id.rb_walking);

        // Getting Reference to rg_modes
        rgModes = (RadioGroup) findViewById(R.id.rg_modes);

        rgModes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // Checks, whether start and end locations are captured
                if (markerPoints.size() >= 2) {
                    LatLng origin = markerPoints.get(0);
                    LatLng dest = markerPoints.get(1);

                    // Getting URL to the Google Directions API
                    String url = getDirectionsUrl(origin, dest);

                    DownloadTask downloadTask = new DownloadTask();

                    // Start downloading json data from Google Directions API
                    downloadTask.execute(url);
                }
            }
        });

        ////////////////////

        // Initializing
        markerPoints = new ArrayList<LatLng>();

        // Getting reference to SupportMapFragment of the activity_main
        SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        // Getting Map for the SupportMapFragment
        map = fm.getMap();
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);

        if (map != null) {
            //Bars
            final Marker bar1 = map.addMarker(new MarkerOptions().position(LOCATION_FRIENDS).title("Friends Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar2 = map.addMarker(new MarkerOptions().position(LOCATION_FLAIRS).title("Flairs Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar3 = map.addMarker(new MarkerOptions().position(LOCATION_BAYWATCH).title("Baywatch Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar4 = map.addMarker(new MarkerOptions().position(LOCATION_DIFFERENT).title("Different Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar5 = map.addMarker(new MarkerOptions().position(LOCATION_BOGGIES).title("Boogie's Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar6 = map.addMarker(new MarkerOptions().position(LOCATION_WATERHOLE).title("Waterhole Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar7 = map.addMarker(new MarkerOptions().position(LOCATION_SIXTIES).title("Sixties Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar8 = map.addMarker(new MarkerOptions().position(LOCATION_PINGIOUNO).title("Pingouino Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar9 = map.addMarker(new MarkerOptions().position(LOCATION_ALEA).title("Alea Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar10 = map.addMarker(new MarkerOptions().position(LOCATION_ROSE).title("The Rose pub").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar11 = map.addMarker(new MarkerOptions().position(LOCATION_SUIT).title("Suite48 Grill & Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar12 = map.addMarker(new MarkerOptions().position(LOCATION_THEDOME).title("The DOME - Molecular & Sushi Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar13 = map.addMarker(new MarkerOptions().position(LOCATION_CROD).title("Crocodile Pub").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
            final Marker bar14 = map.addMarker(new MarkerOptions().position(LOCATION_METAXI).title("Metaxi Mas Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));

            //clubs
            final Marker club1 = map.addMarker(new MarkerOptions().position(LOCATION_LOFT).title("Loft Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
            final Marker club2 = map.addMarker(new MarkerOptions().position(LOCATION_VIBES).title("Vibes Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
            final Marker club3 = map.addMarker(new MarkerOptions().position(LOCATION_AMNESIA).title("Amnesia Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
            final Marker club4 = map.addMarker(new MarkerOptions().position(LOCATION_SUMMER).title("Summer Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));


            //atms
            final Marker atm1 = map.addMarker(new MarkerOptions().position(LOCATION_BANK).title("Bank of Cyprus 0660").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
            final Marker atm2 = map.addMarker(new MarkerOptions().position(LOCATION_BANK2).title("Bank of Cyprus 0669").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
            final Marker atm3 = map.addMarker(new MarkerOptions().position(LOCATION_BANK3).title("Bank of Cyprus 0678").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
            final Marker atm4 = map.addMarker(new MarkerOptions().position(LOCATION_BANK4).title("Ethniki Bank 5451").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
            final Marker atm5 = map.addMarker(new MarkerOptions().position(LOCATION_BANK5).title("Pireus Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
            final Marker atm6 = map.addMarker(new MarkerOptions().position(LOCATION_BANK6).title("Alpha Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
            final Marker atm7 = map.addMarker(new MarkerOptions().position(LOCATION_BANK7).title("Bank of Cyprus 0603").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
            final Marker atm8 = map.addMarker(new MarkerOptions().position(LOCATION_BANK8).title("Hellenic Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
            final Marker atm9 = map.addMarker(new MarkerOptions().position(LOCATION_BANK9).title("Bank of Cyprus").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
            final Marker atm10 = map.addMarker(new MarkerOptions().position(LOCATION_BANK10).title("Hellenic Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
            final Marker atm11 = map.addMarker(new MarkerOptions().position(LOCATION_BANK11).title("National Bank of Greece (Cyprus)").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));

            //pharmacy
            final Marker pharm1 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM1).title("George Manolis Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
            final Marker pharm2 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM2).title("Christofi Niki Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
            final Marker pharm3 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM3).title("Sofia Roidi Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
            final Marker pharm4 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM4).title("Pharmacy H''Charalambous Dora").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
            final Marker pharm5 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM5).title("Pharmacy H''Charalambous Kleopas").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
            final Marker pharm6 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM6).title("Lia Perikenti Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));

            //museums
            final Marker mus1 = map.addMarker(new MarkerOptions().position(LOCATION_MUS1).title("Pafos District Archaeological Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
            final Marker mus2 = map.addMarker(new MarkerOptions().position(LOCATION_MUS2).title("Byzantine Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
            final Marker mus3 = map.addMarker(new MarkerOptions().position(LOCATION_MUS3).title("Ethnographical Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
            final Marker mus4 = map.addMarker(new MarkerOptions().position(LOCATION_MUS4).title("Ethnographical Museum of Pafos").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
            final Marker mus5 = map.addMarker(new MarkerOptions().position(LOCATION_MUS5).title("The Steni Museum of Village Life").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
            final Marker mus6 = map.addMarker(new MarkerOptions().position(LOCATION_MUS6).title("Kouklia Village,Paphos, Cyprus").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));


            //hospitals
            final Marker hos1 = map.addMarker(new MarkerOptions().position(LOCATION_HO1).title("Paphos General Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
            final Marker hos2 = map.addMarker(new MarkerOptions().position(LOCATION_HO2).title("Iasis Private Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
            final Marker hos3 = map.addMarker(new MarkerOptions().position(LOCATION_HO3).title("Elpis Medical Centre").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
            final Marker hos4 = map.addMarker(new MarkerOptions().position(LOCATION_HO4).title("Blue Cross Medical Center").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
            final Marker hos5 = map.addMarker(new MarkerOptions().position(LOCATION_HO5).title("Evangelismos Private Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
            final Marker hos6 = map.addMarker(new MarkerOptions().position(LOCATION_HO6).title("Polis Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
            final Marker hos7 = map.addMarker(new MarkerOptions().position(LOCATION_HO7).title("Peyia Medical Centre").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));

            //gasstations
            final Marker gas1 = map.addMarker(new MarkerOptions().position(LOCATION_GAS1).title("EKO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
            final Marker gas2 = map.addMarker(new MarkerOptions().position(LOCATION_GAS2).title("Petrolina Service Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
            final Marker gas3 = map.addMarker(new MarkerOptions().position(LOCATION_GAS3).title("LUKOIL Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
            final Marker gas4 = map.addMarker(new MarkerOptions().position(LOCATION_GAS4).title("ESSO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
            final Marker gas5 = map.addMarker(new MarkerOptions().position(LOCATION_GAS5).title("ESSO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
            final Marker gas6 = map.addMarker(new MarkerOptions().position(LOCATION_GAS6).title("EKO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));


            //cafe

            final Marker cafe1 = map.addMarker(new MarkerOptions().position(LOCATION_METAXI).title("Metaxi Mas Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe2 = map.addMarker(new MarkerOptions().position(LOCATION_THEHARBOUR).title("The Harbour Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe3 = map.addMarker(new MarkerOptions().position(LOCATION_HOBO).title("Hobo Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe4 = map.addMarker(new MarkerOptions().position(LOCATION_STARBUCKS).title("Starbucks Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe5 = map.addMarker(new MarkerOptions().position(LOCATION_MUSE).title("Muse Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe6 = map.addMarker(new MarkerOptions().position(LOCATION_STEVES).title("Steve's Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe7 = map.addMarker(new MarkerOptions().position(LOCATION_VIENNA).title("Vienna Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe8 = map.addMarker(new MarkerOptions().position(LOCATION_PINGIOUNO).title("Pingouino Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe9 = map.addMarker(new MarkerOptions().position(LOCATION_ALEA).title("Alea Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe10 = map.addMarker(new MarkerOptions().position(LOCATION_BOIT).title("La Boite '67").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe11 = map.addMarker(new MarkerOptions().position(LOCATION_SUIT).title("Suite48 Grill & Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe12 = map.addMarker(new MarkerOptions().position(LOCATION_ARABICA).title("Arrabica Coffee shop").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe13 = map.addMarker(new MarkerOptions().position(LOCATION_OMNIA).title("Omnia 1912 Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
            final Marker cafe14 = map.addMarker(new MarkerOptions().position(LOCATION_HAMAM).title("Hamam").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));


            LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
            boolean location = service
                    .isProviderEnabled(LocationManager.GPS_PROVIDER);

            if (isNetworkAvailable(getBaseContext())) {
                if (!location) {
                    new AlertDialog.Builder(this)
                            .setTitle("GPS Location")
                            .setMessage("Please enable location Services")
                            .setPositiveButton(android.R.string.yes,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {
                                            Intent intent = new Intent(
                                                    Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivity(intent);
                                        }
                                    })
                            .setNegativeButton(android.R.string.no,
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(
                                                DialogInterface dialog,
                                                int which) {
                                            Interact.this.finish();
                                        }
                                    })
                            .setIcon(android.R.drawable.ic_dialog_alert).show();
                } else {
                    for (int i = 0; i < 3; i++) {
                        final Snackbar snackBar = Snackbar.make(coordinatorLayout, "Tap two locations in the map in order to draw a route between them", Snackbar.LENGTH_INDEFINITE);

                        snackBar.setAction("Dismiss", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                snackBar.dismiss();
                            }
                        });
                        snackBar.show();
                    }
                }


                /*{
                    for (int i = 0; i < 3; i++) {

                        Toast.makeText( //snackbar
                                Interact.this,
                                "Tap two locations in the map in order to draw a route between them",
                                Toast.LENGTH_LONG).show();

                    }
                } */

                // Setting onclick event listener for the map
                map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

                    @Override
                    public void onMapClick(LatLng point) {

                        // Already two locations
                        if (markerPoints.size() > 1) {
                            markerPoints.clear();
                            map.clear();

                            //Bars
                            final Marker bar1 = map.addMarker(new MarkerOptions().position(LOCATION_FRIENDS).title("Friends Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar2 = map.addMarker(new MarkerOptions().position(LOCATION_FLAIRS).title("Flairs Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar3 = map.addMarker(new MarkerOptions().position(LOCATION_BAYWATCH).title("Baywatch Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar4 = map.addMarker(new MarkerOptions().position(LOCATION_DIFFERENT).title("Different Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar5 = map.addMarker(new MarkerOptions().position(LOCATION_BOGGIES).title("Boogie's Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar6 = map.addMarker(new MarkerOptions().position(LOCATION_WATERHOLE).title("Waterhole Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar7 = map.addMarker(new MarkerOptions().position(LOCATION_SIXTIES).title("Sixties Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar8 = map.addMarker(new MarkerOptions().position(LOCATION_PINGIOUNO).title("Pingouino Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar9 = map.addMarker(new MarkerOptions().position(LOCATION_ALEA).title("Alea Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar10 = map.addMarker(new MarkerOptions().position(LOCATION_ROSE).title("The Rose pub").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar11 = map.addMarker(new MarkerOptions().position(LOCATION_SUIT).title("Suite48 Grill & Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar12 = map.addMarker(new MarkerOptions().position(LOCATION_THEDOME).title("The DOME - Molecular & Sushi Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar13 = map.addMarker(new MarkerOptions().position(LOCATION_CROD).title("Crocodile Pub").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                            final Marker bar14 = map.addMarker(new MarkerOptions().position(LOCATION_METAXI).title("Metaxi Mas Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));

                            //clubs
                            final Marker club1 = map.addMarker(new MarkerOptions().position(LOCATION_LOFT).title("Loft Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
                            final Marker club2 = map.addMarker(new MarkerOptions().position(LOCATION_VIBES).title("Vibes Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
                            final Marker club3 = map.addMarker(new MarkerOptions().position(LOCATION_AMNESIA).title("Amnesia Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
                            final Marker club4 = map.addMarker(new MarkerOptions().position(LOCATION_SUMMER).title("Summer Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));


                            //atms
                            final Marker atm1 = map.addMarker(new MarkerOptions().position(LOCATION_BANK).title("Bank of Cyprus 0660").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                            final Marker atm2 = map.addMarker(new MarkerOptions().position(LOCATION_BANK2).title("Bank of Cyprus 0669").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                            final Marker atm3 = map.addMarker(new MarkerOptions().position(LOCATION_BANK3).title("Bank of Cyprus 0678").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                            final Marker atm4 = map.addMarker(new MarkerOptions().position(LOCATION_BANK4).title("Ethniki Bank 5451").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                            final Marker atm5 = map.addMarker(new MarkerOptions().position(LOCATION_BANK5).title("Pireus Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                            final Marker atm6 = map.addMarker(new MarkerOptions().position(LOCATION_BANK6).title("Alpha Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                            final Marker atm7 = map.addMarker(new MarkerOptions().position(LOCATION_BANK7).title("Bank of Cyprus 0603").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                            final Marker atm8 = map.addMarker(new MarkerOptions().position(LOCATION_BANK8).title("Hellenic Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                            final Marker atm9 = map.addMarker(new MarkerOptions().position(LOCATION_BANK9).title("Bank of Cyprus").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                            final Marker atm10 = map.addMarker(new MarkerOptions().position(LOCATION_BANK10).title("Hellenic Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                            final Marker atm11 = map.addMarker(new MarkerOptions().position(LOCATION_BANK11).title("National Bank of Greece (Cyprus)").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));

                            //pharmacy
                            final Marker pharm1 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM1).title("George Manolis Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
                            final Marker pharm2 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM2).title("Christofi Niki Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
                            final Marker pharm3 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM3).title("Sofia Roidi Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
                            final Marker pharm4 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM4).title("Pharmacy H''Charalambous Dora").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
                            final Marker pharm5 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM5).title("Pharmacy H''Charalambous Kleopas").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
                            final Marker pharm6 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM6).title("Lia Perikenti Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));

                            //museums
                            final Marker mus1 = map.addMarker(new MarkerOptions().position(LOCATION_MUS1).title("Pafos District Archaeological Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
                            final Marker mus2 = map.addMarker(new MarkerOptions().position(LOCATION_MUS2).title("Byzantine Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
                            final Marker mus3 = map.addMarker(new MarkerOptions().position(LOCATION_MUS3).title("Ethnographical Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
                            final Marker mus4 = map.addMarker(new MarkerOptions().position(LOCATION_MUS4).title("Ethnographical Museum of Pafos").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
                            final Marker mus5 = map.addMarker(new MarkerOptions().position(LOCATION_MUS5).title("The Steni Museum of Village Life").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
                            final Marker mus6 = map.addMarker(new MarkerOptions().position(LOCATION_MUS6).title("Kouklia Village,Paphos, Cyprus").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));


                            //hospitals
                            final Marker hos1 = map.addMarker(new MarkerOptions().position(LOCATION_HO1).title("Paphos General Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                            final Marker hos2 = map.addMarker(new MarkerOptions().position(LOCATION_HO2).title("Iasis Private Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                            final Marker hos3 = map.addMarker(new MarkerOptions().position(LOCATION_HO3).title("Elpis Medical Centre").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                            final Marker hos4 = map.addMarker(new MarkerOptions().position(LOCATION_HO4).title("Blue Cross Medical Center").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                            final Marker hos5 = map.addMarker(new MarkerOptions().position(LOCATION_HO5).title("Evangelismos Private Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                            final Marker hos6 = map.addMarker(new MarkerOptions().position(LOCATION_HO6).title("Polis Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                            final Marker hos7 = map.addMarker(new MarkerOptions().position(LOCATION_HO7).title("Peyia Medical Centre").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));

                            //gasstations
                            final Marker gas1 = map.addMarker(new MarkerOptions().position(LOCATION_GAS1).title("EKO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
                            final Marker gas2 = map.addMarker(new MarkerOptions().position(LOCATION_GAS2).title("Petrolina Service Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
                            final Marker gas3 = map.addMarker(new MarkerOptions().position(LOCATION_GAS3).title("LUKOIL Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
                            final Marker gas4 = map.addMarker(new MarkerOptions().position(LOCATION_GAS4).title("ESSO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
                            final Marker gas5 = map.addMarker(new MarkerOptions().position(LOCATION_GAS5).title("ESSO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
                            final Marker gas6 = map.addMarker(new MarkerOptions().position(LOCATION_GAS6).title("EKO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));


                            //cafe

                            final Marker cafe1 = map.addMarker(new MarkerOptions().position(LOCATION_METAXI).title("Metaxi Mas Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe2 = map.addMarker(new MarkerOptions().position(LOCATION_THEHARBOUR).title("The Harbour Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe3 = map.addMarker(new MarkerOptions().position(LOCATION_HOBO).title("Hobo Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe4 = map.addMarker(new MarkerOptions().position(LOCATION_STARBUCKS).title("Starbucks Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe5 = map.addMarker(new MarkerOptions().position(LOCATION_MUSE).title("Muse Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe6 = map.addMarker(new MarkerOptions().position(LOCATION_STEVES).title("Steve's Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe7 = map.addMarker(new MarkerOptions().position(LOCATION_VIENNA).title("Vienna Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe8 = map.addMarker(new MarkerOptions().position(LOCATION_PINGIOUNO).title("Pingouino Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe9 = map.addMarker(new MarkerOptions().position(LOCATION_ALEA).title("Alea Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe10 = map.addMarker(new MarkerOptions().position(LOCATION_BOIT).title("La Boite '67").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe11 = map.addMarker(new MarkerOptions().position(LOCATION_SUIT).title("Suite48 Grill & Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe12 = map.addMarker(new MarkerOptions().position(LOCATION_ARABICA).title("Arrabica Coffee shop").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe13 = map.addMarker(new MarkerOptions().position(LOCATION_OMNIA).title("Omnia 1912 Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                            final Marker cafe14 = map.addMarker(new MarkerOptions().position(LOCATION_HAMAM).title("Hamam").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));


                        }

                        //Bars
                        final Marker bar1 = map.addMarker(new MarkerOptions().position(LOCATION_FRIENDS).title("Friends Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar2 = map.addMarker(new MarkerOptions().position(LOCATION_FLAIRS).title("Flairs Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar3 = map.addMarker(new MarkerOptions().position(LOCATION_BAYWATCH).title("Baywatch Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar4 = map.addMarker(new MarkerOptions().position(LOCATION_DIFFERENT).title("Different Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar5 = map.addMarker(new MarkerOptions().position(LOCATION_BOGGIES).title("Boogie's Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar6 = map.addMarker(new MarkerOptions().position(LOCATION_WATERHOLE).title("Waterhole Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar7 = map.addMarker(new MarkerOptions().position(LOCATION_SIXTIES).title("Sixties Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar8 = map.addMarker(new MarkerOptions().position(LOCATION_PINGIOUNO).title("Pingouino Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar9 = map.addMarker(new MarkerOptions().position(LOCATION_ALEA).title("Alea Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar10 = map.addMarker(new MarkerOptions().position(LOCATION_ROSE).title("The Rose pub").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar11 = map.addMarker(new MarkerOptions().position(LOCATION_SUIT).title("Suite48 Grill & Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar12 = map.addMarker(new MarkerOptions().position(LOCATION_THEDOME).title("The DOME - Molecular & Sushi Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar13 = map.addMarker(new MarkerOptions().position(LOCATION_CROD).title("Crocodile Pub").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));
                        final Marker bar14 = map.addMarker(new MarkerOptions().position(LOCATION_METAXI).title("Metaxi Mas Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.bars)));

                        //clubs
                        final Marker club1 = map.addMarker(new MarkerOptions().position(LOCATION_LOFT).title("Loft Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
                        final Marker club2 = map.addMarker(new MarkerOptions().position(LOCATION_VIBES).title("Vibes Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
                        final Marker club3 = map.addMarker(new MarkerOptions().position(LOCATION_AMNESIA).title("Amnesia Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));
                        final Marker club4 = map.addMarker(new MarkerOptions().position(LOCATION_SUMMER).title("Summer Club").icon(BitmapDescriptorFactory.fromResource(R.drawable.clubmarker)));


                        //atms
                        final Marker atm1 = map.addMarker(new MarkerOptions().position(LOCATION_BANK).title("Bank of Cyprus 0660").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                        final Marker atm2 = map.addMarker(new MarkerOptions().position(LOCATION_BANK2).title("Bank of Cyprus 0669").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                        final Marker atm3 = map.addMarker(new MarkerOptions().position(LOCATION_BANK3).title("Bank of Cyprus 0678").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                        final Marker atm4 = map.addMarker(new MarkerOptions().position(LOCATION_BANK4).title("Ethniki Bank 5451").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                        final Marker atm5 = map.addMarker(new MarkerOptions().position(LOCATION_BANK5).title("Pireus Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                        final Marker atm6 = map.addMarker(new MarkerOptions().position(LOCATION_BANK6).title("Alpha Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                        final Marker atm7 = map.addMarker(new MarkerOptions().position(LOCATION_BANK7).title("Bank of Cyprus 0603").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                        final Marker atm8 = map.addMarker(new MarkerOptions().position(LOCATION_BANK8).title("Hellenic Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                        final Marker atm9 = map.addMarker(new MarkerOptions().position(LOCATION_BANK9).title("Bank of Cyprus").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                        final Marker atm10 = map.addMarker(new MarkerOptions().position(LOCATION_BANK10).title("Hellenic Bank").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));
                        final Marker atm11 = map.addMarker(new MarkerOptions().position(LOCATION_BANK11).title("National Bank of Greece (Cyprus)").icon(BitmapDescriptorFactory.fromResource(R.drawable.banks)));

                        //pharmacy
                        final Marker pharm1 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM1).title("George Manolis Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
                        final Marker pharm2 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM2).title("Christofi Niki Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
                        final Marker pharm3 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM3).title("Sofia Roidi Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
                        final Marker pharm4 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM4).title("Pharmacy H''Charalambous Dora").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
                        final Marker pharm5 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM5).title("Pharmacy H''Charalambous Kleopas").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));
                        final Marker pharm6 = map.addMarker(new MarkerOptions().position(LOCATION_PHARM6).title("Lia Perikenti Pharmacy").icon(BitmapDescriptorFactory.fromResource(R.drawable.pharm)));

                        //museums
                        final Marker mus1 = map.addMarker(new MarkerOptions().position(LOCATION_MUS1).title("Pafos District Archaeological Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
                        final Marker mus2 = map.addMarker(new MarkerOptions().position(LOCATION_MUS2).title("Byzantine Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
                        final Marker mus3 = map.addMarker(new MarkerOptions().position(LOCATION_MUS3).title("Ethnographical Museum").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
                        final Marker mus4 = map.addMarker(new MarkerOptions().position(LOCATION_MUS4).title("Ethnographical Museum of Pafos").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
                        final Marker mus5 = map.addMarker(new MarkerOptions().position(LOCATION_MUS5).title("The Steni Museum of Village Life").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));
                        final Marker mus6 = map.addMarker(new MarkerOptions().position(LOCATION_MUS6).title("Kouklia Village,Paphos, Cyprus").icon(BitmapDescriptorFactory.fromResource(R.drawable.museums)));


                        //hospitals
                        final Marker hos1 = map.addMarker(new MarkerOptions().position(LOCATION_HO1).title("Paphos General Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                        final Marker hos2 = map.addMarker(new MarkerOptions().position(LOCATION_HO2).title("Iasis Private Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                        final Marker hos3 = map.addMarker(new MarkerOptions().position(LOCATION_HO3).title("Elpis Medical Centre").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                        final Marker hos4 = map.addMarker(new MarkerOptions().position(LOCATION_HO4).title("Blue Cross Medical Center").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                        final Marker hos5 = map.addMarker(new MarkerOptions().position(LOCATION_HO5).title("Evangelismos Private Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                        final Marker hos6 = map.addMarker(new MarkerOptions().position(LOCATION_HO6).title("Polis Hospital").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));
                        final Marker hos7 = map.addMarker(new MarkerOptions().position(LOCATION_HO7).title("Peyia Medical Centre").icon(BitmapDescriptorFactory.fromResource(R.drawable.hospital)));

                        //gasstations
                        final Marker gas1 = map.addMarker(new MarkerOptions().position(LOCATION_GAS1).title("EKO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
                        final Marker gas2 = map.addMarker(new MarkerOptions().position(LOCATION_GAS2).title("Petrolina Service Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
                        final Marker gas3 = map.addMarker(new MarkerOptions().position(LOCATION_GAS3).title("LUKOIL Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
                        final Marker gas4 = map.addMarker(new MarkerOptions().position(LOCATION_GAS4).title("ESSO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
                        final Marker gas5 = map.addMarker(new MarkerOptions().position(LOCATION_GAS5).title("ESSO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));
                        final Marker gas6 = map.addMarker(new MarkerOptions().position(LOCATION_GAS6).title("EKO Gas Station").icon(BitmapDescriptorFactory.fromResource(R.drawable.gasmar)));


                        //cafe

                        final Marker cafe1 = map.addMarker(new MarkerOptions().position(LOCATION_METAXI).title("Metaxi Mas Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe2 = map.addMarker(new MarkerOptions().position(LOCATION_THEHARBOUR).title("The Harbour Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe3 = map.addMarker(new MarkerOptions().position(LOCATION_HOBO).title("Hobo Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe4 = map.addMarker(new MarkerOptions().position(LOCATION_STARBUCKS).title("Starbucks Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe5 = map.addMarker(new MarkerOptions().position(LOCATION_MUSE).title("Muse Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe6 = map.addMarker(new MarkerOptions().position(LOCATION_STEVES).title("Steve's Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe7 = map.addMarker(new MarkerOptions().position(LOCATION_VIENNA).title("Vienna Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe8 = map.addMarker(new MarkerOptions().position(LOCATION_PINGIOUNO).title("Pingouino Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe9 = map.addMarker(new MarkerOptions().position(LOCATION_ALEA).title("Alea Cafe Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe10 = map.addMarker(new MarkerOptions().position(LOCATION_BOIT).title("La Boite '67").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe11 = map.addMarker(new MarkerOptions().position(LOCATION_SUIT).title("Suite48 Grill & Lounge Bar").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe12 = map.addMarker(new MarkerOptions().position(LOCATION_ARABICA).title("Arrabica Coffee shop").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe13 = map.addMarker(new MarkerOptions().position(LOCATION_OMNIA).title("Omnia 1912 Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));
                        final Marker cafe14 = map.addMarker(new MarkerOptions().position(LOCATION_HAMAM).title("Hamam").icon(BitmapDescriptorFactory.fromResource(R.drawable.cafee)));


                        // Adding new item to the ArrayList
                        markerPoints.add(point);

                        // Creating MarkerOptions
                        MarkerOptions options = new MarkerOptions();

                        // Setting the position of the marker
                        options.position(point).draggable(true);

                        /**
                         * For the start location, the color of marker is GREEN
                         * and for the end location, the color of marker is RED.
                         */
                        if (markerPoints.size() == 1) {
                            options.icon(BitmapDescriptorFactory
                                    .defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                        } else if (markerPoints.size() == 2) {
                            options.icon(BitmapDescriptorFactory
                                    .defaultMarker(BitmapDescriptorFactory.HUE_RED));
                        }

                        // Add new marker to the Google Map Android API V2
                        map.addMarker(options);

                        // Checks, whether start and end locations are captured
                        if (markerPoints.size() >= 2) {
                            LatLng origin = markerPoints.get(0);
                            LatLng dest = markerPoints.get(1);

                            Location locationA = new Location("Location A");
                            locationA.setLatitude(origin.latitude);
                            locationA.setLongitude(origin.longitude);


                            Location locationB = new Location("Location B");
                            locationB.setLatitude(dest.latitude);
                            locationB.setLongitude(dest.longitude);

                            final Snackbar snackBar = Snackbar.make(coordinatorLayout, "You Succesfully Selected Two Locations!", Snackbar.LENGTH_INDEFINITE);

                            snackBar.setAction("Dismiss", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    snackBar.dismiss();
                                }
                            });
                            snackBar.show();

                            int metres = Math.round(locationA
                                    .distanceTo(locationB));

                            // Getting URL to the Google Directions API
                            String url = getDirectionsUrl(origin, dest);

                            DownloadTask downloadTask = new DownloadTask();

                            // Start downloading json data from Google
                            // Directions API
                            downloadTask.execute(url);
                        }
                    }
                });

            } else {
                new AlertDialog.Builder(this)
                        .setTitle("No Internet Connection")
                        .setMessage(
                                "In order to use Interactive Map Service you will need Internet Connection. Please connect to the internet.")
                        .setPositiveButton(android.R.string.yes,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        Intent intent = new Intent(
                                                Settings.ACTION_WIFI_SETTINGS);
                                        startActivity(intent);
                                    }
                                })
                        .setNegativeButton(android.R.string.no,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int which) {
                                        Interact.this.finish();
                                    }
                                }).setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }

    }

    private String getDirectionsUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + ","
                + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        /// mode
        String mode = "mode==driving";

        if(rbDriving.isChecked()){
            mode = "mode=driving";
            mMode = 0 ;
        }//else if(rbBiCycling.isChecked()){
           // mode = "mode=bicycling";
           // mMode = 1;}
        else if(rbWalking.isChecked()){
            mode = "mode=walking";
            mMode = 2;
        }

        // avoid
        String avoid = "avoid=ferries";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor + "&"
                + mode + "&" + avoid;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/"
                + output + "?" + parameters;

        return url;
    }

    /** A method to download json data from url */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e) {
            Log.d("Exception while downlo", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String> {

        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);
        }
    }

    /** A class to parse the Google Places in JSON format */
    private class ParserTask extends
            AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(
                String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
                routeInstructions = parser.getRouteInstructions();

                for (int i = 0; i < routeInstructions.size(); i++)
                    System.out.println("Instruction " + i + " is: "
                            + routeInstructions.get(i));

            } catch (Exception e) {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);


                    if(j==0){    // Get distance from the list
                        distance = (String)point.get("distance");
                        continue;
                    }else if(j==1){ // Get duration from the list
                        duration = (String)point.get("duration");
                        continue;
                    }


                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(2);
                ////////////////
                if(mMode==MODE_DRIVING)
                    lineOptions.color(Color.RED);
                //else if(mMode==MODE_BICYCLING)
                  //  lineOptions.color(Color.GREEN);
                else if(mMode==MODE_WALKING)
                    lineOptions.color(Color.BLUE);
            }

            final Snackbar snackBar = Snackbar.make(coordinatorLayout, "Distance: " + distance + " Duration: " + duration, Snackbar.LENGTH_INDEFINITE);

            snackBar.setAction("Dismiss", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackBar.dismiss();
                }
            });
            snackBar.show();
            //Toast.makeText(Interact.this, "Distance: "+distance+" Duration: "+duration, Toast.LENGTH_LONG).show();


            // Drawing polyline in the Google Map for the i-th route
            map.addPolyline(lineOptions);
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        return ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE))
                .getActiveNetworkInfo() != null;

    }


@Override
public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app,menu);
        return true;
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
    }
    @Override
    protected void onPause() {
        super.onPause();

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
