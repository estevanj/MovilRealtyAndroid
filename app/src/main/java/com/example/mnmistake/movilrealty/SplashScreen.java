package com.example.mnmistake.movilrealty;

import android.app.Activity;
import android.os.Bundle;

public class SplashScreen extends Activity{

    private String PROPERTIES_URL = GLOBAL_WEB_SERVICE_URIS.PROPERTIES_URL;
    String[] urlToWebCall = {PROPERTIES_URL};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new JsonReader(this).execute(PROPERTIES_URL);

    }
}
