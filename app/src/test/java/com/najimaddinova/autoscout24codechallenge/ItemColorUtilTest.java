package com.najimaddinova.autoscout24codechallenge;

import android.graphics.Color;

import org.junit.Test;

import static com.najimaddinova.autoscout24codechallenge.ItemColorUtil.calculateColor;
import static org.junit.Assert.assertEquals;

public class ItemColorUtilTest {
    @Test
    public void calculates_color_value(){

        int colorValue;

        colorValue = calculateColor(5);
        assertEquals(android.graphics.Color.BLUE, colorValue);
        colorValue = calculateColor(20);
        assertEquals(android.graphics.Color.BLUE, colorValue);

        colorValue = calculateColor(3);
        assertEquals(Color.RED,colorValue);
        colorValue = calculateColor(12);
        assertEquals(Color.RED,colorValue);

        colorValue = calculateColor(15);
        assertEquals(Color.YELLOW,colorValue);
        colorValue = calculateColor(45);
        assertEquals(Color.YELLOW,colorValue);

        colorValue = calculateColor(17);
        assertEquals(Color.TRANSPARENT, colorValue);
    }
}