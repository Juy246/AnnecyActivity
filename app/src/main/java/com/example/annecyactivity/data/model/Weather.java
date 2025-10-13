package com.example.annecyactivity.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Weather implements Serializable {
    @SerializedName("temp")
    private double temp;
    @SerializedName("temp_min")
    private double temp_min;
    @SerializedName("temp_max")
    private double temp_max;
    @SerializedName("condition")
    private String condition;
    @SerializedName("feels_like")
    private double feelsLike;
    @SerializedName("humidity")
    private int humidity;

    public double getTemp() { return temp; }
    public double getTemp_min() { return temp_min; }
    public double getTemp_max() { return temp_max; }
    public String getCondition() { return condition; }
    public double getFeelsLike() { return feelsLike; }
    public int getHumidity() { return humidity; }
}
