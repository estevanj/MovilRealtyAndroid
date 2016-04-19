package com.example.mnmistake.movilrealty;

import com.example.mnmistake.movilrealty.model.MyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daej85432 on 19/04/2016.
 */
public class ObjectItem {
    static List<MyItem> items = new ArrayList<MyItem>();

    public ObjectItem(List<MyItem> items) {
        this.items = items;
    }

    public static List<MyItem> getItems() {
        return items;
    }

    public void setItems(List<MyItem> items) {
        this.items = items;
    }




}
