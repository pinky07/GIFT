package com.gft.GiFT.projects.dashboard.businessLogic.businessRules;

public class MoodCalculation {

    public static String MoodCalculate(boolean isMoodAvailabel, double moodAverage) {
        String howIsMood;
        if (isMoodAvailabel) {
            howIsMood = String.valueOf((moodAverage));
            return howIsMood;
        } else {
            howIsMood = "No data";
            return howIsMood;
        }
    }
}
