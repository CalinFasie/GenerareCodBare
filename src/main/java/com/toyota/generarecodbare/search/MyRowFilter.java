package com.toyota.generarecodbare.search;

import javax.swing.*;

public class MyRowFilter extends RowFilter {
    private String searchText;

    MyRowFilter(String searchText){
        this.searchText = searchText;
    }

    @Override
    public boolean include(Entry entry) {
        return entry.getStringValue(0).indexOf(searchText) >= 0;
    }
}
