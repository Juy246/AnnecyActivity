package com.example.annecyactivity.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.annecyactivity.R;

import com.example.annecyactivity.data.model.Forecast;
import com.example.annecyactivity.data.model.Weather;
import com.example.annecyactivity.viewmodel.ForecastsViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class CurrentWeatherFragment extends Fragment {
    private ForecastsViewModel viewModel;
    private TextView temp, feels_like, humidity, pressure, airQuality;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);

        temp = view.findViewById(R.id.textTemp);
        feels_like = view.findViewById(R.id.textFeelsLike);
        humidity = view.findViewById(R.id.textHumidity);
        pressure = view.findViewById(R.id.textPressure);
        airQuality = view.findViewById(R.id.textAirQuality);

        Button btnActivities = view.findViewById(R.id.btnActivities);
        Button btnChooseWeather = view.findViewById(R.id.btnChooseWeather);

        btnActivities.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_currentWeatherFragment_to_activityListFragment));

        btnChooseWeather.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_currentWeatherFragment_to_formFragment));

        viewModel = new ViewModelProvider(this).get(ForecastsViewModel.class);
        viewModel.getForecast()
                .observe(getViewLifecycleOwner(), this::updateWeatherUI);
        viewModel.fetchForecast("Annecy", "44e0343a7e7081c5df0a4b5f913f3c19", "metric");

        return view;
    }

    private void updateWeatherUI(Forecast forecast) {
        // Cette méthode est appelée automatiquement quand le LiveData change.
        if (forecast != null && forecast.getMain() != null) {
            Weather weather = forecast.getMain();
            temp.setText(weather.getTemp() + " °C");
            feels_like.setText("Ressenti : " + weather.getFeelsLike() + " °C");
            humidity.setText("Humidité : " + weather.getHumidity() + "%");
            pressure.setText("Pression : N/A"); // Pression non disponible dans votre modèle
        } else {
            // Gérer le cas où les données sont nulles (erreur réseau ou API)
            temp.setText("N/A");
            feels_like.setText("Données non disponibles");
            humidity.setText("Humidité : N/A");
            pressure.setText("Pression : N/A");
        }
    }
}
