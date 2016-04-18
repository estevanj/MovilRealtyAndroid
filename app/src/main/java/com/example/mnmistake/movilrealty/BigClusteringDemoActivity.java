package com.example.mnmistake.movilrealty;

import java.io.InputStream;
import java.util.List;

import org.json.JSONException;

import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.example.mnmistake.movilrealty.model.MyItem;

public class BigClusteringDemoActivity extends BaseDemoActivity implements ClusterManager.OnClusterClickListener<MyItem>,
        ClusterManager.OnClusterInfoWindowClickListener<MyItem>,
        ClusterManager.OnClusterItemClickListener<MyItem>,
        ClusterManager.OnClusterItemInfoWindowClickListener<MyItem> {
    private ClusterManager<MyItem> mClusterManager;

    @Override
    protected void startDemo() {
        getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.503186, -0.126446), 10));
        mClusterManager = new ClusterManager<MyItem>(this, getMap());
        getMap().setOnCameraChangeListener(mClusterManager);
        try {
            readItems();
            mClusterManager.getMarkerCollection().setOnInfoWindowAdapter(
                    new InfoWindowsAdapter(getLayoutInflater()));
        } catch (JSONException e) {
            Toast.makeText(this, "Problem reading list of markers.", Toast.LENGTH_LONG).show();
        }
    }

    private void readItems() throws JSONException {
        InputStream inputStream = getResources().openRawResource(R.raw.radar_search);
        List<MyItem> items = new MyItemReader().read(inputStream);
        for (int i = 0; i < 10; i++) {
            double offset = i / 60d;
            for (MyItem item : items) {
                LatLng position = item.getPosition();
                double lat = position.latitude + offset;
                double lng = position.longitude + offset;
                MyItem offsetItem = new MyItem(lat, lng);
                mClusterManager.addItem(offsetItem);
                getMap().setInfoWindowAdapter(mClusterManager.getMarkerManager());
            }
        }
    }

    @Override
    public boolean onClusterClick(Cluster<MyItem> cluster) {
        return false;
    }

    @Override
    public void onClusterInfoWindowClick(Cluster<MyItem> cluster) {

    }

    @Override
    public boolean onClusterItemClick(MyItem myItem) {
        return false;
    }

    @Override
    public void onClusterItemInfoWindowClick(MyItem myItem) {


    }
}