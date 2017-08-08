package com.gft.GiFT.projects.dashboard;

import com.gft.GiFT.formatters.DateFormatter;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class RelatedIncidentsCalculation {

    public static String determineRelatedIncidents(List<String> incidentsDate, String cycleSnapEndDate, List<String> releaseDates) throws ParseException {
        Date cycleSnapDate = DateFormatter.convertDateStringToDate(cycleSnapEndDate);
        int numberofIncidents = 0;
        String incidentsReport= "";
//        for (int i = 0; i < incidentsReports.size(); i++) {
//            IncidentsReport incidentsReport;
//            incidentsReport = incidentsReports.get(i);
//        }
        LinkedList link = new LinkedList();
        for( incidentsReport : incidentsDate) {
            link.add(incidentsReport) ;
        }

        TreeSet<Date> treeAdd = new TreeSet<>();

        for (String releaseDate : releaseDates) {
            Date newReleaseDate = DateFormatter.convertDateStringToDate(releaseDate);
            treeAdd.add(newReleaseDate);
        }
        Date releaseToCompare = treeAdd.floor(cycleSnapDate);

        if (releaseToCompare == null) {
            return "No releases yet";
        } else {
            return incidentsReport;
        }
    }
}

