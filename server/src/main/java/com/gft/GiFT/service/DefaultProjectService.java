package com.gft.GiFT.service;

import com.gft.GiFT.dto.CycleSnapDTO;
import com.gft.GiFT.dto.ProjectDTO;
import com.gft.GiFT.entities.CycleSnap;
import com.gft.GiFT.entities.Project;
import com.gft.GiFT.repository.ProjectRepository;
import com.gft.GiFT.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class DefaultProjectService implements ProjectService {

    private final ProjectRepository projectRepository;

    public DefaultProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public ProjectDTO findDashboardByProjectId(int projectId) {

        Project project = projectRepository.findOne(projectId);

        if (project == null)
            return null;

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(project.getName());

        if(project.getCycleSnapSet().isEmpty()){
            projectDTO.setCycleSnaps(new HashSet<>());
        } else {
            projectDTO.setCycleSnaps(new HashSet<>());
            for (CycleSnap cycleSnap : project.getCycleSnapSet()) {
                projectDTO.getCycleSnaps().add(createCycleSnapDTO(cycleSnap));
            }
        }
        return projectDTO;
    }

    private CycleSnapDTO createCycleSnapDTO(CycleSnap cycleSnap) {
        CycleSnapDTO cycleSnapDTO = new CycleSnapDTO();
        cycleSnapDTO.setCycleSnapName(cycleSnap.getCycleSnapName());
        cycleSnapDTO.setStartDate(DateUtils.getDateFormatterToString(cycleSnap.getStartDate()));
        cycleSnapDTO.setEndDate(DateUtils.getDateFormatterToString(cycleSnap.getEndDate()));
        cycleSnapDTO.setTargetedPoints(cycleSnap.getTargetedPoints());
        cycleSnapDTO.setAchievedPoints(cycleSnap.getAchievedPoints());

        if (cycleSnap.getTargetedPoints() == 0) {
            cycleSnapDTO.setTac("No Data");
        } else {
            int tac = (cycleSnap.getAchievedPoints() * 100 / cycleSnap.getTargetedPoints());
            cycleSnapDTO.setTac(tac + "%");
        }
        return cycleSnapDTO;
    }

}