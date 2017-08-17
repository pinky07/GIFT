package com.gft.GiFT.projects.dashboard.businessLogic.businessRules;

import java.text.DecimalFormat;

public class WasteMeasureCalculation {
    public static String calculateWaste(double teamCapacity, double wasteDays, boolean isWasteAvailable) {

        String wastePercentString;
        if (isWasteAvailable) {
            double wastePercent = (wasteDays / teamCapacity);
            wastePercent = wastePercent * 100;
            double roundOff = (double) Math.round(wastePercent * 100) / 100;
            wastePercentString = Double.toString(roundOff);
            return wastePercentString + "%";
        } else {
            wastePercentString = "No data";
            return wastePercentString;
        }
    }
}
