package com.gft.GiFT.projects.cycleSnapsAdd;

import com.gft.GiFT.entities.CycleSnap;
import com.gft.GiFT.entities.Project;
import com.gft.GiFT.formatters.DateFormatter;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

@Service
public class DefaultCycleSnapService implements CycleSnapService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
        DateTime startDateTime = new DateTime(DateFormatter.convertDateStringToDate(cycleSnap.getStartDate()));
        DateTime endDateTime = new DateTime(DateFormatter.convertDateStringToDate(cycleSnap.getEndDate()));
        Date startDate = DateFormatter.convertDateStringToDate(cycleSnap.getStartDate());
        Date endDate = DateFormatter.convertDateStringToDate(cycleSnap.getEndDate());

        if (cycleSnap.getCycleSnapName().isEmpty()) {
            throw new IllegalArgumentException("Cycle name is required.");
        } else if (cycleSnap.getCycleSnapName().length() > 200) {
            throw new IllegalArgumentException("Cycle Snap Name can not be greater than 200 characters.");
        } else if (cycleSnap.getStartDate().isEmpty()) {
            throw new IllegalArgumentException("Start Date is required.");
        } else if (cycleSnap.getEndDate().isEmpty()) {
            throw new IllegalArgumentException("End Date is required.");
        } else if (endDate.before(startDate)) {
            throw new IllegalArgumentException("Start Date should precede End Date.");
        } else if (cycleSnap.getTargetedPoints() > 10000) {
            throw new IllegalArgumentException("Max number for Targeted Points is 10,000.");
        } else if (cycleSnap.getAchievedPoints() > 10000) {
            throw new IllegalArgumentException("Max number for Achieved Points is 10,000.");
        }

        //Cycle dates shouldn't overlap
        Set<CycleSnap> cycleSnapSet = cycleSnapRepository.findByProjectId(cycleSnap.getProjectId());

        for (CycleSnap newCycleSnap : cycleSnapSet) {
            DateTime cycleStartDate = new DateTime(DateFormatter.convertDateStringToDate(newCycleSnap.getStartDate()));
            DateTime cycleEndDate = new DateTime(DateFormatter.convertDateStringToDate(newCycleSnap.getEndDate()));

            Interval comingDatesFromUser = new Interval(startDateTime, endDateTime);
            Interval comingDatesFromDB = new Interval(cycleStartDate, cycleEndDate);

            if (comingDatesFromUser.overlaps(comingDatesFromDB)) {
                throw new IllegalArgumentException("The new cycle dates overlap an existing one.");
            }
        }
    }
}