package com.gft.GiFT.projects.dashboard;

import lombok.Data;

import java.util.Set;

@Data
public class ProjectDTO {

    private String name;
    private Set<CycleSnapDTO> cycleSnaps;

}