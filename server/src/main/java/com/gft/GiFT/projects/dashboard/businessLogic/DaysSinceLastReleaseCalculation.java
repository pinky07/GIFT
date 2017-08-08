package com.gft.GiFT.projects.dashboard.businessLogic;

import com.gft.GiFT.formatters.DateFormatter;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class DaysSinceLastReleaseCalculation {

    public static String determineDays(String cycleSnapEndDate, List<String> releaseDates) throws ParseException {
        Date cycleSnapDate = DateFormatter.convertDateStringToDate(cycleSnapEndDate);

        TreeSet<Date> treeAdd = new TreeSet<>();

        for (String releaseDate : releaseDates) {
            Date newReleaseDate = DateFormatter.convertDateStringToDate(releaseDate);
            treeAdd.add(newReleaseDate);
        }
        Date releaseToCompare = treeAdd.floor(cycleSnapDate);

        if (releaseToCompare == null) {
            return "No releases yet";
        } else {
            return "" + Days.daysBetween(new DateTime(releaseToCompare), new DateTime(cycleSnapDate)).getDays();
        }
    }
}