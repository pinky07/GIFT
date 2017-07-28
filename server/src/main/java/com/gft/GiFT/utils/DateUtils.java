package com.gft.GiFT.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";

    /**
     * @param date
     * @return a date without time in String format
     */
    public static final String getDateFormatterToString(Date date) {
        DateFormat dateFormat  = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }

    /**
     *
     * @param date
     * @return a date time in String format
     */
    public static final String getDateTimeFormatterToString(Date date) {
        DateFormat dateFormat  = new SimpleDateFormat(DATE_TIME_FORMAT);
        return dateFormat.format(date);
    }
}