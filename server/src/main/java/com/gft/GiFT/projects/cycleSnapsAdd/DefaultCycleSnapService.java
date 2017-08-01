package com.gft.GiFT.projects.cycleSnapsAdd;

import com.gft.GiFT.entities.CycleSnap;
import com.gft.GiFT.entities.Project;
import org.springframework.stereotype.Service;

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
    public CycleSnap createCycleSnap(CycleSnap cycleSnap) {

        cycleSnapRepository.save(cycleSnap);

        return cycleSnap;
    }
}