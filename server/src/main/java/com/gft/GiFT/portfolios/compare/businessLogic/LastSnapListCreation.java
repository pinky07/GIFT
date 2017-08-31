package com.gft.GiFT.portfolios.compare.businessLogic;

import com.gft.GiFT.portfolios.compare.businessLogic.inputs.*;
import com.gft.GiFT.portfolios.compare.businessLogic.response.LastSnapDTO;
import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.CycleSnapsOperations;
import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.IncidentReportBO;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LastSnapListCreation {
    public static List<LastSnapDTO> getList(List<Project> projects) throws ParseException {
        List<LastSnapDTO> snaps = new LinkedList<>();

        for(Project project : projects){
            CycleSnap last = project.getLastSnap();
            String name = project.getName();
            int id = project.getId();

            LastSnapDTO lastSnapDTO;

            if (last != null){
                List<String> releaseDates = project.getReleasesDates();
                List<String> startDatesAsString = project.getCyclesStartDates();
                Date firstCycleStartDate = CycleSnapsOperations.findTheFirstDate(startDatesAsString);
                List<IncidentReportBO> incidents = project.getIncidentsAsBusinessObjects();
                lastSnapDTO = LastSnapCreation.getLastSnapForProjectWithSnap(id, name, last, firstCycleStartDate, releaseDates, incidents);
            }
            else
                lastSnapDTO = LastSnapCreation.getLastSnapForProjectWithNoSnaps(id, name);

            snaps.add(lastSnapDTO);
        }

        return snaps;
    }
}