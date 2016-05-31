package com.absolutelypafos.bus;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Route601 extends AppCompatActivity {
    private GoogleMap map;
    private static final int REQUEST_CODE_LOCATION = 2;
    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);
    //Bus Locations
    private final LatLng LOCATION_MANDRIA = new LatLng(34.71563, 32.53044);
    private final LatLng LOCATION_MANDRIA2 = new LatLng(34.71819, 32.53179);
    private final LatLng LOCATION_ANARITA = new LatLng(34.7402, 32.5327);
    private final LatLng LOCATION_ANARITA2 = new LatLng(34.73916, 32.53076);
    private final LatLng LOCATION_TIMI = new LatLng(34.73141, 32.51777);
    private final LatLng LOCATION_TIMI2 = new LatLng(34.73329, 32.51778);
    private final LatLng LOCATION_TIMI3 = new LatLng(34.73472, 32.51568);
    private final LatLng LOCATION_TIMI4 = new LatLng(34.73282, 32.51559);
    private final LatLng LOCATION_TIMI5 = new LatLng(34.73074, 32.51604);

    private final LatLng LOCATION_37 = new LatLng(34.73038, 32.51494);
    private final LatLng LOCATION_38 = new LatLng(34.73006, 32.51495);
    private final LatLng LOCATION_39 = new LatLng(34.72892, 32.51293);
    private final LatLng LOCATION_40 = new LatLng(34.72867, 32.51197);
    private final LatLng LOCATION_41 = new LatLng(34.73452, 32.49582);
    private final LatLng LOCATION_42 = new LatLng(34.73823, 32.48573);
    private final LatLng LOCATION_43 = new LatLng(34.7403, 32.47998);
    private final LatLng LOCATION_44 = new LatLng(34.74493, 32.47406);
    private final LatLng LOCATION_45 = new LatLng(34.74759, 32.47184);
    private final LatLng LOCATION_46 = new LatLng(34.74967, 32.46864);
    private final LatLng LOCATION_47 = new LatLng(34.75302, 32.46474);
    private final LatLng LOCATION_48 = new LatLng(34.75646, 32.46139);
    private final LatLng LOCATION_49 = new LatLng(34.75773, 32.45924);
    private final LatLng LOCATION_50 = new LatLng(34.7587, 32.45724);
    private final LatLng LOCATION_51 = new LatLng(34.7596, 32.45547);
    private final LatLng LOCATION_52 = new LatLng(34.76051, 32.45211);
    private final LatLng LOCATION_53 = new LatLng(34.76203, 32.45035);
    private final LatLng LOCATION_54 = new LatLng(34.76375, 32.44815);
    private final LatLng LOCATION_55 = new LatLng(34.76673, 32.44406);
    private final LatLng LOCATION_56 = new LatLng(34.76817, 32.43891);
    private final LatLng LOCATION_57 = new LatLng(34.76916, 32.43617);
    private final LatLng LOCATION_58 = new LatLng(34.77138, 32.43028);
    private final LatLng LOCATION_59 = new LatLng(34.77272, 32.42601);
    private final LatLng LOCATION_60 = new LatLng(34.77369, 32.4242);
    private final LatLng LOCATION_61 = new LatLng(34.77837, 32.42261);
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


        final Marker busstop1 = map.addMarker(new MarkerOptions().position(LOCATION_MANDRIA).title("Bus Stop 28").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop2 = map.addMarker(new MarkerOptions().position(LOCATION_MANDRIA2).title("Bus Stop 29").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop3 = map.addMarker(new MarkerOptions().position(LOCATION_ANARITA).title("Bus Stop 30").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop4 = map.addMarker(new MarkerOptions().position(LOCATION_ANARITA2).title("Bus Stop 31").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop5 = map.addMarker(new MarkerOptions().position(LOCATION_TIMI).title("Bus Stop 32").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop6 = map.addMarker(new MarkerOptions().position(LOCATION_TIMI2).title("Bus Stop 33").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop7 = map.addMarker(new MarkerOptions().position(LOCATION_TIMI3).title("Bus Stop 34").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop8 = map.addMarker(new MarkerOptions().position(LOCATION_TIMI4).title("Bus Stop 35").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop9 = map.addMarker(new MarkerOptions().position(LOCATION_TIMI5).title("Bus Stop 36").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop10 = map.addMarker(new MarkerOptions().position(LOCATION_MANDRIA).title("Bus Stop 37").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop11= map.addMarker(new MarkerOptions().position(LOCATION_MANDRIA).title("Bus Stop 38").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop12= map.addMarker(new MarkerOptions().position(LOCATION_MANDRIA).title("Bus Stop 39").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));

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
        final Marker busstop31= map.addMarker(new MarkerOptions().position(LOCATION_55).title("Bus Stop 58").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop32= map.addMarker(new MarkerOptions().position(LOCATION_56).title("Bus Stop 59").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop33= map.addMarker(new MarkerOptions().position(LOCATION_57).title("Bus Stop 60").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop34= map.addMarker(new MarkerOptions().position(LOCATION_58).title("Bus Stop 61").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));

        buttonGeneral = (Button) findViewById(R.id.buttonGeneralMap);
        buttonGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popupMenu = new PopupMenu(Route601.this, buttonGeneral);
                //Inflating the Popup using xml file
                popupMenu.getMenuInflater()
                        .inflate(R.menu.popup_menu_bus, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.one) {
                            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Route601.this,R.style.AppCompatAlertDialogStyle);
                            alertDialogBuilder .setTitle("Bus Timetable");
                            alertDialogBuilder .setMessage("Description\n" +
                                    "\n" +
                                    "Karavella (Main Station), Nikodemou Mylona, Gladstonos,Griva Digeni, Evagora Pallikarides, Char. Mouskou, Nik.Nikolaide, Kinyra, Ampelokipon, Anexartisias, Demokratias*, Archiepiskopou Makariou (Geroskipou), Koloni, Acheleia, Archiepiskopou Makariou (Timi), Salaminas (Timi), Agias Sofias (Timi), Agias Irinis (Timi), Agias Marinas (Anarita), Eleftherias (Mandria), Gypsou (Mandria).\n" +
                                    "\n" +
                                    "Monday - Friday\n" +
                                    "From Mandria : 05.45, 07.00*, 09.20*, 10.50, 12.20, 13.40*, 15.00, 16.45\n" +
                                    "From Karavella Main Station : 06.30, 08.40, 10.10*, 11.40*, 13.00*, 14.20, 16.00\n" +
                                    "Saturday\n" +
                                    "From Mandria : 05.45, 08.40\n" +
                                    "From Karavella Main Station : 08.00, 12.00\n" +
                                    "\n" +
                                    "*These certain routes, pass from Griva Digeni Avenue (Cyta Offices), Athinon Av. and not from Charalambou\n" +
                                    "Mouskou, Nik.Nikolaide, Kinyra, Ampelokipon, Anexartisias, Demokratias.");

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
            KmlLayer kmlLayer = new KmlLayer(map, R.raw.exakosiaena, getApplicationContext());
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
