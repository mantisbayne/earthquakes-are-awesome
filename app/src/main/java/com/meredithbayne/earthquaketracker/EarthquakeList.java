package com.meredithbayne.earthquaketracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by meredithbayne on 10/23/17
 * Implementation of the list that will contain Earthquakes
 */

public class EarthquakeList {

    @SerializedName("earthquakes")
    @Expose
    private List<Earthquake> earthquakes = null;

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }

}