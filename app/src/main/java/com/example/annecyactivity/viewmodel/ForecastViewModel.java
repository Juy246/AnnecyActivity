package com.example.annecyactivity.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.annecyactivity.data.model.Forecast;
import com.example.annecyactivity.data.repository.ForecastRepository;

import java.util.List;

import jakarta.inject.Inject;

public class ForecastViewModel extends ViewModel {
    private final ForecastRepository repo;

    @Inject
    public ForecastViewModel(ForecastRepository repo) {
        this.repo = repo;
    }

    public LiveData<Forecast> forecastAPI (String city, String apiKey, String units){
        return repo.forecastAPI(city, apiKey, units);
    }

}
