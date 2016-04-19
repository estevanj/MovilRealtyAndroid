package com.example.mnmistake.movilrealty;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.mnmistake.movilrealty.model.MyItem;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by daej85432 on 15/04/2016.
 */
public class InfoWindowsAdapter implements GoogleMap.InfoWindowAdapter {
    private MyItem clickedClusterItem;
    InfoWindowsAdapter(MyItem clickedClusterItem){
        this.clickedClusterItem=clickedClusterItem;
    }
    LayoutInflater inflater=null;

     InfoWindowsAdapter(LayoutInflater layoutInflate) {
        this.inflater=layoutInflate;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        // Getting view from the layout file info_window_layout
        View v = inflater.inflate(R.layout.info_window, null);
        // Getting the position from the marker
        LatLng latLng = marker.getPosition();
        // Getting reference to the TextView to set latitude
        TextView tvLat = (TextView) v.findViewById(R.id.tv_lat);
        // Getting reference to the TextView to set longitude
        TextView tvLng = (TextView) v.findViewById(R.id.tv_lng);
        // Setting the latitude
        tvLat.setText("id:" +clickedClusterItem.getId());
        // Setting the longitude
        tvLng.setText("Estado: no funca");
        // Returning the view containing InfoWindow contents
        return v;
    }
}
