package com.example.mnmistake.movilrealty;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.util.Log;

import com.example.mnmistake.movilrealty.model.MyItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by MnMistake on 4/10/2016.
 */
public class JsonReader extends AsyncTask<String, Integer, List<MyItem>>{
    private ProgressDialog dialog;
    private static Context mContext;
    private List<MyItem> itemssend;


    JsonReader(Context mContext){
        this.mContext=mContext;

    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static List readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = rd.readLine();
            JSONArray json = new JSONArray(jsonText);
            List<MyItem> items = new ArrayList<MyItem>();
            for (int i = 0; i < json.length(); i++) {
                JSONObject object = json.getJSONObject(i);
                int id = object.getInt("id");
                double lat = object.getDouble("latitude");
                double lng = object.getDouble("longitude");
                String Status = object.getString("status");
                items.add(new MyItem(lat, lng, id,Status));
            }
            return items;

        //    return json;
        } finally {
            is.close();
        }
    }

    @Override
    protected List<MyItem> doInBackground(String... URLS) {
        try {
            itemssend = new ArrayList<MyItem>();
            itemssend = JsonReader.readJsonFromUrl(URLS[0]);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return itemssend;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        dialog.setMessage(String.valueOf(values[0]));
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = new ProgressDialog(mContext);
        dialog.setMessage("Cargando..");
        dialog.setIndeterminate(false);
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    protected void onPostExecute(List<MyItem> s) {
        super.onPostExecute(s);
        //creacion objeto
        ObjectItem o= new ObjectItem(s);
        dialog.dismiss();
        Intent i = new Intent(mContext, BigClusteringDemoActivity.class);
        mContext.startActivity(i);
    }
}
