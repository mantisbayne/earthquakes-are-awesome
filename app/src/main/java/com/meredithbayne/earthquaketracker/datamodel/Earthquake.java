package com.meredithbayne.earthquaketracker.datamodel;

/**
 * Created by mbayne on 11/20/17.
 */

public class Earthquake {
    private String datetime;
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
    public Earthquake(String datetime, float lng, float magnitude, float lat) {
        super();
        this.datetime = datetime;
        this.lng = lng;
        this.magnitude = magnitude;
        this.lat = lat;
    }

    /**
     *
     * @param magnitude Magnitude of the earthquake
     * @param lng Longitude for location of the earthquake
     * @param datetime Date ad time of the earthquake
     * @param lat Latitude for location of the earthquake
     */
    public Earthquake(String datetime, String lng, String magnitude, String lat) {
        super();
        this.datetime = datetime;
        this.lng = Float.parseFloat(lng);
        this.magnitude = Float.parseFloat(magnitude);
        this.lat = Float.parseFloat(lat);
    }

    public String getDatetime() {
        return datetime;
    }

    public float getLng() {
        return lng;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public float getLat() {
        return lat;
    }
}

