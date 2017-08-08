package com.gft.GiFT.projects.dashboard;

import com.gft.GiFT.entities.CycleSnap;
import com.gft.GiFT.entities.Project;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

@Service
public class DefaultProjectService implements ProjectService {

    private final DashboardProjectRepository projectRepository;

    public DefaultProjectService(DashboardProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public ProjectDTO findDashboardByProjectId(int projectId) throws ParseException {

        Project project = projectRepository.findOne(projectId);

        if (project == null)
            return null;

        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(project.getName());

        List<String> releaseSnapDates = new LinkedList<>();

        for (ReleaseSnap releaseSnap : project.getReleaseSnaps()) {
            releaseSnapDates.add(releaseSnap.getReleaseDate());
        }

        if (project.getCycleSnapSet().isEmpty()) {
            projectDTO.setCycleSnaps(new LinkedHashSet<>());
        } else {
            projectDTO.setCycleSnaps(new LinkedHashSet<>());
            for (CycleSnap cycleSnap : project.getCycleSnapSet()) {
                projectDTO.getCycleSnaps().add(createCycleSnapDTO(cycleSnap, releaseSnapDates));
            }
        }
        return projectDTO;
    }

    private CycleSnapDTO createCycleSnapDTO(CycleSnap cycleSnap, List<String> releaseDates) throws ParseException {
        CycleSnapDTO cycleSnapDTO = new CycleSnapDTO();
        cycleSnapDTO.setCycleSnapName(cycleSnap.getCycleSnapName());
        cycleSnapDTO.setStartDate(cycleSnap.getStartDate());
        cycleSnapDTO.setEndDate(cycleSnap.getEndDate());
        cycleSnapDTO.setTargetedPoints(cycleSnap.getTargetedPoints());
        cycleSnapDTO.setAchievedPoints(cycleSnap.getAchievedPoints());
        cycleSnapDTO.setDaysSinceLastRelease(DaysSinceLastReleaseCalculation.determineDaysSinceLastRelease(cycleSnap.getEndDate(), releaseDates));
        cycleSnapDTO.setTac(TacCalculation.calculateTac(cycleSnap.getTargetedPoints(), cycleSnap.getAchievedPoints()));
        return cycleSnapDTO;
    }

}