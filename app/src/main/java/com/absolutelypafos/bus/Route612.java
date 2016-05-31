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

public class Route612 extends AppCompatActivity {
    private GoogleMap map;
    private static final int REQUEST_CODE_LOCATION = 2;
    private final LatLng LOCATION_GENERAL = new LatLng(34.751930, 32.425923);
    //Bus Locations
    private final LatLng LOCATION_28 = new LatLng(34.75652, 32.41136);
    private final LatLng LOCATION_29 = new LatLng(34.75695, 32.4125);
    private final LatLng LOCATION_30 = new LatLng(34.75654, 32.41525);
    private final LatLng LOCATION_31 = new LatLng(34.75616, 32.41754);
    private final LatLng LOCATION_32 = new LatLng(34.75382, 32.42001);
    private final LatLng LOCATION_33 = new LatLng(34.75243, 32.42111);
    private final LatLng LOCATION_34 = new LatLng(34.74949, 32.4238);
    private final LatLng LOCATION_35 = new LatLng(34.74981, 32.4276);
    private final LatLng LOCATION_36 = new LatLng(34.74921, 32.42738);
    private final LatLng LOCATION_37 = new LatLng(34.74499, 32.42889);
    private final LatLng LOCATION_38 = new LatLng(34.74333, 32.43107);
    private final LatLng LOCATION_39 = new LatLng(34.74162, 32.43311);
    private final LatLng LOCATION_40 = new LatLng(34.73843, 32.4376);
    private final LatLng LOCATION_41 = new LatLng(34.74137, 32.44388);
    private final LatLng LOCATION_42 = new LatLng(34.74587, 32.44572);
    private final LatLng LOCATION_43 = new LatLng(34.75512, 32.45192);
    private final LatLng LOCATION_44 = new LatLng(34.756, 32.45611);
    private final LatLng LOCATION_45 = new LatLng(34.7562, 32.46189);
    private final LatLng LOCATION_46 = new LatLng(34.75285, 32.46514);
    private final LatLng LOCATION_47 = new LatLng(34.74535, 32.47405);
    private final LatLng LOCATION_48 = new LatLng(34.74012, 32.48065);
    private final LatLng LOCATION_49 = new LatLng(34.73868, 32.4848);
    private final LatLng LOCATION_50 = new LatLng(34.73491, 32.4951);
    private final LatLng LOCATION_51 = new LatLng(34.72878, 32.51207);
    private final LatLng LOCATION_52 = new LatLng(34.72648, 32.51618);
    private final LatLng LOCATION_53 = new LatLng(34.71143, 32.51113);
    private final LatLng LOCATION_54 = new LatLng(34.70838, 32.50358);
    Button buttonGeneral;
    private final LatLng LOCATION_55 = new LatLng(34.7075, 32.49717);
    private final LatLng LOCATION_56 = new LatLng(34.71149, 32.48902);

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
        final Marker busstop31= map.addMarker(new MarkerOptions().position(LOCATION_55).title("Bus Stop 58").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));
        final Marker busstop32= map.addMarker(new MarkerOptions().position(LOCATION_56).title("Bus Stop 59").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_image)));

        buttonGeneral = (Button) findViewById(R.id.buttonGeneralMap);
        buttonGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popupMenu = new PopupMenu(Route612.this, buttonGeneral);
                //Inflating the Popup using xml file
                popupMenu.getMenuInflater()
                        .inflate(R.menu.popup_menu_bus, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.one) {
                            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(Route612.this,R.style.AppCompatAlertDialogStyle);
                            alertDialogBuilder .setTitle("Bus Timetable");
                            alertDialogBuilder .setMessage("Harbour (Main Station), Ledas, Alkminis, Poseidonos Av., Danaes Av., Aphrodite's Av., Spyrou Kyprianou Av., Gianni Kontou, Ippokratous, Makariou Av., Paphos-Limassol old Road, Paphos Airport.\n" +
                                    "\n" +
                                    "From April to November\n" +
                                    "\n" +
                                    "From Harbour:\n" +
                                    "Monday - Sunday\n" +
                                    "7:00, 8:10, 9:20, 10:30, 11:40, 12:50, 14:00, 15:10, 16:20, 17:30, 18:40, 19:50, 21:00, 22:10, 23:20, 0:30\n" +
                                    "From Airport:\n" +
                                    "Monday - Sunday\n" +
                                    "7:35, 8:45, 9:55, 11:05, 12:15, 13:25, 14:35, 15:45, 16:55, 18:05, 19:15, 20:25, 21:35, 22:45, 23:55, 1:05\n" +
                                    "\n" +
                                    "\n" +
                                    "From December to March\n" +
                                    "From Harbour:\n" +
                                    "Monday - Sunday\n" +
                                    "10:00, 11:10, 12:20, 13:30, 14:40, 15:50, 17:00, 18:10, 19:20, 20:30\n" +
                                    "From Airport:\n" +
                                    "Monday - Sunday\n" +
                                    "10:35, 11:45, 12:55, 14:05, 15:15, 16:25, 17:35, 18:45, 19:55, 21:05");

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
            KmlLayer kmlLayer = new KmlLayer(map, R.raw.exakosiadodeka, getApplicationContext());
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
