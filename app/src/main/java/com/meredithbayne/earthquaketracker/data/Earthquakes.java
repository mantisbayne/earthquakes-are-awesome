package com.meredithbayne.earthquaketracker.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by meredithbayne on 11/22/17.
 */

public class Earthquakes {
    @SerializedName("earthquakes")
    @Expose
    private ArrayList<Earthquake> earthquakes = null;

    public ArrayList<Earthquake> getEarthquakes() {
        return earthquakes;
    }
}
