package com.najimaddinova.autoscout24codechallenge;

public class ItemColorUtil {
    public static int calculateColor(int position){
        int colorValue = 0;
        if (position%3==0) {
            colorValue = android.graphics.Color.RED;
        }

        if (position%5==0) {
            colorValue = android.graphics.Color.BLUE;
        }

        if (position%3==0 && position%5==0) {
            colorValue = android.graphics.Color.YELLOW;
        }

        return colorValue;
    }
}
