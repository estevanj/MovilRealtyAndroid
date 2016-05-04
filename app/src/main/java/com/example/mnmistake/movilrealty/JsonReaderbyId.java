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
                //////detalles
                int d_id= object.getInt("L_ListingID");
                String d_location=object.getString("LM_Char10_14");
                String d_type=object.getString("L_Type_");
                int d_year=object.getInt("LM_Int2_10");
                ///School Information
                String elementary=object.getString("LM_Char10_14");
                String middle=object.getString("LM_Char10_16");
                String high=object.getString("LM_Char10_18");
                ////Listing Information
                String i_Status=object.getString("L_Status");
                String i_Category=object.getString("L_Class");
                String i_proportytype=object.getString("L_Type_");
                String i_Subdivision=object.getString("LM_Char10_7");
                int i_TotalLivingArea=object.getInt("LM_Int2_5");
                int i_Bedrooms=object.getInt("LM_Int1_1");
                int i_FullBathroom=object.getInt("LM_Int1_2");
                int i_HalfBathrooms=object.getInt("LM_Int1_3");
                int i_Garage=object.getInt("LM_Int1_7");
                String i_NewConst=object.getString("LM_Char1_7");
                String i_AproxAcres=object.getString("LM_Char10_21");
                int i_LotNumber=object.getInt("LM_Char10_20");
                int i_YearBuilt=object.getInt("LM_Int2_10");
                final String i_Directions=object.getString("LM_char255_1");
                ////Sqt  Information
                int s_TotalLivingArea=object.getInt("LM_Int2_5");
                int s_AboveGrade=object.getInt("LM_Int2_3");
                //////Dimensions
                String d_Kitchen=object.getString("LM_Char25_8");
                String d_Garage=object.getString("LM_Char25_20");
                String d_LivingRoom=object.getString("LM_Char25_4");
                String d_FamilyRoom=object.getString("LM_Char25_6");
                String d_Patio=object.getString("LM_Char25_24");
                String d_MasterBedroom=object.getString("LM_Char25_10");
                String d_Bedroom2=object.getString("LM_Char25_11");
                String d_Bedroom3=object.getString("LM_Char25_12");
                String d_Bedroom4=object.getString("LM_Char25_13");
                String d_Bedroom5=object.getString("LM_Char25_14");
                ////Home Owners Association
                String h_Fees1 =object.getString("LM_Char1_17");
                String h_Fees2=object.getString("LM_Char1_18") ;
                String h_Free1=object.getString("LM_char10_52") ;
                String h_Free2=object.getString("LM_char10_53") ;
                String h_Mgmt=object.getString("LM_Char25_28");
                Double h_Feesmoney= object.getDouble("LM_Dec_4");
                ///Features
                String f_AC=object.getString("LFD_AC_9");
                String f_acres=object.getString("LM_Char10_21");
                String f_Basement=object.getString("LFD_BasementDescription_6");
                String f_Design=object.getString("LFD_Design_1");
                String f_Dining=object.getString("LFD_Dining_21");
                String f_Equipment =object.getString("LFD_EquipmentAppliances_24");
                String f_Exterior =object.getString("LFD_ExteriorFinish_4");
                String f_Fireplace=object.getString("LFD_FireplaceDescription_13");
                String f_Flooring=object.getString("LFD_Flooring_8");
                String f_Foundation=object.getString("LFD_Foundation_5");
                String f_Fuel=object.getString("LFD_FuelHeat_11");
                String f_Heating=object.getString("LFD_Heating_10");
                String f_Interior =object.getString("LFD_InteriorFeatures_25");
                String f_LotDescription =object.getString("LFD_LotDescription_15");
                String f_Parking=object.getString("LFD_Parking_16");
                String f_Roof=object.getString("LFD_Roof_7");
                String f_Style=object.getString("LFD_Style_3");
                String f_Washer=object.getString("LFD_WasherDryerLocation_23");
                String f_Waterheater=object.getString("LFD_WaterHeater_12");
                String f_Watersewer=object.getString("LFD_WaterSewer_14");
                ///////"Listing Agent
                String a_ListAgen=object.getString("L_ListAgent1");
                String a_NameAgent=object.getString("LA1_UserFirstName");
                String a_AgentPhone=object.getString("LA1_PhoneNumber1");
                String a_OfficeName=object.getString("LO1_OrganizationName");


                items.add(new Properties_full(Adress,Price ,Bed ,Bath,sqFt,acres, d_id, d_location, d_type, d_year, elementary, middle,
                        high, i_Status, i_Category, i_proportytype, i_Subdivision, i_TotalLivingArea, i_Bedrooms, i_FullBathroom, i_HalfBathrooms,
                        i_Garage, i_NewConst, i_AproxAcres, i_LotNumber, i_YearBuilt, i_Directions, s_TotalLivingArea, s_AboveGrade, d_Kitchen, d_Garage,
                        d_LivingRoom, d_FamilyRoom, d_Patio, d_MasterBedroom, d_Bedroom2, d_Bedroom3, d_Bedroom4, d_Bedroom5, h_Fees1, h_Fees2, h_Free1, h_Free2,
                        h_Mgmt, h_Feesmoney, f_AC, f_acres, f_Basement, f_Design, f_Dining, f_Equipment, f_Exterior, f_Fireplace, f_Flooring, f_Foundation, f_Fuel,
                        f_Heating, f_Interior, f_LotDescription, f_Parking, f_Roof, f_Style, f_Washer, f_Waterheater, f_Watersewer, a_ListAgen, a_NameAgent, a_AgentPhone,
                        a_OfficeName));
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
        Log.d("hello", itemssend.toString());
       // Log.d("fotos",p.toString());
    }
}
