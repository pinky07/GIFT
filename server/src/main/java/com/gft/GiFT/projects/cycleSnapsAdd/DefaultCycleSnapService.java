package com.gft.GiFT.projects.cycleSnapsAdd;

import com.gft.GiFT.entities.Project;
import org.springframework.stereotype.Service;

@Service
public class DefaultCycleSnapService implements CycleSnapService {

    private final CycleProjectRepository projectRepository;

    public DefaultCycleSnapService(CycleProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public String findProjectNameById(int projectId) {

        Project project = projectRepository.findOne(projectId);

        return project.getName();
    }
}