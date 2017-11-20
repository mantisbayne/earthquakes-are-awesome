package com.meredithbayne.earthquaketracker.util;

import com.meredithbayne.earthquaketracker.datamodel.Earthquake;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbayne on 11/3/17.
 */

public final class EarthquakeJsonUtils {

    /**
     * Parses the data from the JSON response
     * @param earthquakeJsonString JSON response from earthquake server
     *
     * @return Array of strings with the earthquake data to display to the user
     *
     * @throws JSONException if parsing error occurs
     */
    public static List<Earthquake> getEarthquakeStrings(String earthquakeJsonString) throws JSONException {
        List<Earthquake> earthquakeList = new ArrayList<>();

        // Earthquake data is in the 'earthquakes' array
        final String GN_EARTHQUAKES = "earthquakes";
        // Date
        final String GN_DATE = "datetime";
        // Longitude
        final String GN_LONGITUDE = "lng";
        // Latitude
        final String GN_LATITUDE = "lat";
        // Magnitude
        final String GN_MAGNITUDE = "magnitude";

        JSONObject earthquakeJson = new JSONObject(earthquakeJsonString);

        JSONArray earthquakeArray = earthquakeJson.getJSONArray(GN_EARTHQUAKES);

        for (int i = 0; i < earthquakeArray.length(); i++) {
            String datetime;
            String longitude;
            String latitude;
            String magnitude;

            // Individual earthquake event
            JSONObject earthquake = earthquakeArray.getJSONObject(i);
            // Date
            datetime = earthquake.getString(GN_DATE);
            String date = EarthquakeFormatUtils.getFriendlyDateTimeFormat(datetime);
            // Longitude
            longitude = earthquake.getString(GN_LONGITUDE);
            String lng = EarthquakeFormatUtils.formatDecimalPlace(longitude);
            // Latitude
            latitude = earthquake.getString(GN_LATITUDE);
            String lat = EarthquakeFormatUtils.formatDecimalPlace(latitude);
            // Magnitude
            magnitude = earthquake.getString(GN_MAGNITUDE);

            // For each earthquake json object in the earthquakes json, add an Earthquake object
            earthquakeList.add(new Earthquake(date, lng, magnitude, lat));
        }

        return earthquakeList;
    }
}
