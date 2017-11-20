package com.meredithbayne.earthquaketracker;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meredithbayne.earthquaketracker.datamodel.Earthquake;

import java.util.Collections;
import java.util.List;

/**
 * Created by meredithbayne on 10/22/17
 * Implementation of adapter that will load the earthquake data into the RecyclerView
 * TODO add comments
 */

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeAdapterViewHolder> {

    private List<Earthquake> mEarthquakeData = Collections.emptyList();

    @Override
    public EarthquakeAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layout = R.layout.earthquake_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layout, viewGroup, false);
        return new EarthquakeAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EarthquakeAdapterViewHolder holder, int position) {
        Earthquake earthquake = mEarthquakeData.get(position);

        // Severity icon
        holder.mEarthquakeImageView.setImageResource(R.drawable.ic_error_black_24dp);

        // Date, Magnitude, Longitude, and Latitude text views
        holder.mDateTextView.setText(earthquake.getDatetime());
        holder.mMagnitudeTextView.setText(Float.toString(earthquake.getMagnitude()));
        holder.mLongitudeTextView.setText(Float.toString(earthquake.getLng()));
        holder.mLatitudeTextView.setText(Float.toString(earthquake.getLat()));

        if (mEarthquakeData.get(position).getMagnitude() >= 8.0) {
            holder.mMagnitudeTextView.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        if (mEarthquakeData == null) {
            return 0;
        }

        return mEarthquakeData.size();
    }

    public class EarthquakeAdapterViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mEarthquakeImageView;
        private final TextView mMagnitudeTextView;
        private final TextView mLatitudeTextView;
        private final TextView mLongitudeTextView;
        private final TextView mDateTextView;

        public EarthquakeAdapterViewHolder(View itemView) {
            super(itemView);

            mEarthquakeImageView = (ImageView) itemView.findViewById(R.id.severity_icon);
            mMagnitudeTextView = (TextView) itemView.findViewById(R.id.earthquake_magnitude);
            mLatitudeTextView = (TextView) itemView.findViewById(R.id.latitude);
            mLongitudeTextView = (TextView) itemView.findViewById(R.id.longitude);
            mDateTextView = (TextView) itemView.findViewById(R.id.date);
        }
    }

    public void setEarthquakeData(List<Earthquake> earthquakeData) {
        mEarthquakeData = earthquakeData;
        notifyDataSetChanged();
    }
}
