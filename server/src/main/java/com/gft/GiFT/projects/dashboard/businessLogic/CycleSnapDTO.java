package com.gft.GiFT.projects.dashboard.businessLogic;

import lombok.Data;

@Data
public class CycleSnapDTO {

    private String cycleSnapName;
    private String startDate;
    private String endDate;

    private int targetedPoints;
    private int achievedPoints;
    private String tac;

    private String relatedIncidents;

    private String daysSinceLastRelease;
    private String lastReleaseName;
    private String lastReleaseDate;

    private double teamCapacity;
    private double wasteDays;
    private double wastePercentage;
}