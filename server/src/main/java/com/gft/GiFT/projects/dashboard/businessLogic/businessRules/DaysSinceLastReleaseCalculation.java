package com.gft.GiFT.projects.dashboard.businessLogic.businessRules;

import com.gft.GiFT.common.businessLogic.DateFormatter;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class DaysSinceLastReleaseCalculation {

    public static String determineDays(Date firstCycleStartDate, String cycleSnapEndDate, List<String> releaseDates) throws ParseException {

        TreeSet<Date> treeAdd = new TreeSet<>();
        for (String releaseDate : releaseDates) {
            Date newReleaseDate = DateFormatter.convertDateStringToDate(releaseDate);
            treeAdd.add(newReleaseDate);
        }

        Date cycleSnapDate = DateFormatter.convertDateStringToDate(cycleSnapEndDate);
        Date releaseToCompare = treeAdd.floor(cycleSnapDate);

        DateTime dateToCompare;
        if (releaseToCompare == null) {
            dateToCompare = new DateTime(firstCycleStartDate);
        } else {
            dateToCompare = new DateTime(releaseToCompare);
        }

        int days = Days.daysBetween(dateToCompare, new DateTime(cycleSnapDate)).getDays();

        return "" + days;
    }
}