package com.gft.GiFT.projects.addCycleSnap.businessLogic;

import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.CycleSnap;
import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.Project;
import com.gft.GiFT.projects.addCycleSnap.dataAccess.CycleProjectRepository;
import com.gft.GiFT.projects.addCycleSnap.dataAccess.CycleSnapRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.util.Set;

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
    public CycleSnap createCycleSnap(CycleSnap newCycleSnap) throws ParseException {
        Set<CycleSnap> cycleSnapSet = cycleSnapRepository.findByProjectId(newCycleSnap.getProjectId());
        CycleSnapValidation.validate(newCycleSnap, cycleSnapSet);
        cycleSnapRepository.save(newCycleSnap);

        return newCycleSnap;
    }
}