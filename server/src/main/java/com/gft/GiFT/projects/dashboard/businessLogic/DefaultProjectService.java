package com.gft.GiFT.projects.dashboard.businessLogic;

import com.gft.GiFT.formatters.DateFormatter;
import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.*;
import com.gft.GiFT.projects.dashboard.dataAccess.*;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

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

        if (project.getCycleSnapSet().isEmpty()) {
            projectDTO.setCycleSnaps(new LinkedHashSet<>());
        } else {

            // Find the first cycle snap date
            Set<CycleSnap> cycles = project.getCycleSnapSet();
            TreeSet<Date> tree = new TreeSet<>();
            for (CycleSnap cycle : cycles) {
                Date newDate = DateFormatter.convertDateStringToDate(cycle.getStartDate());
                tree.add(newDate);
            }
            Date firstCycleSnapStartDate = tree.first();

            projectDTO.setCycleSnaps(new LinkedHashSet<>());
            for (CycleSnap cycleSnap : project.getCycleSnapSet()) {
                CycleSnapDTO cycleSnapDTO = createCycleSnapDTO(
                        firstCycleSnapStartDate,
                        cycleSnap,
                        project.getIncidentsReports(),
                        project.getReleaseSnaps());
                projectDTO.getCycleSnaps().add(cycleSnapDTO);
            }
        }
        return projectDTO;
    }

    private CycleSnapDTO createCycleSnapDTO(Date firstCycleSnapStartDate,
                                            CycleSnap cycleSnap,
                                            List<IncidentsReport> reports,
                                            List<ReleaseSnap> releaseSnaps) throws ParseException {
        CycleSnapDTO cycleSnapDTO = new CycleSnapDTO();
        cycleSnapDTO.setCycleSnapName(cycleSnap.getCycleSnapName());
        cycleSnapDTO.setStartDate(cycleSnap.getStartDate());
        cycleSnapDTO.setEndDate(cycleSnap.getEndDate());
        cycleSnapDTO.setTargetedPoints(cycleSnap.getTargetedPoints());
        cycleSnapDTO.setAchievedPoints(cycleSnap.getAchievedPoints());

        cycleSnapDTO.setTac(TacCalculation.calculateTac(cycleSnap.getTargetedPoints(),cycleSnap.getAchievedPoints()));

        List<String> releaseDates = new LinkedList<>();
        for (ReleaseSnap releaseSnap : releaseSnaps) {
            releaseDates.add(releaseSnap.getReleaseDate());
        }

        String relatedIncidents = RelatedIncidentsCalculation.determineRelatedIncidents(reports, cycleSnap.getEndDate(),releaseDates);
        cycleSnapDTO.setRelatedIncidents(relatedIncidents);

        LastReleaseInfo lastRelease = LastReleaseOperations.getLastRelease(cycleSnap.getEndDate(), releaseSnaps);

        String daysSinceLastRelease = DaysSinceLastReleaseCalculation.determineDays(firstCycleSnapStartDate, cycleSnap.getEndDate(), releaseDates);
        cycleSnapDTO.setDaysSinceLastRelease(daysSinceLastRelease);

        String lastReleaseName = lastRelease.getLastReleaseName();
        cycleSnapDTO.setLastReleaseName(lastReleaseName);

        String lastReleaseDate = lastRelease.getLastReleaseDate();
        cycleSnapDTO.setLastReleaseDate(lastReleaseDate);

        double teamCapacity = cycleSnap.getTeamCapacity();
        cycleSnapDTO.setTeamCapacity(teamCapacity);

        double wasteDays = cycleSnap.getWasteDays();
        cycleSnapDTO.setWasteDays(wasteDays);
        double moodAverage = cycleSnap.getMoodAverage();

        boolean isMoodAvailable = cycleSnap.isMoodAvailable();
        boolean isWasteAvailable = cycleSnap.isWasteAvailable();

        String wastePercentage = WasteMeasureCalculation.calculateWaste(teamCapacity, wasteDays, isWasteAvailable);
        cycleSnapDTO.setWastePercentage(wastePercentage);

        String mood = MoodCalculation.calculateMood(isMoodAvailable, moodAverage);
        cycleSnapDTO.setMood(mood);

        return cycleSnapDTO;
    }

}