package com.gft.GiFT.dashboard;

import com.gft.GiFT.entities.CycleSnap;
import com.gft.GiFT.entities.Project;
import com.gft.GiFT.formatters.DateFormatter;
import org.springframework.stereotype.Service;
import java.util.LinkedHashSet;

@Service
public class DefaultProjectService implements ProjectService {

    private final DashboardProjectRepository projectRepository;

    public DefaultProjectService(DashboardProjectRepository projectRepository) {
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
            projectDTO.setCycleSnaps(new LinkedHashSet<>());
        } else {
            projectDTO.setCycleSnaps(new LinkedHashSet<>());
            for (CycleSnap cycleSnap : project.getCycleSnapSet()) {
                projectDTO.getCycleSnaps().add(createCycleSnapDTO(cycleSnap));
            }
        }
        return projectDTO;
    }

    private CycleSnapDTO createCycleSnapDTO(CycleSnap cycleSnap) {
        CycleSnapDTO cycleSnapDTO = new CycleSnapDTO();
        cycleSnapDTO.setCycleSnapName(cycleSnap.getCycleSnapName());
        cycleSnapDTO.setStartDate(DateFormatter.convertDateToString(cycleSnap.getStartDate()));
        cycleSnapDTO.setEndDate(DateFormatter.convertDateToString(cycleSnap.getEndDate()));
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