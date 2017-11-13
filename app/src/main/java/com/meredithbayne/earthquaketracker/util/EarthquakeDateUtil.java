package com.meredithbayne.earthquaketracker.util;

/**
 * Created by mbayne on 11/13/17.
 */

public class EarthquakeDateUtil {
    public static String getFriendlyDateTimeFormat(String datetime) {
        String userDatetime;

        String month = datetime.substring(5, 7);
        String day = datetime.substring(8, 10);
        String year = datetime.substring(0, 4);

        userDatetime = month + "/" + day + "/" + year;

        return userDatetime;
    }
}
