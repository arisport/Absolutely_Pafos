package com.absolutelypafos;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.kml.KmlContainer;
import com.google.maps.android.kml.KmlLayer;
import com.google.maps.android.kml.KmlPlacemark;
import com.google.maps.android.kml.KmlPolygon;

import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class Map extends AppCompatActivity {

    private static final int REQUEST_CODE_LOCATION = 2;
    Button buttonGeneral;
    private GoogleMap map;
    TextView actionbarcentre;

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
    private KmlLayer kmlLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);



        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.GeneralMap)).getMap();
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_GENERAL, 13);
        map.animateCamera(update);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);


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

        final Marker ficardos = map.addMarker(new MarkerOptions()
                .position(LOCATION_FICARDOS)
                .title("Ficardo Restaurant")
                .snippet("Poseidonos ave 50A, 8042\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "+357 26 960184")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker theos = map.addMarker(new MarkerOptions()
                .position(LOCATION_THEOS)
                .title("Theo's Seafood Restaurant")
                .snippet("Paphos Harbor, 8046\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "+35726932829")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker posidonas = map.addMarker(new MarkerOptions()
                .position(LOCATION_POSIDONAS)
                .title("Poseidonas Restaurant")
                .snippet("Paphos Harbor, 8046\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "+35726939400")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker mandra = map.addMarker(new MarkerOptions()
                .position(LOCATION_MANDRA)
                .title("Mandra Tavern")
                .snippet("4, Dionysou Str 8041\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "00357-26934129")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker hondros = map.addMarker(new MarkerOptions()
                .position(LOCATION_HONDROS)
                .title("Hondros Tavern")
                .snippet("96 Apostolos Pavlos Ave, 8020,\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "00357-26934256")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker vista = map.addMarker(new MarkerOptions()
                .position(LOCATION_LAVISTA)
                .title("La vista Tavern")
                .snippet("Iasonos Ave,8025,\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "00357-26934256")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker fiesta = map.addMarker(new MarkerOptions()
                .position(LOCATION_FIESTA)
                .title("Fiesta Bar & Grill")
                .snippet("Avanti Village\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker pocolo = map.addMarker(new MarkerOptions()
                .position(LOCATION_POCOLOCO)
                .title("Poco Loco Mexican Restaurant ")
                .snippet("Poseidonos Cycling Lane,Yeroskipou\n" +
                        "\n" +
                        "Paphos, Cyprus\n" +
                        "\n" +
                        "+357 99 424441")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker george = map.addMarker(new MarkerOptions()
                .position(LOCATION_7GEORGE)
                .title("7 St. Georges Tavern")
                .snippet("Anthipolochagou Georgiou Savva\n" +
                        "\n" +
                        ", Yeroskipou, Cyprus\n" +
                        "\n" +
                        "+357 26 963176")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker fettas = map.addMarker(new MarkerOptions()
                .position(LOCATION_FETTAS)
                .title("Fettas Tavern")
                .snippet("6, Kenedy Square\n" +
                        "\n" +
                        "Paphos 8027, Cyprus\n" +
                        "\n" +
                        "2693 7822")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker agora = map.addMarker(new MarkerOptions()
                .position(LOCATION_AGORA)
                .title("Agora Tavern")
                .snippet("6, Kenedy Square\n" +
                        "\n" +
                        "Paphos 8047, Cyprus\n" +
                        "\n" +
                        "99611817")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker kourides = map.addMarker(new MarkerOptions()
                .position(LOCATION_KOURIDES)
                .title("Kouridis Restaurant")
                .snippet("Charalampou Mouskou 1\n" +
                        "\n" +
                        "Paphos 8010, Cyprus\n" +
                        "\n" +
                        "+357 26 249182")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

        final Marker vasano = map.addMarker(new MarkerOptions()
                .position(LOCATION_VASANO)
                .title("Vasano Restaurant")
                .snippet("Agapinoros 26 \n" +
                        "\n" +
                        "Kato Paphos, Cyprus\n" +
                        "\n" +
                        "+357 26 942635")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurants)));
        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }

        });

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


        buttonGeneral = (Button) findViewById(R.id.buttonGeneralMap);
        buttonGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popupMenu = new PopupMenu(Map.this, buttonGeneral);
                //Inflating the Popup using xml file
                popupMenu.getMenuInflater()
                        .inflate(R.menu.popup_menu, popupMenu.getMenu());

                    /////////////////////snackbar to show what you are hiding -showing
                //registering popup with OnMenuItemClickListener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                         @Override
                                                         public boolean onMenuItemClick(MenuItem item) {
                                                             if (item.getItemId() == R.id.one) {
                                                                 if (ficardos.isVisible()) {
                                                                     ficardos.setVisible(false);
                                                                     posidonas.setVisible(false);
                                                                     theos.setVisible(false);
                                                                     mandra.setVisible(false);
                                                                     hondros.setVisible(false);
                                                                     vista.setVisible(false);
                                                                     fiesta.setVisible(false);
                                                                     pocolo.setVisible(false);
                                                                     george.setVisible(false);
                                                                     agora.setVisible(false);
                                                                     kourides.setVisible(false);
                                                                     vasano.setVisible(false);
                                                                     fettas.setVisible(false);
                                                                 } else if (!ficardos.isVisible()) {
                                                                     fettas.setVisible(true);
                                                                     ficardos.setVisible(true);
                                                                     posidonas.setVisible(true);
                                                                     theos.setVisible(true);
                                                                     mandra.setVisible(true);
                                                                     hondros.setVisible(true);
                                                                     vista.setVisible(true);
                                                                     fiesta.setVisible(true);
                                                                     pocolo.setVisible(true);
                                                                     george.setVisible(true);
                                                                     agora.setVisible(true);
                                                                     kourides.setVisible(true);
                                                                     vasano.setVisible(true);
                                                                 }
                                                             }
                                                             if (item.getItemId() == R.id.two) {
                                                                 if (bar1.isVisible()) {
                                                                     bar1.setVisible(false);
                                                                     bar2.setVisible(false);
                                                                     bar3.setVisible(false);
                                                                     bar4.setVisible(false);
                                                                     bar5.setVisible(false);
                                                                     bar6.setVisible(false);
                                                                     bar7.setVisible(false);
                                                                     bar8.setVisible(false);
                                                                     bar9.setVisible(false);
                                                                     bar10.setVisible(false);
                                                                     bar11.setVisible(false);
                                                                     bar12.setVisible(false);
                                                                     bar13.setVisible(false);
                                                                     bar14.setVisible(false);
                                                                 } else if (!bar1.isVisible()) {
                                                                     bar1.setVisible(true);
                                                                     bar2.setVisible(true);
                                                                     bar3.setVisible(true);
                                                                     bar4.setVisible(true);
                                                                     bar5.setVisible(true);
                                                                     bar6.setVisible(true);
                                                                     bar7.setVisible(true);
                                                                     bar8.setVisible(true);
                                                                     bar9.setVisible(true);
                                                                     bar10.setVisible(true);
                                                                     bar11.setVisible(true);
                                                                     bar12.setVisible(true);
                                                                     bar13.setVisible(true);
                                                                     bar14.setVisible(true);
                                                                 }
                                                             }
                                                             if (item.getItemId() == R.id.three) {

                                                                 if (club1.isVisible()) {
                                                                     club1.setVisible(false);
                                                                     club2.setVisible(false);
                                                                     club3.setVisible(false);
                                                                     club4.setVisible(false);
                                                                 } else if (!club1.isVisible()) {
                                                                     club1.setVisible(true);
                                                                     club2.setVisible(true);
                                                                     club3.setVisible(true);
                                                                     club4.setVisible(true);
                                                                 }
                                                             }

                                                             if (item.getItemId() == R.id.four) {
                                                                 if (atm1.isVisible()) {
                                                                     atm1.setVisible(false);
                                                                     atm2.setVisible(false);
                                                                     atm3.setVisible(false);
                                                                     atm4.setVisible(false);
                                                                     atm5.setVisible(false);
                                                                     atm6.setVisible(false);
                                                                     atm7.setVisible(false);
                                                                     atm8.setVisible(false);
                                                                     atm9.setVisible(false);
                                                                     atm10.setVisible(false);
                                                                     atm11.setVisible(false);
                                                                 } else if (!atm1.isVisible()) {
                                                                     atm1.setVisible(true);
                                                                     atm2.setVisible(true);
                                                                     atm3.setVisible(true);
                                                                     atm4.setVisible(true);
                                                                     atm5.setVisible(true);
                                                                     atm6.setVisible(true);
                                                                     atm7.setVisible(true);
                                                                     atm8.setVisible(true);
                                                                     atm9.setVisible(true);
                                                                     atm10.setVisible(true);
                                                                     atm11.setVisible(true);
                                                                 }
                                                             }
                                                             if (item.getItemId() == R.id.fifth) {
                                                                 if (pharm1.isVisible()) {
                                                                     pharm1.setVisible(false);
                                                                     pharm2.setVisible(false);
                                                                     pharm3.setVisible(false);
                                                                     pharm4.setVisible(false);
                                                                     pharm5.setVisible(false);
                                                                     pharm6.setVisible(false);

                                                                 } else if (!pharm1.isVisible()) {
                                                                     pharm1.setVisible(true);
                                                                     pharm2.setVisible(true);
                                                                     pharm3.setVisible(true);
                                                                     pharm4.setVisible(true);
                                                                     pharm5.setVisible(true);
                                                                     pharm6.setVisible(true);
                                                                 }
                                                             }
                                                             if (item.getItemId() == R.id.sixth) {
                                                                 if (gas1.isVisible()) {
                                                                     gas1.setVisible(false);
                                                                     gas2.setVisible(false);
                                                                     gas3.setVisible(false);
                                                                     gas4.setVisible(false);
                                                                     gas5.setVisible(false);
                                                                     gas6.setVisible(false);

                                                                 } else if (!gas1.isVisible()) {
                                                                     gas1.setVisible(true);
                                                                     gas2.setVisible(true);
                                                                     gas3.setVisible(true);
                                                                     gas4.setVisible(true);
                                                                     gas5.setVisible(true);
                                                                     gas6.setVisible(true);
                                                                 }
                                                             }
                                                             if (item.getItemId() == R.id.seventh) {
                                                                 /*
                                                                 if (atm1.isVisible()){
                                                                     atm1.setVisible(false);
                                                                     atm2.setVisible(false);
                                                                     atm3.setVisible(false);
                                                                     atm4.setVisible(false);
                                                                     atm5.setVisible(false);
                                                                     atm6.setVisible(false);
                                                                     atm7.setVisible(false);
                                                                     atm8.setVisible(false);
                                                                     atm9.setVisible(false);
                                                                     atm10.setVisible(false);
                                                                     atm11.setVisible(false);
                                                                 } else if (!atm1.isVisible()){
                                                                     atm1.setVisible(true);
                                                                     atm2.setVisible(true);
                                                                     atm3.setVisible(true);
                                                                     atm4.setVisible(true);
                                                                     atm5.setVisible(true);
                                                                     atm6.setVisible(true);
                                                                     atm7.setVisible(true);
                                                                     atm8.setVisible(true);
                                                                     atm9.setVisible(true);
                                                                     atm10.setVisible(true);
                                                                     atm11.setVisible(true);
                                                                 } */
                                                             }
                                                             if (item.getItemId() == R.id.eigth) {
                                                                 if (mus1.isVisible()) {
                                                                     mus1.setVisible(false);
                                                                     mus2.setVisible(false);
                                                                     mus3.setVisible(false);
                                                                     mus4.setVisible(false);
                                                                     mus5.setVisible(false);
                                                                     mus6.setVisible(false);

                                                                 } else if (!mus1.isVisible()) {
                                                                     mus1.setVisible(true);
                                                                     mus2.setVisible(true);
                                                                     mus3.setVisible(true);
                                                                     mus4.setVisible(true);
                                                                     mus5.setVisible(true);
                                                                     mus6.setVisible(true);

                                                                 }
                                                             }
                                                             if (item.getItemId() == R.id.nineth) {
                                                                 if (hos1.isVisible()) {
                                                                     hos1.setVisible(false);
                                                                     hos2.setVisible(false);
                                                                     hos3.setVisible(false);
                                                                     hos4.setVisible(false);
                                                                     hos5.setVisible(false);
                                                                     hos6.setVisible(false);

                                                                 } else if (!mus1.isVisible()) {
                                                                     hos1.setVisible(true);
                                                                     hos2.setVisible(true);
                                                                     hos3.setVisible(true);
                                                                     hos4.setVisible(true);
                                                                     hos5.setVisible(true);
                                                                     hos6.setVisible(true);

                                                                 }
                                                             }

                                                             if (item.getItemId() == R.id.tenth) {
                                                                 if (cafe1.isVisible()) {
                                                                     cafe1.setVisible(false);
                                                                     cafe2.setVisible(false);
                                                                     cafe3.setVisible(false);
                                                                     cafe4.setVisible(false);
                                                                     cafe5.setVisible(false);
                                                                     cafe6.setVisible(false);
                                                                     cafe7.setVisible(false);
                                                                     cafe8.setVisible(false);
                                                                     cafe9.setVisible(false);
                                                                     cafe10.setVisible(false);
                                                                     cafe11.setVisible(false);
                                                                     cafe12.setVisible(false);
                                                                     cafe13.setVisible(false);
                                                                     cafe14.setVisible(false);

                                                                 } else if (!cafe1.isVisible()) {
                                                                     cafe1.setVisible(true);
                                                                     cafe2.setVisible(true);
                                                                     cafe3.setVisible(true);
                                                                     cafe4.setVisible(true);
                                                                     cafe5.setVisible(true);
                                                                     cafe6.setVisible(true);
                                                                     cafe7.setVisible(true);
                                                                     cafe8.setVisible(true);
                                                                     cafe9.setVisible(true);
                                                                     cafe10.setVisible(true);
                                                                     cafe11.setVisible(true);
                                                                     cafe12.setVisible(true);
                                                                     cafe13.setVisible(true);
                                                                     cafe14.setVisible(true);
                                                                 }
                                                             }
                                                             return true;
                                                         }
                                                     }

                );

                popupMenu.show(); //showing popup menu
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
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
