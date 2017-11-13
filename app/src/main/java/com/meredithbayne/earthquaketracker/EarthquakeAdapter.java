package com.meredithbayne.earthquaketracker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by meredithbayne on 10/22/17
 * Implementation of adapter that will load the earthquake data into the RecyclerView
 * TODO add comments
 */

public class EarthquakeAdapter extends RecyclerView.Adapter<EarthquakeAdapter.EarthquakeAdapterViewHolder> {

    private String[] mEarthquakeData;

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
        String earthquakeEvent = mEarthquakeData[position];

        // Severity icon
        holder.mEarthquakeImageView.setImageResource(R.drawable.ic_error_black_24dp);

        // @TODO Replace with single views
    }

    @Override
    public int getItemCount() {
        if (mEarthquakeData == null) {
            return 0;
        }

        return mEarthquakeData.length;
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

    public void setEarthquakeData(String[] earthquakeData) {
        mEarthquakeData = earthquakeData;
        notifyDataSetChanged();
    }
}
