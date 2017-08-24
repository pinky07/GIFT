package com.gft.GiFT.projects.dashboard.businessLogic.response;

import lombok.Data;

import java.util.Set;

@Data
public class ProjectDTO {

    private String name;
    private Set<CycleSnapDTO> cycleSnaps;

    public void addCycleSnap(CycleSnapDTO cycle){
        cycleSnaps.add(cycle);
    }

}