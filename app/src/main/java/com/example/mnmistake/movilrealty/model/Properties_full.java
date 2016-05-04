package com.example.mnmistake.movilrealty.model;

import java.io.Serializable;

/**
 * Created by daej85432 on 20/04/2016.
 */
public class Properties_full implements Serializable {
    private final String Adress;
    private final Double Price;
    private final int Bed;
    private final int Bath;
    private final int sqFt;
    private final String acres;
    //////detalles
    private final int d_id;
    private final String d_location;
    private final String d_type;
    private final int d_year;
    ///School Information
    private final String elementary;
    private final String middle;
    private final String high;
    ////Listing Information
    private final String i_Status;
    private final String i_Category;
    private final String i_proportytype;
    private final String i_Subdivision;
    private final int i_TotalLivingArea;
    private final int i_Bedrooms;
    private final int i_FullBathroom;
    private final int i_HalfBathrooms;
    private final int i_Garage;
    private final String i_NewConst;
    private final String i_AproxAcres;
    private final int i_LotNumber;
    private final int i_YearBuilt;
    private final String i_Directions;
    ////Sqt  Information
    private final int s_TotalLivingArea;
    private final int s_AboveGrade;
    //////Dimensions
    private final String d_Kitchen;
    private final String d_Garage;
    private final String d_LivingRoom;
    private final String d_FamilyRoom;
    private final String d_Patio;
    private final String d_MasterBedroom;
    private final String d_Bedroom2;
    private final String d_Bedroom3;
    private final String d_Bedroom4;
    private final String d_Bedroom5;
    ////Home Owners Association
    private final String h_Fees1 ;
    private final String h_Fees2 ;
    private final String h_Free1 ;
    private final String h_Free2 ;
    private final String h_Mgmt;
    private final Double h_Feesmoney;
    ///Features
    private final String f_AC;
    private final String f_acres;
    private final String f_Basement;
    private final String f_Design;
    private final String f_Dining;
    private final String f_Equipment ;
    private final String f_Exterior ;
    private final String f_Fireplace;
    private final String f_Flooring;
    private final String f_Foundation;
    private final String f_Fuel;
    private final String f_Heating;
    private final String f_Interior ;
    private final String f_LotDescription ;
    private final String f_Parking;
    private final String f_Roof;
    private final String f_Style;
    private final String f_Washer;
    private final String f_Waterheater;
    private final String f_Watersewer;
    ///////"Listing Agent
    private final String a_ListAgen;
    private final String a_NameAgent;
    private final String a_AgentPhone;
    private final String a_OfficeName;


    public Properties_full(String address, Double price, int bed, int bath, int sqFt, String acres, int d_id, String d_location, String d_type,
                           int d_year, String elementary, String middle, String high, String i_status, String i_category, String i_proportytype,
                           String i_subdivision, int i_totalLivingArea, int i_bedrooms, int i_fullBathroom, int i_halfBathrooms, int i_garage,
                           String i_newConst, String i_aproxAcres, int i_lotNumber, int i_yearBuilt, String i_directions, int s_totalLivingArea, int s_aboveGrade,
                           String d_kitchen, String d_garage, String d_livingRoom, String d_familyRoom, String d_patio, String d_masterBedroom, String d_bedroom2,
                           String d_bedroom3, String d_bedroom4, String d_bedroom5, String h_fees1, String h_fees2, String h_free1, String h_free2, String h_mgmt,
                           Double h_feesmoney, String f_ac, String f_acres, String f_basement, String f_design, String f_dining, String f_equipment, String f_exterior,
                           String f_fireplace, String f_flooring, String f_foundation, String f_fuel, String f_heating, String f_interior, String f_lotDescription,
                           String f_parking, String f_roof, String f_style, String f_washer, String f_waterheater, String f_watersewer, String a_listAgen, String a_nameAgent,
                           String a_agentPhone, String a_officeName) {
        Adress = address;
        Price = price;
        Bed = bed;
        Bath = bath;
        this.sqFt = sqFt;
        this.acres = acres;
        this.d_id = d_id;
        this.d_location = d_location;
        this.d_type = d_type;
        this.d_year = d_year;
        this.elementary = elementary;
        this.middle = middle;
        this.high = high;
        this.i_Status = i_status;
        this.i_Category = i_category;
        this.i_proportytype = i_proportytype;
        this.i_Subdivision = i_subdivision;
        this.i_TotalLivingArea = i_totalLivingArea;
        this.i_Bedrooms = i_bedrooms;
        this.i_FullBathroom = i_fullBathroom;
        this.i_HalfBathrooms = i_halfBathrooms;
        this.i_Garage = i_garage;
        this.i_NewConst = i_newConst;
        this.i_AproxAcres = i_aproxAcres;
        this.i_LotNumber = i_lotNumber;
        this.i_YearBuilt = i_yearBuilt;
        this.i_Directions = i_directions;
        this.s_TotalLivingArea = s_totalLivingArea;
        this.s_AboveGrade = s_aboveGrade;
        this.d_Kitchen = d_kitchen;
        this.d_Garage = d_garage;
        this.d_LivingRoom = d_livingRoom;
        this.d_FamilyRoom = d_familyRoom;
        this.d_Patio = d_patio;
        this.d_MasterBedroom = d_masterBedroom;
        this.d_Bedroom2 = d_bedroom2;
        this.d_Bedroom3 = d_bedroom3;
        this.d_Bedroom4 = d_bedroom4;
        this.d_Bedroom5 = d_bedroom5;
        this.h_Fees1 = h_fees1;
        this.h_Fees2 = h_fees2;
        this.h_Free1 = h_free1;
        this.h_Free2 = h_free2;
        this.h_Mgmt = h_mgmt;
        this.h_Feesmoney = h_feesmoney;
        this.f_AC = f_ac;
        this.f_acres = f_acres;
        this.f_Basement = f_basement;
        this.f_Design = f_design;
        this.f_Dining = f_dining;
        this.f_Equipment = f_equipment;
        this.f_Exterior = f_exterior;
        this.f_Fireplace = f_fireplace;
        this.f_Flooring = f_flooring;
        this.f_Foundation = f_foundation;
        this.f_Fuel = f_fuel;
        this.f_Heating = f_heating;
        this.f_Interior = f_interior;
        this.f_LotDescription = f_lotDescription;
        this.f_Parking = f_parking;
        this.f_Roof = f_roof;
        this.f_Style = f_style;
        this.f_Washer = f_washer;
        this.f_Waterheater = f_waterheater;
        this.f_Watersewer = f_watersewer;
        this.a_ListAgen = a_listAgen;
        this.a_NameAgent = a_nameAgent;
        this.a_AgentPhone = a_agentPhone;
        this.a_OfficeName = a_officeName;
    }

    public String getAdress() {
        return Adress;
    }

    public Double getPrice() {
        return Price;
    }

    public int getBed() {
        return Bed;
    }

    public int getSqFt() {
        return sqFt;
    }

    public int getBath() {
        return Bath;
    }

    public String getAcres() {
        return acres;
    }




    public int getD_id() {
        return d_id;
    }

    public String getD_location() {
        return d_location;
    }

    public String getD_type() {
        return d_type;
    }

    public int getD_year() {
        return d_year;
    }

    public String getElementary() {
        return elementary;
    }

    public String getMiddle() {
        return middle;
    }

    public String getHigh() {
        return high;
    }

    public String getI_Status() {
        return i_Status;
    }

    public String getI_Category() {
        return i_Category;
    }

    public String getI_proportytype() {
        return i_proportytype;
    }

    public String getI_Subdivision() {
        return i_Subdivision;
    }

    public int getI_TotalLivingArea() {
        return i_TotalLivingArea;
    }

    public int getI_Bedrooms() {
        return i_Bedrooms;
    }

    public int getI_FullBathroom() {
        return i_FullBathroom;
    }

    public int getI_HalfBathrooms() {
        return i_HalfBathrooms;
    }

    public int getI_Garage() {
        return i_Garage;
    }

    public String getI_NewConst() {
        return i_NewConst;
    }

    public String getI_AproxAcres() {
        return i_AproxAcres;
    }

    public int getI_LotNumber() {
        return i_LotNumber;
    }

    public int getI_YearBuilt() {
        return i_YearBuilt;
    }

    public String getI_Directions() {
        return i_Directions;
    }

    public int getS_TotalLivingArea() {
        return s_TotalLivingArea;
    }

    public int getS_AboveGrade() {
        return s_AboveGrade;
    }

    public String getD_Kitchen() {
        return d_Kitchen;
    }

    public String getD_Garage() {
        return d_Garage;
    }

    public String getD_LivingRoom() {
        return d_LivingRoom;
    }

    public String getD_FamilyRoom() {
        return d_FamilyRoom;
    }

    public String getD_Patio() {
        return d_Patio;
    }

    public String getD_MasterBedroom() {
        return d_MasterBedroom;
    }

    public String getD_Bedroom2() {
        return d_Bedroom2;
    }

    public String getD_Bedroom3() {
        return d_Bedroom3;
    }

    public String getD_Bedroom4() {
        return d_Bedroom4;
    }

    public String getD_Bedroom5() {
        return d_Bedroom5;
    }

    public String getH_Fees1() {
        return h_Fees1;
    }

    public String getH_Fees2() {
        return h_Fees2;
    }

    public String getH_Free1() {
        return h_Free1;
    }

    public String getH_Free2() {
        return h_Free2;
    }

    public String getH_Mgmt() {
        return h_Mgmt;
    }

    public Double getH_Feesmoney() {
        return h_Feesmoney;
    }

    public String getF_AC() {
        return f_AC;
    }

    public String getF_acres() {
        return f_acres;
    }

    public String getF_Basement() {
        return f_Basement;
    }

    public String getF_Design() {
        return f_Design;
    }

    public String getF_Dining() {
        return f_Dining;
    }

    public String getF_Equipment() {
        return f_Equipment;
    }

    public String getF_Exterior() {
        return f_Exterior;
    }

    public String getF_Fireplace() {
        return f_Fireplace;
    }

    public String getF_Flooring() {
        return f_Flooring;
    }

    public String getF_Foundation() {
        return f_Foundation;
    }

    public String getF_Fuel() {
        return f_Fuel;
    }

    public String getF_Heating() {
        return f_Heating;
    }

    public String getF_Interior() {
        return f_Interior;
    }

    public String getF_LotDescription() {
        return f_LotDescription;
    }

    public String getF_Parking() {
        return f_Parking;
    }

    public String getF_Roof() {
        return f_Roof;
    }

    public String getF_Style() {
        return f_Style;
    }

    public String getF_Washer() {
        return f_Washer;
    }

    public String getF_Waterheater() {
        return f_Waterheater;
    }

    public String getF_Watersewer() {
        return f_Watersewer;
    }

    public String getA_ListAgen() {
        return a_ListAgen;
    }

    public String getA_NameAgent() {
        return a_NameAgent;
    }

    public String getA_AgentPhone() {
        return a_AgentPhone;
    }

    public String getA_OfficeName() {
        return a_OfficeName;
    }

}
