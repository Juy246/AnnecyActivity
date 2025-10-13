package com.example.annecyactivity.data.repository;

import android.os.Bundle;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.annecyactivity.data.model.Activity;
import com.example.annecyactivity.data.model.Forecast;
import com.example.annecyactivity.network.OpenWeatherService;
import com.example.annecyactivity.network.RetrofitClientInstance;

import java.io.IOException;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class ForecastRepository {
    private final OpenWeatherService openWeatherService;
    private final MutableLiveData<Forecast> forecastLiveData = new MutableLiveData<Forecast>();
    @Inject
    public ForecastRepository(OpenWeatherService openWeatherService) {

        this.openWeatherService = openWeatherService;
    }

    public MutableLiveData<Forecast> getForecastLiveData() {
        return forecastLiveData;
    }


    public LiveData<Forecast> getAll() {
        return forecastLiveData;
    }

    //requete vers API
    public LiveData<Forecast> forecastAPI (String city, String apiKey, String units){
        Call<Forecast> call =
                openWeatherService.getForecast(city, "44e0343a7e7081c5df0a4b5f913f3c19", "metric");

        call.enqueue(new Callback<Forecast>()

        {
            // Callback invoqué quand on reçoit une réponse HTTP du serveur (200, 404, 500, …).
            @Override
            public void onResponse (Call < Forecast > call, Response< Forecast > response){


                // isSuccessful() couvre les codes 2xx. Toujours vérifier qu’il y a un body.
                if (response.isSuccessful() && response.body() != null) {
                    // Corps de réponse désérialisé par Gson en objet Forecast (selon les @SerializedName).
                    Forecast data = response.body();
                    // ➜ ICI : mettre à jour l’UI / ViewModel avec les données reçues.
                    forecastLiveData.postValue(data);

                } else {
                    // la requête a bien “réussi” au sens réseau, mais le code HTTP n’est pas 2xx
                    // (ex : 401 clé invalide, 404 ville inconnue, 429 rate limit, 500 serveur …)
                    String message = "Erreur HTTP " + response.code();


                    // On essaie de lire le message d’erreur renvoyé pour aider au débogage.
                    try {
                        if (response.errorBody() != null) {
                            message += " : " + response.errorBody().string();
                        }
                    } catch (IOException ignored) {
                        // Ignoré
                    }
                }
            }
            // Callback invoqué quand l’appel n’a pas pu aboutir (pas de réseau, timeout, etc.).
            @Override
            public void onFailure (Call < Forecast > call, Throwable t){
               // Toast.makeText(Forecast.this, "Échec réseau : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return forecastLiveData;
    }
}

