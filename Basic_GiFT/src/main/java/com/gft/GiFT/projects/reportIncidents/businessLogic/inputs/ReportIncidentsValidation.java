package com.gft.GiFT.projects.reportIncidents.businessLogic.inputs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ReportIncidentsValidation {
    public static void Validation(IncidentsReport incidentsReport) {
        Integer totalIncidents = incidentsReport.getTotalIncidents();
        if (incidentsReport.getProjectId() <= 0) {
            throw new IllegalArgumentException("ProjectId is required");
        }
        if (incidentsReport.getIncidentsDate().isEmpty()) {
            throw new IllegalArgumentException("Report date is required ");
        }
        if (incidentsReport.getTotalIncidents()<=0) {
            throw new IllegalArgumentException(" Total incidents is required ");
        }
        if (incidentsReport.getTotalIncidents()<=1) {
            throw new IllegalArgumentException(" Total incidents min is 1 ");
        }
        if (incidentsReport.getTotalIncidents()>=100) {
            throw new IllegalArgumentException("Total incidents max is 100  ");
        }

        if (String.valueOf(incidentsReport.getTotalIncidents()).isEmpty()) {
            throw new IllegalArgumentException(" Total incidents is required ");
        }

        String rationale = incidentsReport.getRationale();
        if (rationale == null ||rationale.isEmpty()) {
            throw new IllegalArgumentException("Rationale is required");
        }
        if (rationale.trim().isEmpty()) {
            throw new IllegalArgumentException("A rationale with whitespaces is not valid");
        }
        if (rationale.length() > 1000) {
            throw new IllegalArgumentException("Rationale has a max length of 1000 characters");
        }
    }

    public static boolean isValidDate(IncidentsReport incidentsReport) {
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        df2.format(incidentsReport.getIncidentsDate());
        return true;
    }
}
