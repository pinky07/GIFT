package com.gft.GiFT.projects.dashboard.businessLogic.businessRules;

public class MoodCalculation {

    public static String MoodCalculate(boolean isMoodAvailabel, float moodAvearge) {
        String howIsMood;
        if (isMoodAvailabel) {
            howIsMood = String.valueOf((moodAvearge));
            return howIsMood;
        } else {
            howIsMood = "No data";
            return howIsMood;
        }
    }
}
