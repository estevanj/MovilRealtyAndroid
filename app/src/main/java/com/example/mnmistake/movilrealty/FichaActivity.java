package com.example.mnmistake.movilrealty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mnmistake.movilrealty.model.Properties_full;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FichaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ficha);
        Intent intent = getIntent();
        List<Properties_full> propertyData = (List<Properties_full>) intent.getSerializableExtra("property_data");
        String foto= intent.getStringExtra("picture_data");
        ////Objetos tools
        TextView address = (TextView) findViewById(R.id.tvAddress);
        ImageView photo= (ImageView) findViewById(R.id.photoDetail);
        ///variables

        ////initial
        String Adress="";
        Double Price=0.0;
        int Bed;
        int Bath;
        int sqFt;
        String acres;
        //////detalles
        int d_id;
        String d_location;
        String d_type;
        int d_year;
        ///School Information
        String elementary;
        String middle;
        String high;
        ////Listing Information
        String i_Status;
        String i_Category;
        String i_proportytype;
        String i_Subdivision;
        int i_TotalLivingArea;
        int i_Bedrooms;
        int i_FullBathroom;
        int i_HalfBathrooms;
        int i_Garage;
        String i_NewConst;
        String i_AproxAcres;
        int i_LotNumber;
        int i_YearBuilt;
        String i_Directions;
        ////Sqt  Information
        int s_TotalLivingArea;
        int s_AboveGrade;
        //////Dimensions
        String d_Kitchen;
        String d_Garage;
        String d_LivingRoom;
        String d_FamilyRoom;
        String d_Patio;
        String d_MasterBedroom;
        String d_Bedroom2;
        String d_Bedroom3;
        String d_Bedroom4;
        String d_Bedroom5;
        ////Home Owners Association
        String h_Fees1 ;
        String h_Fees2 ;
        String h_Free1 ;
        String h_Free2 ;
        String h_Mgmt;
        Double h_Feesmoney;
        ///Features
        String f_AC;
        String f_acres;
        String f_Basement;
        String f_Design;
        String f_Dining;
        String f_Equipment ;
        String f_Exterior ;
        String f_Fireplace;
        String f_Flooring;
        String f_Foundation;
        String f_Fuel;
        String f_Heating;
        String f_Interior ;
        String f_LotDescription ;
        String f_Parking;
        String f_Roof;
        String f_Style;
        String f_Washer;
        String f_Waterheater;
        String f_Watersewer;
        ///////"Listing Agent
        String a_ListAgen;
        String a_NameAgent;
        String a_AgentPhone;
        String a_OfficeName;

        /////Ingreso detalles Propiedades
        for (Properties_full item : propertyData) {
            Adress= item.getAdress();
            Price=item.getPrice();
            Bed=item.getBed();
            Bath=item.getBath();
            sqFt=item.getSqFt();
            acres=item.getAcres();
            //////detalles
            d_id=item.getD_id();
            d_location=item.getD_location();
            d_type=item.getD_type();
            d_year=item.getD_year();
            ///School Information
            elementary=item.getElementary();
            middle= item.getMiddle();
            high=item.getHigh();
            ////Listing Information
            i_Status=item.getI_Status();
            i_Category=item.getI_Category();
            i_proportytype=item.getI_proportytype();
            i_Subdivision=item.getI_Subdivision();
            i_TotalLivingArea=item.getI_TotalLivingArea();
            i_Bedrooms=item.getI_Bedrooms();
            i_FullBathroom=item.getI_FullBathroom();
            i_HalfBathrooms=item.getI_HalfBathrooms();
            i_Garage=item.getI_Garage();
            i_NewConst=item.getI_NewConst();
            i_AproxAcres=item.getI_AproxAcres();
            i_LotNumber=item.getI_LotNumber();
            i_YearBuilt=item.getI_YearBuilt();
            i_Directions=item.getI_Directions();
            ////Sqt  Information
            s_TotalLivingArea=item.getS_TotalLivingArea();
            s_AboveGrade=item.getS_AboveGrade();
            //////Dimensions
            d_Kitchen=item.getD_Kitchen();
            d_Garage=item.getD_Garage();
            d_LivingRoom=item.getD_LivingRoom();
            d_FamilyRoom=item.getD_FamilyRoom();
            d_Patio=item.getD_Patio();
            d_MasterBedroom=item.getD_MasterBedroom();
            d_Bedroom2=item.getD_Bedroom2();
            d_Bedroom3=item.getD_Bedroom3();
            d_Bedroom4=item.getD_Bedroom4();
            d_Bedroom5=item.getD_Bedroom5();
            ////Home Owners Association
            h_Fees1=item.getH_Fees1() ;
            h_Fees2=item.getH_Fees2() ;
            h_Free1=item.getH_Free1() ;
            h_Free2=item.getH_Free2() ;
            h_Mgmt=item.getH_Mgmt();
            h_Feesmoney=item.getH_Feesmoney();
            ///Features
            f_AC=item.getF_AC();
            f_acres=item.getF_acres();
            f_Basement=item.getF_Basement();
            f_Design=item.getF_Design();
            f_Dining=item.getF_Dining();
            f_Equipment=item.getF_Equipment() ;
            f_Exterior=item.getF_Exterior() ;
            f_Fireplace=item.getF_Fireplace();
            f_Flooring=item.getF_Flooring();
            f_Foundation=item.getF_Foundation();
            f_Fuel=item.getF_Fuel();
            f_Heating=item.getF_Heating();
            f_Interior=item.getF_Interior() ;
            f_LotDescription=item.getF_LotDescription() ;
            f_Parking=item.getF_Parking();
            f_Roof=item.getF_Roof();
            f_Style=item.getF_Style();
            f_Washer=item.getF_Washer();
            f_Waterheater=item.getF_Waterheater();
            f_Watersewer=item.getF_Watersewer();
            ///////"Listing Agent
            a_ListAgen=item.getA_ListAgen();
            a_NameAgent=item.getA_NameAgent();
            a_AgentPhone=item.getA_AgentPhone();
            a_OfficeName=item.getA_OfficeName();
        }
        address.setText(Adress);






        if (foto != null) {
            Picasso.with(this)
                    .load(foto)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(photo);
        }
    }
}
