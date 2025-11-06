package com.example.annecyactivity.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Activity implements Serializable {
    private String id;
    private String name;
    private String location;
    private double price;
    private String description;
    private boolean isOutside;
    private String suggestedWeather;
    private int imageResId;
    public Activity(String id, String name, String location, double price, String description, boolean isOutside, String suggestedWeather, int imageResId) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.isOutside = isOutside;
        this.suggestedWeather = suggestedWeather;
        this.imageResId = imageResId;
    }

    public String getId() {return id;}
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public double getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }
    public boolean isOutside() {
        return isOutside;
    }
    public String getSuggestedWeather() { return suggestedWeather; }
    public int getImageResId() { return imageResId; }

    @Override
    public String toString() {
        return name + " (" + location + ") - " + price + "€";
    }

}
