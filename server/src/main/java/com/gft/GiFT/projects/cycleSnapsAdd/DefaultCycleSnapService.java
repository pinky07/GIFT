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
        Set<CycleSnap> cycleSnapSet = cycleSnapRepository.findByProjectId(cycleSnap.getProjectId());
        CycleSnapValidation.validate(cycleSnap, cycleSnapSet);
        cycleSnapRepository.save(cycleSnap);

        return cycleSnap;
    }
}