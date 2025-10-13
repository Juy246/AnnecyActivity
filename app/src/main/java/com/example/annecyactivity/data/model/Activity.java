package com.example.annecyactivity.data.model;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String id;
    private String name;
    private String location;
    private double price;
    private String description;
    private boolean isOutside;

    public Activity(String id, String name, String location, double price, String description, boolean isOutside) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.isOutside = isOutside;
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

    @Override
    public String toString() {
        return name + " (" + location + ") - " + price + "€";
    }

}
