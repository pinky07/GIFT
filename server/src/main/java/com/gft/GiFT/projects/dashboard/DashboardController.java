package com.gft.GiFT.projects.dashboard;

import com.gft.GiFT.entities.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class DashboardController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProjectService projectService;

    public DashboardController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{projectId}/dashboard")
    public ResponseEntity<Object> findDashboardByProjectId(@PathVariable("projectId") final int projectId) throws ParseException {

        logger.info("findDashboardByProjectId: " + projectId);

        ProjectDTO projectDTO = projectService.findDashboardByProjectId(projectId);

        if (projectDTO == null)
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND, "Project: " + projectId + " could not be found"), HttpStatus.NOT_FOUND);

        logger.info("{}", projectDTO);

        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }
}