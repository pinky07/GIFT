package com.gft.GiFT.projects.dashboard;

import lombok.Data;

@Data
public class CycleSnapDTO {

    private String cycleSnapName;
    private String startDate;
    private String endDate;
    private int targetedPoints;
    private int achievedPoints;
    private String daysSinceLastRelease;
    private String tac;

}