package com.example.mnmistake.movilrealty;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.mnmistake.movilrealty.model.MyItem;
import com.example.mnmistake.movilrealty.model.Properties_full;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MnMistake on 4/10/2016.
 */

public class JsonReaderbyId extends AsyncTask<String, Integer, List<Properties_full>>{
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
                items.add(new Properties_full(Adress,Price ,Bed ,Bath,sqFt,acres));
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
    protected List<Properties_full> doInBackground(String... URLS) {
        try {
            itemssend = new ArrayList<Properties_full>();
            p= new ArrayList<String>();
            itemssend = JsonReaderbyId.readJsonFromUrl(URLS[0]);
            p= JsonReaderbyId.readJsonphotos(URLS[0]);


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
        ObjectItemFull o=new ObjectItemFull(s,p,foto);
        Log.d("afaf", foto);
       // Log.d("fotos",p.toString());
    }
}
