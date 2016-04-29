package com.example.mnmistake.movilrealty;

import com.example.mnmistake.movilrealty.model.MyItem;
import com.example.mnmistake.movilrealty.model.Properties_full;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daej85432 on 19/04/2016.
 */
public class ObjectItemFull {
    static List<Properties_full> items = new ArrayList<Properties_full>();
    static ArrayList<String> itemsphotos= new ArrayList<String>();
    static String foto;

    public ObjectItemFull(List<Properties_full> items, ArrayList<String> itemsphotos,String foto) {
        this.items = items;
        this.itemsphotos=itemsphotos;
        this.foto=foto;
    }

    public static String getFoto() {
        return foto;
    }

    public static List<Properties_full> getItems() {
        return items;
    }

    public static ArrayList<String> getItemsphotos() {
        return itemsphotos;
    }


}
