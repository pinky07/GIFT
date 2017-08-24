package com.gft.GiFT.projects.dashboard.businessLogic;

import com.gft.GiFT.projects.dashboard.businessLogic.inputs.DashboardInputs;
import com.gft.GiFT.projects.dashboard.businessLogic.inputs.Project;
import com.gft.GiFT.projects.dashboard.businessLogic.response.CycleSnapDTO;
import com.gft.GiFT.projects.dashboard.businessLogic.response.ProjectDTO;

import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.Set;

public class ProjectDTOCreation {

    public static ProjectDTO get(DashboardInputs data) throws ParseException {
        ProjectDTO projectDTO = new ProjectDTO();
        Project project = data.getProject();
        projectDTO.setName(project.getName());

        if (project.getCycleSnapSet().isEmpty()) {
            Set<CycleSnapDTO> cycleList = new LinkedHashSet<>();
            projectDTO.setCycleSnaps(cycleList);
        }
        else{
            Set<CycleSnapDTO> cycleList = CycleSnapDTOListCreation.get(project);
            projectDTO.setCycleSnaps(cycleList);
        }

        return projectDTO;
    }
}