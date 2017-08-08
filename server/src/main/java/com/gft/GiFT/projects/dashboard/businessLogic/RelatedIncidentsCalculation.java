package com.gft.GiFT.projects.dashboard.businessLogic;

import com.gft.GiFT.formatters.DateFormatter;
import com.gft.GiFT.projects.dashboard.dataAccess.IncidentsReport;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class RelatedIncidentsCalculation {

    public static String determineRelatedIncidents(List<IncidentsReport> incidentReports,
                                                   String cycleSnapEndDate,
                                                   List<String> releaseDates) throws ParseException {

        return "No incident reports available";

//        Date cycleSnapDate = DateFormatter.convertDateStringToDate(cycleSnapEndDate);
//
//        LinkedList link = new LinkedList();
//        for( incidentsReport : incidentsDate) {
//            link.add(incidentsReport) ;
//        }
//
//        TreeSet<Date> treeAdd = new TreeSet<>();
//
//        for (String releaseDate : releaseDates) {
//            Date newReleaseDate = DateFormatter.convertDateStringToDate(releaseDate);
//            treeAdd.add(newReleaseDate);
//        }
//        Date releaseToCompare = treeAdd.floor(cycleSnapDate);
//
//        if (releaseToCompare == null) {
//            return "No releases yet";
//        } else {
//            return incidentsReport;
//        }
    }
}

