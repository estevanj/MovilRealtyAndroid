package com.example.mnmistake.movilrealty;

import java.io.InputStream;
import java.util.List;

import org.json.JSONException;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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

public class BigClusteringDemoActivity extends BaseDemoActivity{
    private String PROPERTIES_URL = GLOBAL_WEB_SERVICE_URIS.PROPERTIES_DETALLE_URL;
    private ClusterManager<MyItem> mClusterManager;
    static MyItem clickedClusterItem;
    private List<Properties_full> items;


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
                new JsonReaderbyId(clickedClusterItem.getId()).execute(PROPERTIES_URL);
                items= ObjectItemFull.getItems();
                return false;
            }
        });

        try {
            readItems();
            mClusterManager.getMarkerCollection().setOnInfoWindowAdapter(
                    new InfoWindowsAdapter(
                            getLayoutInflater()));
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
            Log.d("compro",items.toString());
            View v = inflater.inflate(R.layout.info_window, null);

            String ad="";
            String pr="";
            String bad="";
            String bat="";
            String sqftt="";
            String ac="";

            TextView addres = (TextView) v.findViewById(R.id.tv_adress);
            TextView price = (TextView) v.findViewById(R.id.tv_price);
            TextView bd = (TextView) v.findViewById(R.id.tv_bd);
            TextView ba = (TextView) v.findViewById(R.id.tv_Ba);
            TextView sqft = (TextView) v.findViewById(R.id.tv_Sqft);
            TextView acres = (TextView) v.findViewById(R.id.tv_acres);

              for (Properties_full item : items) {
                ad= item.getAdress();
                pr="$ "+item.getPrice().toString();
                bad=item.getBed()+" Bd";
                bat=item.getBath()+" Ba" ;
                sqftt=item.getSqFt()+" Sq Ft";
                ac=item.getAcres()+ " Acres";
            }

            addres.setText(ad);
            price.setText(pr);
            bd.setText(bad);
            ba.setText(bat);
            sqft.setText(sqftt);
            acres.setText(ac);

            return v;
        }
    }

}