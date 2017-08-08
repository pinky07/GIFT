package com.gft.GiFT.projects.dashboard.businessLogic;

import com.gft.GiFT.formatters.DateFormatter;
import com.gft.GiFT.projects.dashboard.dataAccess.IncidentsReport;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class RelatedIncidentsCalculation {

    public static String determineRelatedIncidents(List<IncidentsReport> incidentReports,
                                                   String cycleSnapEndDateAsText,
                                                   List<String> releaseDates) throws ParseException {
//        1. Get the release date that is more recent in the past

        Date cycleSnapDate = DateFormatter.convertDateStringToDate(cycleSnapEndDateAsText);
        TreeSet<Date> treeAdd = new TreeSet<>();

        for (String releaseDate : releaseDates) {
            Date newReleaseDate = DateFormatter.convertDateStringToDate(releaseDate);
            treeAdd.add(newReleaseDate);
        }
        Date releaseToCompare = treeAdd.floor(cycleSnapDate);

        if (releaseToCompare == null)
            return "No releases yet";
        else {

            List<IncidentsReport> foundReports = new LinkedList();
//              2. Get the incident reports between release date and cycleSnap End date
            for (IncidentsReport report: incidentReports) {
                String dateAsText = report.getIncidentsDate();
                Date reportDate = DateFormatter.convertDateStringToDate(dateAsText);

                if (!reportDate.after(cycleSnapDate) && !reportDate.before(releaseToCompare))
                    foundReports.add(report);
            }

            if (foundReports.isEmpty())
                return "No reports available";
            else
            {
                int total = 0;
                for (IncidentsReport report: foundReports) {
                    total+=report.getTotalIncidents();
                }
//
                return String.valueOf(total);
        }
        }
    }
}

