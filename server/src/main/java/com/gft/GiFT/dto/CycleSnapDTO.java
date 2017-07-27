package com.gft.GiFT.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CycleSnapDTO {

    private String cycleSnapName;
    private Date startDate;
    private Date endDate;
    private int targetedPoints;
    private int achievedPoints;
    private String tac;

}