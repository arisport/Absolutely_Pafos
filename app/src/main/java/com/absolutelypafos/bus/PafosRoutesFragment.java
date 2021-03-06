package com.absolutelypafos.bus;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.absolutelypafos.R;
import com.absolutelypafos.adapter.CardAdapterBus;
import com.absolutelypafos.adapter.CardAdapterCategoriesGallery;
import com.absolutelypafos.adapter.CardAdapterRoutesPaphosCity;

/**
 * A placeholder fragment containing a simple view.
 */
public class PafosRoutesFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;                                                                              //vertical
    final StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);

    public PafosRoutesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_categories_gallery, container, false);


        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new CardAdapterRoutesPaphosCity(this.getActivity());
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }
}