package com.gft.GiFT.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     *
     * @param date
     *
     * @return a date without time in String format
     */
    public static final String getDateFormatterToString(Date date) {
        DateFormat dateFormat  = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }
}