package com.example.mnmistake.movilrealty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SplashScreen extends AppCompatActivity implements IRestFullServices{

    private String PROPERTIES_URL = GLOBAL_WEB_SERVICE_URIS.PROPERTIES_URL;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

    public void callWebService(String PROPERTIES_URL) {
        this.PROPERTIES_URL = PROPERTIES_URL;
        JSONObject json = null;
        try {
            json = JsonReader.readJsonFromUrl(this.PROPERTIES_URL);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(json.toString());
    }
}
