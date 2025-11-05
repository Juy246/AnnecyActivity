package com.example.annecyactivity.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.annecyactivity.data.model.Forecast;
import com.example.annecyactivity.data.repository.ForecastRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;


@HiltViewModel
public class ForecastsViewModel extends ViewModel {

    private final ForecastRepository repo;

    @Inject
    public ForecastsViewModel(ForecastRepository repo) {
        this.repo = repo;
    }

    // Expose la liste observable des prévisions
    public LiveData<Forecast> getForecasts() {
        return repo.getAll();
    }

    // L'UI appelle cette méthode pour lancer une requête réseau et récupérer les prévisions
    public LiveData<Forecast> fetchForecast(String city, String apiKey, String units) {
        return repo.fetchForecast(city, apiKey, units);
    }
}