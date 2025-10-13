package com.example.annecyactivity.network;

import com.example.annecyactivity.data.model.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherService {
    @GET("weather")
    Call<Forecast> getForecast(
            @Query("q") String city,         // "London" par ex.
            @Query("appid") String apiKey,   // à mettre dans BuildConfig
            @Query("units") String units     // "metric" pour °C
    );
}
