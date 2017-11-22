package com.meredithbayne.earthquaketracker;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.meredithbayne.earthquaketracker.data.Earthquake;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of adapter that will load the earthquake data into the RecyclerView
 */

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeAdapterViewHolder> {

    private List<Earthquake> mEarthquakeData = Collections.emptyList();
    private static final SimpleDateFormat DISPLAY_DATE_FORMAT = new SimpleDateFormat("MM/dd/yy");
    private static final DecimalFormat DISPLAY_DECIMAL_FORMAT = new DecimalFormat("#.00");

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
        String magnitude = Float.toString(earthquake.getMagnitude());

        // Severity icon
        holder.mEarthquakeImageView.setImageResource(R.drawable.ic_error_black_24dp);

        // Date, Magnitude, Longitude, and Latitude text views
        holder.mEarthquakeImageView.setVisibility(View.INVISIBLE);
        holder.mDateTextView.setText(earthquake.formatDate(DISPLAY_DATE_FORMAT));
        holder.mMagnitudeTextView.setText(magnitude);
        holder.mLongitudeTextView.setText(earthquake.formatDecimal(DISPLAY_DECIMAL_FORMAT, earthquake.getLng()));
        holder.mLatitudeTextView.setText(earthquake.formatDecimal(DISPLAY_DECIMAL_FORMAT, earthquake.getLat()));

        if (mEarthquakeData.get(position).getMagnitude() >= 8.0) {
            holder.mMagnitudeTextView.setTextColor(Color.RED);
            holder.mEarthquakeImageView.setVisibility(View.VISIBLE);
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
