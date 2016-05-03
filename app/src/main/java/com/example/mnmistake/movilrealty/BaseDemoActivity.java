package com.example.mnmistake.movilrealty;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mnmistake.movilrealty.model.MyItem;
import com.example.mnmistake.movilrealty.model.Properties_full;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;

import java.io.Serializable;
import java.util.List;


public abstract class BaseDemoActivity extends FragmentActivity implements OnMapReadyCallback, ClusterManager.OnClusterClickListener<MyItem>,
        ClusterManager.OnClusterInfoWindowClickListener<MyItem>,
        ClusterManager.OnClusterItemClickListener<MyItem>,
        ClusterManager.OnClusterItemInfoWindowClickListener<MyItem>,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ClusterManager<MyItem> mClusterManager;
    private MyItem clickedClusterItem;
    private List<Properties_full> propertyData;


    protected int getLayoutId() {
        return R.layout.activity_main_menu;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        setUpMap();
        ImageView bLocator = (ImageView) findViewById(R.id.IBlocator);
        bLocator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                   // mMap.setMyLocationEnabled(true);
                    goToCurrentLocation();
                } else {
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext(), "no location permission ON", duration);
                    toast.show();
                }
            }
        });
        //setUpMapIfNeeded();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Log.d("asd", Integer.toString(requestCode));
        if (requestCode == 123) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            } else {
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(getApplicationContext(), "whatwhatwhat", duration);
                toast.show();
            }
        }
    }

    private void goToCurrentLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        LatLng latLng = new LatLng(location.getLatitude(),location.getLongitude());
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 18);
        mMap.animateCamera(cameraUpdate);
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

    protected void setPropertyData(List<Properties_full> data) {
        this.propertyData = data;
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
        int id = myItem.getId();
        Intent intent = new Intent(getBaseContext(), FichaActivity.class);
        intent.putExtra("property_data", (Serializable)this.propertyData);
        startActivity(intent);
        //Toast.makeText(this,"windows"+id,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(this,"marker tocado",Toast.LENGTH_LONG).show();
        return false;
    }
}
