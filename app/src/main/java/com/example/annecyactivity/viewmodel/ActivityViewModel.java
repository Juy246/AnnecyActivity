package com.example.annecyactivity.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.annecyactivity.data.model.Activity;
import com.example.annecyactivity.data.repository.ActivityRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityViewModel extends ViewModel {
    private final ActivityRepository repository = new ActivityRepository();
    private final MutableLiveData<List<Activity>> activities = new MutableLiveData<>();
    private String currentWeatherCondition = "clear"; // valeur par défaut

    public LiveData<List<Activity>> getActivities() {
        return activities;
    }

    // Charge les activités selon la météo actuelle
    public void loadActivities(String weatherCondition) {
        currentWeatherCondition = weatherCondition;
        activities.setValue(repository.getAllActivities(weatherCondition));
    }

    // Filtre selon météo, température, intérieur/extérieur
    public void filterActivities(String weather, double temp, boolean isOutside) {
        List<Activity> filtered = repository.getAllActivities(weather).stream()
                .filter(a -> a.getSuggestedWeather().equalsIgnoreCase(weather)
                        && a.isOutside() == isOutside)
                .collect(Collectors.toList());
        activities.setValue(filtered);
    }
}
