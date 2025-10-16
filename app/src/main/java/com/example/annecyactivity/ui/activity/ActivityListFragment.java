package com.example.annecyactivity.ui.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.annecyactivity.R;
import com.example.annecyactivity.data.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class ActivityListFragment extends Fragment implements ActivityAdapter.OnItemClickListener {

    public interface OnActivitySelectedListener {
        void onActivitySelected(Activity activity);
    }

    private OnActivitySelectedListener listener;
    private RecyclerView recyclerView;
    private ActivityAdapter adapter;
    private final List<Activity> activities = new ArrayList<>();

    public static ActivityListFragment newInstance() {
        return new ActivityListFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnActivitySelectedListener) {
            listener = (OnActivitySelectedListener) context;
        } else {
            // parent activity/fragment should implement listener if it needs selection callbacks
            listener = null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_activity_list, container, false);
        recyclerView = root.findViewById(R.id.recyclerActivities);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new ActivityAdapter(activities, this);
        recyclerView.setAdapter(adapter);
        return root;
    }

    // Appeler depuis l'Activity / ViewModel après création du fragment
    public void setActivities(List<Activity> list) {
        activities.clear();
        if (list != null) activities.addAll(list);
        if (adapter != null) adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        Activity selected = activities.get(position);
        if (listener != null) listener.onActivitySelected(selected);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
