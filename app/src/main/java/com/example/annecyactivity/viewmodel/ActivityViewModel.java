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

    public LiveData<List<Activity>> getActivities() { return activities; }

    public void loadActivities() {
        activities.setValue(repository.getAllActivities());
    }

    public void filterActivities(String weather, double temp, boolean isOutside) {
        List<Activity> filtered = repository.getAllActivities().stream()
                .filter(a -> a.getSuggestedWeather().equalsIgnoreCase(weather)
                        && a.isOutside() == isOutside)
                .collect(Collectors.toList());
        activities.setValue(filtered);
    }
}
