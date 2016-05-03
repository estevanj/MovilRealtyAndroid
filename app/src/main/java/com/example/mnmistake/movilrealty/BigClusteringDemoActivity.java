package com.example.mnmistake.movilrealty;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;

import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mnmistake.movilrealty.model.Properties_full;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.example.mnmistake.movilrealty.model.MyItem;
import com.squareup.picasso.Picasso;

public class BigClusteringDemoActivity extends BaseDemoActivity{
    private String PROPERTIES_URL = GLOBAL_WEB_SERVICE_URIS.PROPERTIES_DETALLE_URL;
    private ClusterManager<MyItem> mClusterManager;
    static MyItem clickedClusterItem;
    private List<Properties_full> items;
    private ArrayList<String> photos;
    private String foto;

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
                Log.d("clouster", item.toString());

                try {
                    items = new JsonReaderbyId(clickedClusterItem.getId()).execute(PROPERTIES_URL).get();
                    setPropertyData(items);
                      Log.d("items1",items.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

             //   items = ObjectItemFull.getItems();

                //  Log.d("fotos1", photos.toString());
                foto = ObjectItemFull.getFoto();


              //  getMap().setInfoWindowAdapter(new InfoWindowsAdapter(getLayoutInflater(),items,foto,clickedClusterItem));
                mClusterManager.getMarkerCollection().setOnInfoWindowAdapter(
                        new InfoWindowsAdapter(getLayoutInflater(),items,foto,clickedClusterItem));
                return false;
            }
        });

        try {
            readItems();

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




}