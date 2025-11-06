package com.example.annecyactivity.data.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class WeatherCondition implements Serializable {
    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;
    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
