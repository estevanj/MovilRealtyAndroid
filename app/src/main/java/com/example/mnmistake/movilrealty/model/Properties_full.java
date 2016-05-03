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

    public Properties_full(String address, Double price, int bed, int bath, int sqFt, String acres) {
        Adress = address;
        Price = price;
        Bed = bed;
        Bath = bath;
        this.sqFt = sqFt;
        this.acres = acres;
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


}
