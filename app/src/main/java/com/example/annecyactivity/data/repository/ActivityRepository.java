package com.example.annecyactivity.data.repository;

import com.example.annecyactivity.data.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class ActivityRepository {
    public List<Activity> getAllActivities() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Randonnée", "Lac d'Annecy", 0, "Belle balade en montagne",
                true, "Clear", "https://source.unsplash.com/600x400/?hiking"));
        activities.add(new Activity("Musée de l’art", "Centre-ville", 10, "Visite culturelle",
                false, "Rain", "https://source.unsplash.com/600x400/?museum"));
        activities.add(new Activity("Kayak", "Lac d'Annecy", 20, "Activité nautique", true,
                "Clear", "https://source.unsplash.com/600x400/?kayak"));
        return activities;
    }
}
