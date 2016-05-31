package com.absolutelypafos.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.absolutelypafos.R;


/**
 * Created by Aris on 19/01/2016.
 */
public class CustomListAdapterRestaurants extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final String[] data;
    private final Integer[] imgid;


    public CustomListAdapterRestaurants(Activity context, String[] itemname, Integer[] imgid, String[] data) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
        this.data=data;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText(data [position]);
        return rowView;

    }

    ;

}

