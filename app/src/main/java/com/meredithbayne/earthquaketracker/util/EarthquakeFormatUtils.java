package com.meredithbayne.earthquaketracker.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mbayne on 11/3/17.
 */

public class EarthquakeFormatUtils {
    public static String getFriendlyDateTimeFormat(String datetime) {
        DateFormat startDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");

        Date startDate;

        String userDateString = null;

        try {
            startDate = startDateFormat.parse(datetime);
            userDateString = dateFormat.format(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return userDateString;
    }

    public static String formatDecimalPlace(String value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(Float.parseFloat(value));
    }
}
