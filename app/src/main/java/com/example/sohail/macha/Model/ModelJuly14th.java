package com.example.sohail.macha.Model;

import java.util.ArrayList;

public class ModelJuly14th {
    ArrayList<Object> Images = new ArrayList<Object>();
    private float Price;
    private String Name;

    public ModelJuly14th() {
    }

    public ArrayList<Object> getImages() {
        return Images;
    }

    public void setImages(ArrayList<Object> images) {
        Images = images;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ModelJuly14th(ArrayList<Object> images, float price, String name) {

        Images = images;
        Price = price;
        Name = name;
    }
}



