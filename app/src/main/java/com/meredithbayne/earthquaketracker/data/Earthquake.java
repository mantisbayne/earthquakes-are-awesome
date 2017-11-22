package com.meredithbayne.earthquaketracker.data;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Created by mbayne on 11/20/17.
 */

public class Earthquake {
    private Date datetime;
    private float lng;
    private float magnitude;
    private float lat;

    /**
     *
     * @param magnitude Magnitude of the earthquake
     * @param lng Longitude for location of the earthquake
     * @param datetime Date ad time of the earthquake
     * @param lat Latitude for location of the earthquake
     */
    public Earthquake(Date datetime, float lng, float magnitude, float lat) {
        super();
        this.datetime = datetime;
        this.lng = lng;
        this.magnitude = magnitude;
        this.lat = lat;
    }

    public Date getDatetime() {
        return datetime;
    }

    public String formatDate(DateFormat dateFormat) {
        return dateFormat.format(datetime);
    }

    public float getLng() {
        return lng;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public String formatDecimal(DecimalFormat decimalFormat, float value) {
        return decimalFormat.format(value);
    }

    public float getLat() {
        return lat;
    }
}

