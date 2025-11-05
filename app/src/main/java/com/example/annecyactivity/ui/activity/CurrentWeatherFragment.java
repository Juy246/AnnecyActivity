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
import com.example.annecyactivity.data.model.AirQuality;
import com.example.annecyactivity.data.model.Weather;
import com.example.annecyactivity.viewmodel.ForecastViewModel;

public class CurrentWeatherFragment extends Fragment {
    private ForecastViewModel viewModel;
    private TextView tempText, feelsText, humidityText, pressureText, airQualityText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);

        tempText = view.findViewById(R.id.textTemp);
        feelsText = view.findViewById(R.id.textFeelsLike);
        humidityText = view.findViewById(R.id.textHumidity);
        pressureText = view.findViewById(R.id.textPressure);
        airQualityText = view.findViewById(R.id.textAirQuality);

        Button btnActivities = view.findViewById(R.id.btnActivities);
        Button btnChooseWeather = view.findViewById(R.id.btnChooseWeather);

        btnActivities.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_currentWeatherFragment_to_activityListFragment));

        btnChooseWeather.setOnClickListener(v -> Navigation.findNavController(v)
                .navigate(R.id.action_currentWeatherFragment_to_formFragment));

        viewModel = new ViewModelProvider(this).get(ForecastViewModel.class);
        viewModel.loadWeather("Annecy");

        viewModel.getWeather().observe(getViewLifecycleOwner(), this::updateWeatherUI);
        viewModel.getAirQuality().observe(getViewLifecycleOwner(), this::updateAirQualityUI);

        return view;
    }

    private void updateWeatherUI(Weather weather) {
        tempText.setText(weather.main.temp + " °C");
        feelsText.setText("Ressenti : " + weather.main.feels_like + " °C");
        humidityText.setText("Humidité : " + weather.main.humidity + "%");
        pressureText.setText("Pression : " + weather.main.pressure + " hPa");
    }

    private void updateAirQualityUI(AirQuality airQuality) {
        int aqi = airQuality.list.get(0).main.aqi;
        airQualityText.setText("Qualité de l’air : " + aqi);
    }
}
