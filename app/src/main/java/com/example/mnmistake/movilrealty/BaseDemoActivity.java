package com.example.mnmistake.movilrealty;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.example.mnmistake.movilrealty.model.MyItem;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;


public abstract class BaseDemoActivity extends FragmentActivity implements OnMapReadyCallback, ClusterManager.OnClusterClickListener<MyItem>,
        ClusterManager.OnClusterInfoWindowClickListener<MyItem>,
        ClusterManager.OnClusterItemClickListener<MyItem>,
        ClusterManager.OnClusterItemInfoWindowClickListener<MyItem>{

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


    @Override
    public boolean onClusterClick(Cluster<MyItem> cluster) {
        Toast.makeText(this, "onClusterClick", Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onClusterInfoWindowClick(Cluster<MyItem> cluster) {
        Toast.makeText(this, "onClusterInfoWindowClick", Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onClusterItemClick(MyItem myItem) {
        int id= myItem.getId();
        Toast.makeText(this,id,Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onClusterItemInfoWindowClick(MyItem myItem) {

        int id= myItem.getId();
        Toast.makeText(this,"windows"+id,Toast.LENGTH_LONG).show();
    }
}
