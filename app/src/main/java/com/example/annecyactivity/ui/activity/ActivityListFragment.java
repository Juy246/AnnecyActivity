package com.example.annecyactivity.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annecyactivity.R;
import com.example.annecyactivity.data.model.Activity;
import com.example.annecyactivity.viewmodel.ActivityViewModel;

public class ActivityListFragment extends Fragment {
    private ActivityViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerActivities);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(ActivityViewModel.class);
        viewModel.loadActivities();

        viewModel.getActivities().observe(getViewLifecycleOwner(), activities -> {
            ActivityAdapter adapter = new ActivityAdapter(activities, activity -> {
                Bundle bundle = new Bundle();
                bundle.putString("name", activity.getName());
                bundle.putString("location", activity.getLocation());
                bundle.putDouble("price", activity.getPrice());
                bundle.putString("description", activity.getDescription());
                bundle.putBoolean("isOutside", activity.isOutside());
                bundle.putString("weather", activity.getSuggestedWeather());
                bundle.putString("image", activity.getImageUrl());
                Navigation.findNavController(view)
                        .navigate(R.id.action_activityListFragment_to_activityDetailFragment, bundle);
            });
            recyclerView.setAdapter(adapter);
        });

        return view;
    }
}
