package com.example.annecyactivity.data.repository;

import com.example.annecyactivity.data.model.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ActivityRepository {

    public List<Activity> getAllActivities(String weatherCondition) {
        List<Activity> activities = new ArrayList<>();

        // Normalisation du texte météo
        String weather = weatherCondition.toLowerCase();

        switch (weather) {
            case "clear":
            case "sun":
            case "sunny":
                activities.add(new Activity(UUID.randomUUID().toString(),
                        "Randonnée en montagne",
                        "Semnoz, Annecy",
                        0.0,
                        "Profitez du soleil pour une belle randonnée avec vue sur le lac.",
                        true,
                        "Clear",
                        "https://cdn.pixabay.com/photo/2016/11/29/13/02/adventure-1868817_1280.jpg"));

                activities.add(new Activity(UUID.randomUUID().toString(),
                        "Balade autour du lac d’Annecy",
                        "Lac d’Annecy",
                        0.0,
                        "Idéal pour marcher ou faire du vélo en bord de lac.",
                        true,
                        "Clear",
                        "https://cdn.pixabay.com/photo/2016/06/29/09/20/annecy-1487297_1280.jpg"));

                activities.add(new Activity(UUID.randomUUID().toString(),
                        "Pique-nique au parc Charles Bosson",
                        "Annecy centre",
                        0.0,
                        "Détente en plein air avec une belle vue sur le lac.",
                        true,
                        "Clear",
                        "https://cdn.pixabay.com/photo/2017/06/17/18/31/picnic-2414007_1280.jpg"));
                break;

            case "rain":
            case "drizzle":
                activities.add(new Activity(UUID.randomUUID().toString(),
                        "Visite du musée Château d’Annecy",
                        "Vieille ville",
                        8.0,
                        "Musée d’art et d’histoire dans un château médiéval.",
                        false,
                        "Rain",
                        "https://cdn.pixabay.com/photo/2015/05/15/14/47/castle-768611_1280.jpg"));

                activities.add(new Activity(UUID.randomUUID().toString(),
                        "Cinéma Pathé",
                        "Centre commercial Courier",
                        12.0,
                        "Regardez des films dans le cinéma.",
                        false,
                        "Rain",
                        "https://cdn.pixabay.com/photo/2017/08/02/01/01/movie-theater-2565549_1280.jpg"));
                break;

            case "snow":
                activities.add(new Activity(UUID.randomUUID().toString(),
                        "Ski à La Clusaz",
                        "Station La Clusaz",
                        35.0,
                        "Journée de ski à 30 minutes d’Annecy.",
                        true,
                        "Snow",
                        "https://cdn.pixabay.com/photo/2016/11/29/09/32/alps-1866830_1280.jpg"));

                activities.add(new Activity(UUID.randomUUID().toString(),
                        "Soirée raclette/fondue",
                        "Restaurant Savoyard",
                        25.0,
                        "Ambiance chaleureuse après une journée froide.",
                        false,
                        "Snow",
                        "https://cdn.pixabay.com/photo/2015/02/02/11/08/winter-621882_1280.jpg"));
                break;

            case "wind":
            case "windy":
                activities.add(new Activity(UUID.randomUUID().toString(),
                        "Musée du Film d’Animation",
                        "Annecy centre",
                        5.0,
                        "Découvrez l’histoire du cinéma d’animation français.",
                        false,
                        "Wind",
                        "https://cdn.pixabay.com/photo/2016/11/21/15/45/museum-1844707_1280.jpg"));
                break;

            case "fog":
            case "mist":
            case "haze":
                activities.add(new Activity(UUID.randomUUID().toString(),
                        "Visite de la vieille ville",
                        "Annecy",
                        0.0,
                        "Explorez les ruelles pittoresques sous le brouillard.",
                        true,
                        "Fog",
                        "https://cdn.pixabay.com/photo/2016/10/29/09/08/clouds-1774739_1280.jpg"));
                break;

            default:
                // Si la météo ne correspond à rien, proposer une activité neutre
                activities.add(new Activity(UUID.randomUUID().toString(),
                        "Balade dans la vieille ville",
                        "Annecy centre",
                        0.0,
                        "Une promenade agréable quelle que soit la météo.",
                        true,
                        "Default",
                        "https://cdn.pixabay.com/photo/2017/03/28/12/16/annecy-2188639_1280.jpg"));
                break;
        }

        return activities;
    }
}
