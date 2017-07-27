package com.gft.GiFT.service;

import com.gft.GiFT.dto.ProjectDTO;
import com.gft.GiFT.entities.CycleSnapDTO;
import com.gft.GiFT.entities.Project;
import com.gft.GiFT.repository.CycleSnapRepository;
import com.gft.GiFT.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProjectService implements ProjectService {

    private final ProjectRepository projectRepository;
    private final CycleSnapRepository cycleSnapRepository;

    public DefaultProjectService(ProjectRepository projectRepository, CycleSnapRepository cycleSnapRepository) {
        this.projectRepository = projectRepository;
        this.cycleSnapRepository = cycleSnapRepository;
    }


    @Override
    public ProjectDTO findDashboardByProjectId(int projectId) {

        Project project = projectRepository.findOne(projectId);
        List<CycleSnapDTO> cycleSnap = cycleSnapRepository.findByProjectId(project);

        return null;
    }
}