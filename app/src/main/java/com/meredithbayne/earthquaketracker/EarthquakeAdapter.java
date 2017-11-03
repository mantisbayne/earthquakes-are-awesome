package com.meredithbayne.earthquaketracker;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

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
        holder.mEarthquakeTextView.setText(earthquakeEvent);
    }

    @Override
    public int getItemCount() {
        if (mEarthquakeData == null) {
            return 0;
        }

        return mEarthquakeData.length;
    }

    public class EarthquakeAdapterViewHolder extends RecyclerView.ViewHolder {
        private final TextView mEarthquakeTextView;

        public EarthquakeAdapterViewHolder(View itemView) {
            super(itemView);
            mEarthquakeTextView = (TextView) itemView.findViewById(R.id.tv_earthquake_data);
        }
    }

    public void setEarthquakeData(String[] earthquakeData) {
        mEarthquakeData = earthquakeData;
        notifyDataSetChanged();
    }
}
