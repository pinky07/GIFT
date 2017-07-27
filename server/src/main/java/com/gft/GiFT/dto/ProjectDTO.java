package com.gft.GiFT.dto;

import com.gft.GiFT.entities.CycleSnapDTO;
import lombok.Data;

import java.util.Set;

@Data
public class ProjectDTO {

    private String name;
    private Set<CycleSnapDTO> cycleSnapList;

}