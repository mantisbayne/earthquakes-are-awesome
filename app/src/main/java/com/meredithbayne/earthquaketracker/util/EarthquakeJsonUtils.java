package com.meredithbayne.earthquaketracker.util;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    public static String[] getEarthquakeStrings(Context context, String earthquakeJsonString) throws JSONException {

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

        String[] parsedEarthquakeData = null;

        JSONObject earthquakeJson = new JSONObject(earthquakeJsonString);

        JSONArray earthquakeArray = earthquakeJson.getJSONArray(GN_EARTHQUAKES);
        parsedEarthquakeData = new String[earthquakeArray.length()];

        for (int i = 0; i < earthquakeArray.length(); i++) {
            String datetime;
            String longitude;
            String latitude;
            String magnitude;

            // Individual earthquake event
            JSONObject earthquake = earthquakeArray.getJSONObject(i);
            // Date
            datetime = earthquake.getString(GN_DATE);
            String date = EarthquakeDateUtil.getFriendlyDateTimeFormat(datetime);
            // Longitude
            longitude = earthquake.getString(GN_LONGITUDE);
            // Latitude
            latitude = earthquake.getString(GN_LATITUDE);
            // Magnitude
            magnitude = earthquake.getString(GN_MAGNITUDE);

            parsedEarthquakeData[i] = "Magnitude : " + magnitude + "\n" + "Coordinates : " + latitude + " / " + longitude + "\n" + "Date : " + date;
        }

        return parsedEarthquakeData;
    }
}
