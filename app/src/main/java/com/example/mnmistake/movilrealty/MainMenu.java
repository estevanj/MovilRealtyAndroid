package com.example.mnmistake.movilrealty;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        TextView LBRealtor = (TextView)findViewById(R.id.screen);
        LBRealtor.setBackgroundColor(ContextCompat.getColor(this, R.color.realtyOrange));
    }
}
