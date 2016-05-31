package com.absolutelypafos.bus;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.absolutelypafos.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class Route602 extends AppCompatActivity {
    private GoogleMap map;
    private static final int REQUEST_CODE_LOCATION = 2;
    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);
    //Bus Locations
    private final LatLng LOCATION_28 = new LatLng(34.77837, 32.42261);
    private final LatLng LOCATION_29 = new LatLng(34.77809, 32.41854);
    private final LatLng LOCATION_30 = new LatLng(34.77958, 32.41963);
    private final LatLng LOCATION_31 = new LatLng(34.78153, 32.42153);
    private final LatLng LOCATION_32 = new LatLng(34.78401, 32.42282);

    private final LatLng LOCATION_33 = new LatLng(34.78531, 32.42493);
    private final LatLng LOCATION_34 = new LatLng(34.78639, 32.42594);
    private final LatLng LOCATION_35 = new LatLng(34.78775, 32.42918);

    private final LatLng LOCATION_36 = new LatLng(34.78959, 32.43214);
    private final LatLng LOCATION_37 = new LatLng(34.79069, 32.43403);
    private final LatLng LOCATION_38 = new LatLng(34.78823, 32.43361);
    private final LatLng LOCATION_39 = new LatLng(34.78671, 32.43428);
    private final LatLng LOCATION_40 = new LatLng(34.78619, 32.43654);
    private final LatLng LOCATION_41 = new LatLng(34.78867, 32.44452);
    private final LatLng LOCATION_42 = new LatLng(34.78299, 32.44062);
    private final LatLng LOCATION_43 = new LatLng(34.78183, 32.44147);
    private final LatLng LOCATION_44 = new LatLng(34.78051, 32.44238);
    private final LatLng LOCATION_45 = new LatLng(34.77843, 32.44061);
    private final LatLng LOCATION_46 = new LatLng(34.77593, 32.43776);
    private final LatLng LOCATION_47 = new LatLng(34.77437, 32.43797);

    private final LatLng LOCATION_48 = new LatLng(34.77221, 32.44266);
    private final LatLng LOCATION_49 = new LatLng(34.76817, 32.43891);
    private final LatLng LOCATION_50 = new LatLng(34.76916, 32.43617);
    private final LatLng LOCATION_51 = new LatLng(34.77138, 32.43028);
    private final LatLng LOCATION_52 = new LatLng(34.77489, 32.42739);
    private final LatLng LOCATION_53 = new LatLng(34.7767, 32.42479);
    private final LatLng LOCATION_54 = new LatLng(34.77837, 32.42261);

    private final LatLng LOCATION_55 = new LatLng(34.7075, 32.49717);
    private final LatLng LOCATION_56 = new LatLng(34.71149, 32.48902);
    Button buttonGeneral;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        setContentView(R.layout.activity_map);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.GeneralMap)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        retrieveFileFromResource();


        final Marker busstop1 = map.addMarker(new MarkerOptions().position(LOCATION_28).title("Bus Stop 28").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop2 = map.addMarker(new MarkerOptions().position(LOCATION_29).title("Bus Stop 29").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop3 = map.addMarker(new MarkerOptions().position(LOCATION_30).title("Bus Stop 30").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop4 = map.addMarker(new MarkerOptions().position(LOCATION_31).title("Bus Stop 31").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop5 = map.addMarker(new MarkerOptions().position(LOCATION_32).title("Bus Stop 32").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop6 = map.addMarker(new MarkerOptions().position(LOCATION_33).title("Bus Stop 33").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop7 = map.addMarker(new MarkerOptions().position(LOCATION_34).title("Bus Stop 34").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop8 = map.addMarker(new MarkerOptions().position(LOCATION_35).title("Bus Stop 35").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop9 = map.addMarker(new MarkerOptions().position(LOCATION_36).title("Bus Stop 36").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop13 = map.addMarker(new MarkerOptions().position(LOCATION_37).title("Bus Stop 40").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop14 = map.addMarker(new MarkerOptions().position(LOCATION_38).title("Bus Stop 41").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop15 = map.addMarker(new MarkerOptions().position(LOCATION_39).title("Bus Stop 42").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop16 = map.addMarker(new MarkerOptions().position(LOCATION_40).title("Bus Stop 43").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop17 = map.addMarker(new MarkerOptions().position(LOCATION_41).title("Bus Stop 44").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop18 = map.addMarker(new MarkerOptions().position(LOCATION_42).title("Bus Stop 45").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop19 = map.addMarker(new MarkerOptions().position(LOCATION_43).title("Bus Stop 46").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop20 = map.addMarker(new MarkerOptions().position(LOCATION_44).title("Bus Stop 47").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop21 = map.addMarker(new MarkerOptions().position(LOCATION_45).title("Bus Stop 48").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop22 = map.addMarker(new MarkerOptions().position(LOCATION_46).title("Bus Stop 49").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop23= map.addMarker(new MarkerOptions().position(LOCATION_47).title("Bus Stop 50").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop24= map.addMarker(new MarkerOptions().position(LOCATION_48).title("Bus Stop 51").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop25 = map.addMarker(new MarkerOptions().position(LOCATION_49).title("Bus Stop 52").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop26 = map.addMarker(new MarkerOptions().position(LOCATION_50).title("Bus Stop 53").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop27= map.addMarker(new MarkerOptions().position(LOCATION_51).title("Bus Stop 54").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop28= map.addMarker(new MarkerOptions().position(LOCATION_52).title("Bus Stop 55").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop29= map.addMarker(new MarkerOptions().position(LOCATION_53).title("Bus Stop 56").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop30= map.addMarker(new MarkerOptions().position(LOCATION_54).title("Bus Stop 57").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
       // final Marker busstop31= map.addMarker(new MarkerOptions().position(LOCATION_55).title("Bus Stop 58").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        //final Marker busstop32= map.addMarker(new MarkerOptions().position(LOCATION_56).title("Bus Stop 59").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));

        buttonGeneral = (Button) findViewById(R.id.buttonGeneralMap);
        buttonGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popupMenu = new PopupMenu(Route602.this, buttonGeneral);
                //Inflating the Popup using xml file
                popupMenu.getMenuInflater()
                        .inflate(R.menu.popup_menu_bus, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.one) {
                            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Route602.this,R.style.AppCompatAlertDialogStyle);
                            alertDialogBuilder .setTitle("Bus Timetable");
                            alertDialogBuilder .setMessage("Description\n" +
                                    "\n" +
                                    "Karavella (Main Station), Municipal Market, Fellachoglou, Neapoleos, Al. Ypsilanti, Ellados (Dasoudi), Andrea Dimitriou, Vas. Konstantinou (Evaggelismos Hospital), Paphos General Hospital, Eleftheriou Venizelou, Alexandrou Papagou (Planet Adventure), Anexartisias, Demokratias Av., Athinon Av., Gr. Digeni Av. (Museum), N. Nikolaide (Govermental Offices), C. Mouskou, Karavella (Main Station).\n" +
                                    "\n" +
                                    "Monday - Saturday\n" +
                                    "From Karavella (Main Station):\n" +
                                    "7:00, 7:40, 8:20, 9:00, 9:40, 10:20, 12:00, 12:40, 14:20, 15:00, 15:40\n" +
                                    " \n" +
                                    " \n" +
                                    " \n" +
                                    "Please note that as from 01/07/2015 route exakosiadio will also pass from Paphos General Hospital");

                            alertDialogBuilder .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            alertDialogBuilder .setIcon(android.R.drawable.ic_dialog_alert);
                            alertDialogBuilder  .show();
                        }
                        return true;
                    }
                });
                popupMenu.show(); //showing popup menu
            }
        });

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
        return true;
    }

    private void retrieveFileFromResource() {
        try {
            KmlLayer kmlLayer = new KmlLayer(map, R.raw.exakosiadio, getApplicationContext());
            kmlLayer.addLayerToMap();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
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
