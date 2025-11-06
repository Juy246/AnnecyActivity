package com.example.annecyactivity.data.repository;

import com.example.annecyactivity.R;
import com.example.annecyactivity.data.model.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Repository pour les activités à Annecy
 * Fournit une liste d'activités recommandées selon les conditions météo
 */
public class ActivityRepository {

    /**
     * Récupère toutes les activités disponibles
     * @return Liste complète des activités
     */
    public List<Activity> getAllActivities() {
        List<Activity> activities = new ArrayList<>();

        // Activité 1 : Randonnée en montagne (Beau temps)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Randonnée en montagne",
                "Semnoz, Annecy",
                0.0,
                "Profitez du soleil pour une belle randonnée avec vue sur le lac.",
                true,
                "Clear",
                R.drawable.randonnee
                ));

        // Activité 2 : Balade autour du lac (Beau temps)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Balade autour du lac d'Annecy",
                "Lac d'Annecy",
                0.0,
                "Idéal pour marcher ou faire du vélo en bord de lac.",
                true,
                "Clear",
                R.drawable.balade
        ));

        // Activité 3 : Pique-nique au parc (Beau temps)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Pique-nique au boud du Lac",
                "Lac d'Annecy",
                0.0,
                "Détente en plein air avec une belle vue sur le lac.",
                true,
                "Clear",
                R.drawable.pique_nique
                ));

        // Activité 4 : Musée Château d'Annecy (Mauvais temps - Pluie)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Visite du musée Château d'Annecy",
                "Vieille ville",
                8.0,
                "Musée d'art et d'histoire dans un château médiéval.",
                false,
                "Rain",
                R.drawable.chateau
        ));

        // Activité 5 : Cinéma Pathé (Mauvais temps - Pluie)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Cinéma Pathé",
                "Centre commercial Courier",
                12.0,
                "Regardez des films dans le cinéma.",
                false,
                "Rain",
                R.drawable.cinema
        ));

        // Activité 6 : Ski à La Clusaz (Neige)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Ski à La Clusaz",
                "Station La Clusaz",
                35.0,
                "Journée de ski à 30 minutes d'Annecy.",
                true,
                "Snow",
                R.drawable.ski));

        return activities;
    }

    /**
     * Récupère les activités recommandées selon la météo
     * @param weatherCondition Condition météo (Clear, Rain, Snow, Wind, Fog, Clouds)
     * @return Liste des activités adaptées à la météo
     */
    public List<Activity> getActivitiesByWeather(String weatherCondition) {
        List<Activity> allActivities = getAllActivities();
        List<Activity> recommendedActivities = new ArrayList<>();

        if (weatherCondition == null || weatherCondition.isEmpty()) {
            return allActivities;
        }

        for (Activity activity : allActivities) {
            if (activity.getSuggestedWeather().equalsIgnoreCase(weatherCondition)) {
                recommendedActivities.add(activity);
            }
        }

        return recommendedActivities;
    }

    /**
     * Récupère les activités d'extérieur (pour beau temps)
     * @return Liste des activités d'extérieur
     */
    public List<Activity> getOutdoorActivities() {
        List<Activity> allActivities = getAllActivities();
        List<Activity> outdoorActivities = new ArrayList<>();

        for (Activity activity : allActivities) {
            if (activity.isOutside()) {
                outdoorActivities.add(activity);
            }

        }

        return outdoorActivities;
    }

    /**
     * Récupère une activité par son ID
     * @param activityId ID de l'activité
     * @return L'activité trouvée ou null
     */
    public Activity getActivityById(String activityId) {
        List<Activity> allActivities = getAllActivities();

        for (Activity activity : allActivities) {
            if (activity.getId().equals(activityId)) {
                return activity;
            }
        }

        return null;
    }
}
