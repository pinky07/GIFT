package com.gft.GiFT.portfolios.compare.businessLogic;

import com.gft.GiFT.portfolios.compare.businessLogic.response.*;
import com.gft.GiFT.portfolios.compare.businessLogic.inputs.*;
import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.*;

public class LastSnapCreation {
    public static LastSnapDTO getLastSnap(int projectId, String projectName, CycleSnap snap) {
        LastSnapDTO latest = new LastSnapDTO();
        latest.setProjectName(projectName);
        latest.setProjectId(projectId);

        if (snap != null) {
            int targeted = snap.getTargetedPoints();
            int achieved = snap.getAchievedPoints();
            String tac = TacCalculation.calculateTac(targeted, achieved);
            latest.setTac(tac); //achieved + "|" + targeted + " " +
        }
        else{
            latest.setTac("No data");
        }

        return latest;
    }
}