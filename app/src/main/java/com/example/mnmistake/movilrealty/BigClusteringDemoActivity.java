package com.example.mnmistake.movilrealty;

import java.io.InputStream;
import java.util.List;

import org.json.JSONException;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.example.mnmistake.movilrealty.model.MyItem;

public class BigClusteringDemoActivity extends BaseDemoActivity{
    private ClusterManager<MyItem> mClusterManager;
    static MyItem clickedClusterItem;

    @Override
    protected void startDemo() {
         getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.7595731, -79.01929969999998), 5));
         mClusterManager = new ClusterManager<MyItem>(this, getMap());
        getMap().setOnCameraChangeListener(mClusterManager);
        getMap().setOnMarkerClickListener(mClusterManager);
        getMap().setInfoWindowAdapter(mClusterManager.getMarkerManager());
        getMap().setOnInfoWindowClickListener(mClusterManager);
        mClusterManager.setOnClusterItemInfoWindowClickListener(this);
        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItem>() {
            @Override
            public boolean onClusterItemClick(MyItem item) {
                clickedClusterItem = item;
                return false;
            }
        });

        try {
            readItems();
            mClusterManager.getMarkerCollection().setOnInfoWindowAdapter(
                    new InfoWindowsAdapter(getLayoutInflater()));
        } catch (JSONException e) {
            Toast.makeText(this, "Problem reading list of markers.", Toast.LENGTH_LONG).show();
        }
    }

    private void readItems() throws JSONException {

       // InputStream inputStream = getResources().openRawResource(R.raw.radar_search);
        List<MyItem> items;// = new MyItemReader().read(inputStream);
        items= ObjectItem.getItems();

      //  for (int i = 0; i < 10; i++) {
            for (MyItem item : items) {
                LatLng position = item.getPosition();
                int id = item.getId();
                double lat = position.latitude ;
                double lng = position.longitude ;
                String Status=item.getStatus();
                MyItem offsetItem = new MyItem(lat, lng, id, Status);
                mClusterManager.addItem(offsetItem);
            }
     //   }
    }

    public class InfoWindowsAdapter implements GoogleMap.InfoWindowAdapter {

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
            tvLng.setText("Estado:"+ marker.getPosition().latitude);
            // Returning the view containing InfoWindow contents
            return v;
        }
    }

}