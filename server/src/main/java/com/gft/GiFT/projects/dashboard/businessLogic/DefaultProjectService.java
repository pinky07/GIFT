package com.gft.GiFT.projects.dashboard.businessLogic;

import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.*;
import com.gft.GiFT.projects.dashboard.dataAccess.*;
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
                CycleSnapDTO cycleSnapDTO = createCycleSnapDTO(
                        cycleSnap,
                        releaseSnapDates,
                        project.getIncidentsReports(),
                        project.getReleaseSnaps());
                projectDTO.getCycleSnaps().add(cycleSnapDTO);
            }
        }
        return projectDTO;
    }

    private CycleSnapDTO createCycleSnapDTO(CycleSnap cycleSnap,
                                            List<String> releaseDates,
                                            List<IncidentsReport> reports,
                                            List<ReleaseSnap> releaseSnaps) throws ParseException {
        CycleSnapDTO cycleSnapDTO = new CycleSnapDTO();
        cycleSnapDTO.setCycleSnapName(cycleSnap.getCycleSnapName());
        cycleSnapDTO.setStartDate(cycleSnap.getStartDate());
        cycleSnapDTO.setEndDate(cycleSnap.getEndDate());
        cycleSnapDTO.setTargetedPoints(cycleSnap.getTargetedPoints());
        cycleSnapDTO.setAchievedPoints(cycleSnap.getAchievedPoints());

        cycleSnapDTO.setTac(TacCalculation.calculateTac(cycleSnap.getTargetedPoints(),cycleSnap.getAchievedPoints()));

        String daysSinceLastRelease = DaysSinceLastReleaseCalculation.determineDays(cycleSnap.getEndDate(), releaseDates);
        cycleSnapDTO.setDaysSinceLastRelease(daysSinceLastRelease);

        String relatedIncidents = RelatedIncidentsCalculation.determineRelatedIncidents(reports, cycleSnap.getEndDate(),releaseDates);
        cycleSnapDTO.setRelatedIncidents(relatedIncidents);

        LastReleaseInfo lastRelease = LastReleaseOperations.getLastRelease(cycleSnap.getEndDate(), releaseSnaps);

        String lastReleaseName = lastRelease.getLastReleaseName();
        cycleSnapDTO.setLastReleaseName(lastReleaseName);

        String lastReleaseDate = lastRelease.getLastReleaseDate();
        cycleSnapDTO.setLastReleaseDate(lastReleaseDate);

        return cycleSnapDTO;
    }

}