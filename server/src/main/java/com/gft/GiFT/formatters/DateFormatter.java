package com.gft.GiFT.formatters;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";

    /**
     * @param date
     * @return a date without time in String format
     */
    public static final String convertDateToString(Date date) {
        DateFormat dateFormat  = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }

    /**
     *
     * @param date
     * @return a date time in String format
     */
    public static final String convertDateTimeToString(Date date) {
        DateFormat dateFormat  = new SimpleDateFormat(DATE_TIME_FORMAT);
        return dateFormat.format(date);
    }
}