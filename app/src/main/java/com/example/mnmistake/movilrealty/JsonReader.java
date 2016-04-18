package com.example.mnmistake.movilrealty;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.mnmistake.movilrealty.model.MyItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by MnMistake on 4/10/2016.
 */
public class JsonReader extends AsyncTask<String, Integer, String>{
    private ProgressDialog dialog;
    private static Context mContext;

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

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = rd.readLine();
            JSONArray json = new JSONArray(jsonText);
           // JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    @Override
    protected String doInBackground(String... URLS) {
        JSONArray json = null;
        List<MyItem> items;
        try {
            json = JsonReader.readJsonFromUrl(URLS[0]);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(json.toString());
        return json.toString();
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
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        dialog.dismiss();
        Intent i = new Intent(mContext, BigClusteringDemoActivity.class);

        mContext.startActivity(i);

    }
}
