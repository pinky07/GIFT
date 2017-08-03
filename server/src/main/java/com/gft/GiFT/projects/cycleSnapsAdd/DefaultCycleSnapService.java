package com.gft.GiFT.projects.cycleSnapsAdd;

import com.gft.GiFT.entities.CycleSnap;
import com.gft.GiFT.entities.Project;
import com.gft.GiFT.formatters.DateFormatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class DefaultCycleSnapService implements CycleSnapService {

    private final CycleProjectRepository projectRepository;
    private final CycleSnapRepository cycleSnapRepository;

    public DefaultCycleSnapService(CycleProjectRepository projectRepository, CycleSnapRepository cycleSnapRepository) {
        this.projectRepository = projectRepository;
        this.cycleSnapRepository = cycleSnapRepository;
    }

    @Override
    public String findProjectNameById(int projectId) {

        Project project = projectRepository.findOne(projectId);

        if (project == null)
            return null;

        return project.getName();
    }

    @Override
    public CycleSnap createCycleSnap(CycleSnap cycleSnap) throws ParseException {

        validateCycleSnap(cycleSnap);

        cycleSnapRepository.save(cycleSnap);

        return cycleSnap;
    }

    private void validateCycleSnap(CycleSnap cycleSnap) throws ParseException {
        if (cycleSnap.getCycleSnapName().isEmpty()) {
            throw new IllegalArgumentException("No Cycle Snap Name found in request body.");
        } else if (cycleSnap.getCycleSnapName().length() > 200){
            throw new IllegalArgumentException("Cycle Snap Name can not be greater than 200 characters.");
        }else if (cycleSnap.getStartDate().isEmpty()) {
            throw new IllegalArgumentException("No Start Date found in request body.");
        } else if (cycleSnap.getEndDate().isEmpty()) {
            throw new IllegalArgumentException("No End Date found in request body.");
        } else if (DateFormatter.convertDateStringToDate(cycleSnap.getEndDate()).before(DateFormatter.convertDateStringToDate(cycleSnap.getStartDate()))) {
            throw new IllegalArgumentException("End Date can not be before Start Date.");
        } else if (cycleSnap.getTargetedPoints() > 10000) {
            throw new IllegalArgumentException("The Targeted Points can not be greater than 10,000.");
        } else if (cycleSnap.getAchievedPoints() > 10000) {
            throw new IllegalArgumentException("The Achieved Points can not be greater than 10,000.");
        }
    }
}