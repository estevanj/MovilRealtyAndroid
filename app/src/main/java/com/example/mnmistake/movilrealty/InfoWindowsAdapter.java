package com.example.mnmistake.movilrealty;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mnmistake.movilrealty.model.MyItem;
import com.example.mnmistake.movilrealty.model.Properties_full;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daej85432 on 15/04/2016.
 */
public class InfoWindowsAdapter implements GoogleMap.InfoWindowAdapter {

    LayoutInflater inflater=null;
    private List<Properties_full> items;
    private String fotoP;
    private MyItem clickedClusterItem;

    InfoWindowsAdapter(LayoutInflater layoutInflate,List<Properties_full> items, String fotoP, MyItem clickedClusterItem) {
        this.inflater=layoutInflate;
        this.items=items;
        this.fotoP=fotoP;
        this.clickedClusterItem=clickedClusterItem;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }


    @Override
    public View getInfoContents(Marker marker) {
        View v = inflater.inflate(R.layout.info_window, null);
        int valor=0;
        items = ObjectItemFull.getItems();
        //  Log.d("items1",items.toString());
        //  Log.d("fotos1", photos.toString());
        fotoP = ObjectItemFull.getFoto();
        valor=items.size();

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
        ImageView photo= (ImageView) v.findViewById(R.id.Iv_photos);

        for (Properties_full item : items) {
            ad= item.getAdress();
            pr="$ "+item.getPrice().toString();
            bad=item.getBed()+" Bd";
            bat=item.getBath()+" Ba" ;
            sqftt=item.getSqFt()+" Sq Ft";
            ac=item.getAcres()+ " Acres";
        }


        if (clickedClusterItem != null) {
            addres.setText(ad);
            price.setText(pr);
            bd.setText(bad);
            ba.setText(bat);
            sqft.setText(sqftt);
            acres.setText(ac);
        }
        //////Picasso for photos
        if (fotoP != null) {
            Picasso.with(v.getContext())
                    .load(fotoP)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(photo, new MarkerCallback(marker));
        }
        //  Picasso.with(v.getContext()).load(foto).placeholder(R.mipmap.ic_launcher).error(R.drawable.abc_btn_check_material).into(photo);
        return v;
    }
}