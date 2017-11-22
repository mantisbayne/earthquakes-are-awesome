package com.meredithbayne.earthquaketracker.data;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Utilities to manage networking
 */

public class API {

    private static final String TAG = API.class.getSimpleName();

    private static final String EARTHQUAKE_BASE_URL =
            "http://api.geonames.org/earthquakesJSON";

    // Query params
    private static final String FORMATTED_PARAM = "formatted";
    private static final String NORTH_PARAM = "north";
    private static final String SOUTH_PARAM = "south";
    private static final String EAST_PARAM = "east";
    private static final String WEST_PARAM = "west";
    private static final String USERNAME_PARAM = "username";

    // Query param values
    private static final String formatted = "true";
    private static final String north = "44.1";
    private static final String south = "-9.9";
    private static final String east = "-22.4";
    private static final String west = "55.2";
    private static final String username = "mkoppelman";

    /**
     * Builds the URL used to get the Earthquake data
     * @return earthquakeUrl - the URL to query the earthquakes server
     */
    public static URL buildURl() {
        Uri earthquakeUri = Uri.parse(EARTHQUAKE_BASE_URL).buildUpon()
                .appendQueryParameter(FORMATTED_PARAM, formatted)
                .appendQueryParameter(NORTH_PARAM, north)
                .appendQueryParameter(SOUTH_PARAM, south)
                .appendQueryParameter(EAST_PARAM, east)
                .appendQueryParameter(WEST_PARAM, west)
                .appendQueryParameter(USERNAME_PARAM, username)
                .build();
        URL earthquakeUrl = null;
        try {
            earthquakeUrl = new URL(earthquakeUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + earthquakeUrl);

        return earthquakeUrl;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
