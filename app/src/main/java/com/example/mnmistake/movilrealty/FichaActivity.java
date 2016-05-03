package com.example.mnmistake.movilrealty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.mnmistake.movilrealty.model.Properties_full;

import java.util.List;

public class FichaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ficha);
        Intent intent = getIntent();
        List<Properties_full> propertyData = (List<Properties_full>) intent.getSerializableExtra("property_data");

        for (Properties_full item : propertyData) {
            Log.d("idk", item.getAdress().toString());
        }
    }
}
