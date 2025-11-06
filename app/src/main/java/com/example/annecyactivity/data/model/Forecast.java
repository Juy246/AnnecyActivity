package com.example.annecyactivity.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Forecast implements Serializable {
    @SerializedName("main") private Weather weather;
    @SerializedName("weather") private List<WeatherCondition> weatherCondition;
    @SerializedName("dt")   private long dt;

    public Weather getMain() { return weather; }
    public List<WeatherCondition> getWeatherCondition() { return weatherCondition; }
    public long getDt()    { return dt; }
}
