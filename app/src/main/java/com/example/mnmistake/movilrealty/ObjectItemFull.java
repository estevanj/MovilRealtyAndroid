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
    private static List<String> itemsphotos= new ArrayList<String>();

    public ObjectItemFull(List<Properties_full> items, List<String> itemsphotos) {
        this.items = items;
        this.itemsphotos=itemsphotos;
    }

    public static List<Properties_full> getItems() {
        return items;
    }

    public static List<String> getItemsphotos() {
        return itemsphotos;
    }


}
