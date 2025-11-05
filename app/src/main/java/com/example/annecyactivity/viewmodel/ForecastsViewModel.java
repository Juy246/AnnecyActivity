package com.example.annecyactivity.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel; // MutableLiveData n'est pas nécessaire ici

import com.example.annecyactivity.data.model.Forecast;
import com.example.annecyactivity.data.repository.ForecastRepository;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ForecastsViewModel extends ViewModel {

    private final ForecastRepository repo;
    //Déclarez un LiveData immuable pour que l'UI ne puisse pas le modifier.
    private final LiveData<Forecast> forecastData;

    @Inject
    public ForecastsViewModel(ForecastRepository repo) {
        this.repo = repo;
        // Liez le LiveData du ViewModel à celui du Repository une seule fois, dans le constructeur.
        this.forecastData = repo.getForecastLiveData();
    }

    // L'UI utilisera cette méthode pour OBSERVER les changements.
    public LiveData<Forecast> getForecast() {
        return forecastData;
    }

    // L'UI appellera cette méthode pour DÉCLENCHER la requête.
    public void fetchForecast(String city, String apiKey, String units) {
        repo.fetchForecast(city, apiKey, units);
    }
}
