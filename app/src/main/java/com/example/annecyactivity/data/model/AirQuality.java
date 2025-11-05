package com.example.annecyactivity.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AirQuality implements Serializable {
    @SerializedName("list")
    public List<AirInfo> list;

    public static class AirInfo {
        @SerializedName("main")
        public AQMain main;
    }

    public static class AQMain {
        @SerializedName("aqi")
        public int aqi;
    }
}
