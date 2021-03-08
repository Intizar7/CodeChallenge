package com.najimaddinova.autoscout24codechallenge;
class ListItemData {

    private String name;
    private int colorValue;
    public ListItemData(String name, int colorValue) {
        this.name = name;
        this.colorValue = colorValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getColorValue() {
        return colorValue;
    }

}
