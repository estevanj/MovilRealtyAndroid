package com.example.mnmistake.movilrealty;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.mnmistake.movilrealty.model.MyItem;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.ClusterManager;


public abstract class BaseDemoActivity extends FragmentActivity implements OnMapReadyCallback{
    private GoogleMap mMap;
    private ClusterManager<MyItem> mClusterManager;
    private MyItem clickedClusterItem;


    protected int getLayoutId() {
        return R.layout.activity_main_menu;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setUpMap();
        //setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
       setUpMap();
       // setUpMapIfNeeded();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (mMap != null) {
            return;
        }
        mMap = map;
        startDemo();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();

            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }

        }
    }

    private void setUpMap() {
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }


        /**
     * Run the demo-specific code.
     */
    protected abstract void startDemo();

    protected GoogleMap getMap() {
        return mMap;
    }
}
