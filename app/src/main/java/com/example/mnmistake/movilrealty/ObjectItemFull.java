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

    public ObjectItemFull(List<Properties_full> items) {
        this.items = items;
    }

    public static List<Properties_full> getItems() {
        return items;
    }

    public void setItems(List<Properties_full> items) {
        this.items = items;
    }

}
