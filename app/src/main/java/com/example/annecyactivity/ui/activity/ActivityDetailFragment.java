package com.example.annecyactivity.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.annecyactivity.R;

public class ActivityDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_detail, container, false);

        Bundle args = getArguments();
        if (args != null) {
            ((TextView) view.findViewById(R.id.textDetailName)).setText(args.getString("name"));
            ((TextView) view.findViewById(R.id.textDetailLocation)).setText(args.getString("location"));
            ((TextView) view.findViewById(R.id.textDetailPrice)).setText(args.getDouble("price") + " €");
            ((TextView) view.findViewById(R.id.textDetailDescription)).setText(args.getString("description"));
            ((TextView) view.findViewById(R.id.textDetailWeather)).setText("Météo suggérée : " + args.getString("weather"));
            ((TextView) view.findViewById(R.id.textDetailOutside)).setText(args.getBoolean("isOutside") ? "Extérieur" : "Intérieur");

            ImageView imageView = view.findViewById(R.id.imageDetail);
            int imageRes = args.getInt("imageRes", 0);
            String activityImageUrl = args.getString("imageUrl");

            if (imageRes != 0) {
                Glide.with(this)
                        .load(imageRes)
                        .placeholder(android.R.drawable.ic_menu_gallery)
                        .error(android.R.drawable.ic_menu_report_image)
                        .centerCrop()
                        .into(imageView);
            } else if (activityImageUrl != null && !activityImageUrl.isEmpty()) {
                Glide.with(this)
                        .load(activityImageUrl)
                        .placeholder(android.R.drawable.ic_menu_gallery)
                        .error(android.R.drawable.ic_menu_report_image)
                        .centerCrop()
                        .into(imageView);
            } else {
                imageView.setImageResource(android.R.drawable.ic_menu_report_image);
            }
        }
        return view;
    }
}
