package com.example.annecyactivity.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annecyactivity.R;
import com.example.annecyactivity.viewmodel.ActivityViewModel;

import java.util.ArrayList;

public class ActivityFormFragment extends Fragment {
    private ActivityViewModel viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_form, container, false);

        Spinner spinnerWeather = view.findViewById(R.id.spinnerWeather);
        EditText inputTemp = view.findViewById(R.id.inputTemp);
        Switch switchOutside = view.findViewById(R.id.switchOutside);
        Button btnValidate = view.findViewById(R.id.btnValidate);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerFilteredActivities);

        ArrayList<String> weatherCondition = new ArrayList<>();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, weatherCondition);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWeather.setAdapter(spinnerAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        viewModel = new ViewModelProvider(this).get(ActivityViewModel.class);

        btnValidate.setOnClickListener(v -> {
            String weather = spinnerWeather.getSelectedItem().toString();
            double temp = Double.parseDouble(inputTemp.getText().toString());
            boolean isOutside = switchOutside.isChecked();

            viewModel.filterActivities(weather, temp, isOutside);
        });

        viewModel.getActivities().observe(getViewLifecycleOwner(), activities -> {
            ActivityAdapter adapterList = new ActivityAdapter(activities, activity -> {});
            recyclerView.setAdapter(adapterList);
        });

        return view;
    }
}
