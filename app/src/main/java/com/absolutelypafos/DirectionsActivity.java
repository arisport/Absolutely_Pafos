package com.absolutelypafos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.absolutelypafos.adapter.DirectionsAdapter;

import java.util.ArrayList;

public class DirectionsActivity extends AppCompatActivity {

    private ArrayList<String> routeInstructions = new ArrayList<String>();

    private ListView directionsListView;

    private DirectionsAdapter directionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        // Get references for the UI widgets
        directionsListView = (ListView)findViewById(R.id.directionsListView);

        // Get the resource ID for each item on the ListView
        int resID = R.layout.directions_item;

        // Get the ArrayList containing the route directions Strings
        routeInstructions = getIntent().getExtras().getStringArrayList("directions");

        // Create a new DirectionsAdapter passing it the context, the resource layout id and the ArrayList with the route directions Strings
        directionsAdapter = new DirectionsAdapter(getApplicationContext(), resID, routeInstructions);

        // Set the Adapter to the ListView
        directionsListView.setAdapter(directionsAdapter);

        // Notify the Adapter about the data changed
        directionsAdapter.notifyDataSetChanged();

        //for (int i = 0; i < routeInstructions.size(); i++) {
        //	System.out.println("DirectionsActivity: Instruction " + i + " is: "
        //			+ routeInstructions.get(i));
        //}


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
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

        return super.onOptionsItemSelected(item);
    }
}
