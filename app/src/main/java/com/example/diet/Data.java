package com.example.diet;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Data {

    private String recycler_text1;

    public Data(String recycler_text1, String recycler_text2, int recycler_image) {
        this.recycler_text1 = recycler_text1;
        this.recycler_text2 = recycler_text2;
        this.recycler_image = recycler_image;
    }

    private String recycler_text2;

    public String getRecycler_text1() {
        return recycler_text1;
    }

    public void setRecycler_text1(String recycler_text1) {
        this.recycler_text1 = recycler_text1;
    }

    public String getRecycler_text2() {
        return recycler_text2;
    }

    public void setRecycler_text2(String recycler_text2) {
        this.recycler_text2 = recycler_text2;
    }


    public int getRecycler_image() {
        return recycler_image;
    }

    public void setRecycler_image(int recycler_image) {
        this.recycler_image = recycler_image;
    }

    private int recycler_image;

}
