package com.example.annecyactivity.ui.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.annecyactivity.R;
import com.example.annecyactivity.data.model.Activity;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder> {
    private final List<Activity> activities;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Activity activity);
    }

    public ActivityAdapter(List<Activity> activities, OnItemClickListener listener) {
        this.activities = activities;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_activity, parent, false);
        return new ActivityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        Activity activity = activities.get(position);
        holder.name.setText(activity.getName());
        holder.location.setText(activity.getLocation());
        Glide.with(holder.itemView.getContext())
                .load(activity.getImageUrl())
                .placeholder(android.R.drawable.ic_menu_gallery) // affiché pendant le chargement
                .error(android.R.drawable.ic_menu_report_image)  // affiché en cas d’erreur
                .centerCrop()
                .into(holder.image);
        holder.detailButton.setOnClickListener(v -> listener.onItemClick(activity));
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    public static class ActivityViewHolder extends RecyclerView.ViewHolder {
        TextView name, location;
        ImageView image;
        Button detailButton;

        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textActivityName);
            location = itemView.findViewById(R.id.textLocation);
            image = itemView.findViewById(R.id.imageActivity);
            detailButton = itemView.findViewById(R.id.btnDetail);
        }
    }
}
