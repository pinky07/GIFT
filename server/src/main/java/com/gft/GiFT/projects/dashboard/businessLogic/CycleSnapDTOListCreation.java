package com.gft.GiFT.projects.dashboard.businessLogic;

import com.gft.GiFT.common.businessLogic.DateFormatter;
import com.gft.GiFT.projects.dashboard.businessLogic.inputs.CycleSnap;
import com.gft.GiFT.projects.dashboard.businessLogic.inputs.Project;
import com.gft.GiFT.projects.dashboard.businessLogic.response.CycleSnapDTO;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class CycleSnapDTOListCreation {

    public static Set<CycleSnapDTO> get(Project project) throws ParseException {
        Date firstCycleSnapStartDate = findTheFirstCycleSnapDate(project);

        return generateTheList(project, firstCycleSnapStartDate);
    }

    private static Set<CycleSnapDTO> generateTheList(Project project, Date firstCycleSnapStartDate) throws ParseException {
        Set<CycleSnapDTO> cycleList = new LinkedHashSet<>();
        for (CycleSnap cycleSnap : project.getCycleSnapSet()) {
            CycleSnapDTO cycleSnapDTO = CycleSnapDTOCreation.get(
                    firstCycleSnapStartDate,
                    cycleSnap,
                    project.getIncidentsReports(),
                    project.getReleaseSnaps());
            cycleList.add(cycleSnapDTO);
        }
        return cycleList;
    }

    private static Date findTheFirstCycleSnapDate(Project project) throws ParseException {
        // Find the first cycle snap date
        Set<CycleSnap> cycles = project.getCycleSnapSet();
        TreeSet<Date> tree = new TreeSet<>();

        for (CycleSnap cycle : cycles) {
            String dateAsString = cycle.getStartDate();
            Date newDate = DateFormatter.convertDateStringToDate(dateAsString);
            tree.add(newDate);
        }

        return tree.first();
    }
}