package com.example.mnmistake.movilrealty;

import android.os.AsyncTask;
import android.util.Log;

import com.example.mnmistake.movilrealty.model.Properties_full;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MnMistake on 4/10/2016.
 */

public class JsonReaderbyId extends AsyncTask<String, Integer,  List<Properties_full>>{
    private static int id;
    private List<Properties_full> itemssend;
    private ArrayList<String> p;
    private String foto;

    JsonReaderbyId(int id){
        this.id=id;
    }

    public static List readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url+id).openStream();
       // Log.d("url", url+id);
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = rd.readLine();
            ////Detalle
            JSONObject jsonObj = new JSONObject(jsonText);
            JSONArray json = jsonObj.getJSONArray("info");
            List<Properties_full> items = new ArrayList<Properties_full>();
            for (int i = 0; i < json.length(); i++) {
                JSONObject object = json.getJSONObject(i);
                String Adress=object.getString("L_Address");
                Double Price=object.getDouble("L_AskingPrice");
                int Bed=object.getInt("LM_Int1_1");
                int Bath=object.getInt("LM_Int1_2");
                int sqFt=object.getInt("LM_Int2_5");
                String acres=object.getString("LM_Char10_21");
                items.add(new Properties_full(Adress,Price ,Bed ,Bath,sqFt,acres, id, location, type, year, elementary, middle,
                        high, i_status, i_category, i_proportytype, i_subdivision, i_totalLivingArea, i_bedrooms, i_fullBathroom, i_halfBathrooms,
                        i_garage, i_newConst, i_aproxAcres, i_lotNumber, i_yearBuilt, i_directions, s_totalLivingArea, s_aboveGrade, d_kitchen, d_garage,
                        d_livingRoom, d_familyRoom, d_patio, d_masterBedroom, d_bedroom2, d_bedroom3, d_bedroom4, d_bedroom5, h_fees1, h_fees2, h_free1, h_free2,
                        h_mgmt, h_feesmoney, f_ac, f_acres, f_basement, f_design, f_dining, f_equipment, f_exterior, f_fireplace, f_flooring, f_foundation, f_fuel,
                        f_heating, f_interior, f_lotDescription, f_parking, f_roof, f_style, f_washer, f_waterheater, f_watersewer, a_listAgen, a_nameAgent, a_agentPhone,
                        a_officeName));
            }

            return items;
        //    return json;
        } finally {
            is.close();
        }
    }

    public static ArrayList readJsonphotos(String url) throws IOException, JSONException {
        InputStream is = new URL(url+id).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = rd.readLine();
            ////Detalle
            JSONObject jsonObj = new JSONObject(jsonText);
            ///Imagenes
            JSONArray jsonphotos = jsonObj.getJSONArray("images");
            ArrayList<String> photos = new ArrayList<String>();

            for(int j=0;j<jsonphotos.length();j++){
                JSONObject objectphotos = jsonphotos.getJSONObject(j);
                String path=objectphotos.getString("path");
                photos.add(j,path);
            }
            return photos;
            //    return json;
        } finally {
            is.close();
        }
    }

    @Override
    protected  List<Properties_full> doInBackground(String... URLS) {
        Boolean res=false;
        try {
            itemssend = new ArrayList<Properties_full>();
            p= new ArrayList<String>();
            p= JsonReaderbyId.readJsonphotos(URLS[0]);
            itemssend = JsonReaderbyId.readJsonFromUrl(URLS[0]);
            res=true;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return itemssend;
    }

    @Override
    protected void onPostExecute(List<Properties_full> s) {
        super.onPostExecute(s);
        foto=p.get(0);
        new ObjectItemFull(itemssend,p,foto);
        Log.d("afaf", foto);
       // Log.d("fotos",p.toString());
    }
}
