package com.sample.projects.myrentcalculator.model;

public class BaseListModel {

    public static final int TYPE_ITEM = 0;
    public static final int TYPE_HEADER = 1;
    public static final int TYPE_TRAILER = 2;

    private int itemType;

    public BaseListModel() {}

    public boolean isHeader() {
        return itemType == TYPE_HEADER;
    }

    public boolean isItem() {
        return itemType == TYPE_ITEM;
    }

    public boolean isTrailer() {
        return itemType == TYPE_TRAILER;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
