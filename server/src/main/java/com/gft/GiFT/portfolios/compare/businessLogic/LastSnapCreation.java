package com.gft.GiFT.portfolios.compare.businessLogic;

import com.gft.GiFT.portfolios.compare.businessLogic.response.*;
import com.gft.GiFT.portfolios.compare.businessLogic.inputs.*;
import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class LastSnapCreation {
    public static LastSnapDTO getLastSnapForProjectWithSnap(int projectId,
                                                            String projectName,
                                                            CycleSnap snap,
                                                            Date firstCycleStartDate,
                                                            List<String> releaseDates,
                                                            List<IncidentReportBO> reports) throws ParseException {
        LastSnapDTO latest = new LastSnapDTO();
        latest.setProjectName(projectName);
        latest.setProjectId(projectId);

        int targeted = snap.getTargetedPoints();
        int achieved = snap.getAchievedPoints();
        String tac = TacCalculation.calculateTac(targeted, achieved);
        latest.setTac(tac); //achieved + "|" + targeted + " " +

        boolean isMoodAvailable = snap.isMoodAvailable();
        double moodAverage = snap.getMoodAverage();
        String mood = MoodCalculation.calculateMood(isMoodAvailable, moodAverage);
        latest.setMood(mood);

        boolean isWasteAvailable = snap.isWasteAvailable();
        double teamCapacity = snap.getTeamCapacity();
        double wasteDays = snap.getWasteDays();
        String waste = WasteMeasureCalculation.calculateWaste(teamCapacity, wasteDays, isWasteAvailable);
        latest.setWaste(waste);

        String cycleSnapEndDate = snap.getEndDate();
        String daysWithoutRelease = DaysSinceLastReleaseCalculation.determineDays(firstCycleStartDate, cycleSnapEndDate, releaseDates);
        latest.setDaysWithoutRelease(daysWithoutRelease);

        String incidents = RelatedIncidentsCalculation.determineRelatedIncidents(reports, cycleSnapEndDate, releaseDates);
        latest.setRelatedIncidents(incidents);

        return latest;
    }

    public static LastSnapDTO getLastSnapForProjectWithNoSnaps(int projectId, String projectName) {
        LastSnapDTO latest = new LastSnapDTO();
        latest.setProjectName(projectName);
        latest.setProjectId(projectId);
        latest.setTac("No data");
        latest.setDaysWithoutRelease("No data");
        latest.setRelatedIncidents("No data");
        latest.setMood("No data");
        latest.setWaste("No data");

        return latest;
    }
}