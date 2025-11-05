package com.example.annecyactivity.data.repository;

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
                "https://cdn.pixabay.com/photo/2016/11/29/13/02/adventure-1868817_1280.jpg"
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
                "https://cdn.pixabay.com/photo/2016/06/29/09/20/annecy-1487297_1280.jpg"
        ));

        // Activité 3 : Pique-nique au parc (Beau temps)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Pique-nique au parc Charles Bosson",
                "Annecy centre",
                0.0,
                "Détente en plein air avec une belle vue sur le lac.",
                true,
                "Clear",
                "https://cdn.pixabay.com/photo/2017/06/17/18/31/picnic-2414007_1280.jpg"
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
                "https://cdn.pixabay.com/photo/2015/05/15/14/47/castle-768611_1280.jpg"
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
                "https://cdn.pixabay.com/photo/2017/08/02/01/01/movie-theater-2565549_1280.jpg"
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
                "https://cdn.pixabay.com/photo/2016/11/29/09/32/alps-1866830_1280.jpg"
        ));

        // Activité 7 : Soirée raclette/fondue (Neige)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Soirée raclette/fondue",
                "Restaurant Savoyard",
                25.0,
                "Ambiance chaleureuse après une journée froide.",
                false,
                "Snow",
                "https://cdn.pixabay.com/photo/2015/02/02/11/08/winter-621882_1280.jpg"
        ));

        // Activité 8 : Musée du Film d'Animation (Vent)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Musée du Film d'Animation",
                "Annecy centre",
                5.0,
                "Découvrez l'histoire du cinéma d'animation français.",
                false,
                "Wind",
                "https://cdn.pixabay.com/photo/2016/11/21/15/45/museum-1844707_1280.jpg"
        ));

        // Activité 9 : Visite de la vieille ville (Brouillard)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Visite de la vieille ville",
                "Annecy",
                0.0,
                "Explorez les ruelles pittoresques sous le brouillard.",
                true,
                "Fog",
                "https://cdn.pixabay.com/photo/2016/10/29/09/08/clouds-1774739_1280.jpg"
        ));

        // Activité 10 : Balade dans la vieille ville (Nuageux)
        activities.add(new Activity(
                UUID.randomUUID().toString(),
                "Balade dans la vieille ville",
                "Annecy centre",
                0.0,
                "Une promenade agréable quelle que soit la météo.",
                true,
                "Clouds",
                "https://cdn.pixabay.com/photo/2017/03/28/12/16/annecy-2188639_1280.jpg"
        ));

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
