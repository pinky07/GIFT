package com.gft.GiFT.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CycleSnapDTO {

    private String cycleSnapName;
    private String startDate;
    private String endDate;
    private int targetedPoints;
    private int achievedPoints;
    private String tac;

}