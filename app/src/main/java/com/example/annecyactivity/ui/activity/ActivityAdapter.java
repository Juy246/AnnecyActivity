package com.example.annecyactivity.ui.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.annecyactivity.R;
import com.example.annecyactivity.data.model.Activity;
import java.util.List;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private final List<Activity> items;
    private final OnItemClickListener listener;
    private int selectedPosition = RecyclerView.NO_POSITION;

    public ActivitiesAdapter(List<Activity> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ActivitiesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ActivitiesAdapter.ViewHolder holder, int position) {
        Activity a = items.get(position);
        holder.name.setText(a.getName());
        holder.location.setText(a.getLocation());
        holder.price.setText(String.format("%.2f€", a.getPrice()));
        holder.itemView.setSelected(position == selectedPosition);
        holder.itemView.setOnClickListener(v -> {
            int old = selectedPosition;
            selectedPosition = position;
            notifyItemChanged(old);
            notifyItemChanged(selectedPosition);
            if (listener != null) listener.onItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public Activity getSelected() {
        if (selectedPosition == RecyclerView.NO_POSITION) return null;
        return items.get(selectedPosition);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final TextView location;
        final TextView price;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvActivityName);
            location = itemView.findViewById(R.id.tvActivityLocation);
            price = itemView.findViewById(R.id.tvActivityPrice);
        }
    }
}
