package com.gft.GiFT.projects.dashboard;

import com.gft.GiFT.projects.dashboard.businessLogic.ResponseEntityCreation;
import com.gft.GiFT.projects.dashboard.businessLogic.inputs.Project;
import com.gft.GiFT.projects.dashboard.businessLogic.inputs.DashboardInputs;
import com.gft.GiFT.projects.dashboard.dataAccess.DashboardProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class DashboardController {

    private final DashboardProjectRepository repository;

    public DashboardController(DashboardProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{projectId}/dashboard")
    public ResponseEntity<Object> findDashboardByProjectId(@PathVariable("projectId") final int projectId) throws ParseException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("findDashboardByProjectId received: " + projectId);

        DashboardInputs inputs = getDashboardInputs(projectId);
        ResponseEntity<Object> response = ResponseEntityCreation.getResponse(inputs);

        logger.info("findDashboardByProjectId returned {}", response);

        return response;
    }

    private DashboardInputs getDashboardInputs(@PathVariable("projectId") int projectId) {
        DashboardInputs data = new DashboardInputs();
        data.setProjectId(projectId);
        Project project = repository.findOne(projectId);
        data.setProject(project);
        data.setCurrentDate(new Date());
        return data;
    }
}