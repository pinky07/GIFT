package com.gft.GiFT.projects.cycleSnapsAdd;

import com.gft.GiFT.entities.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class CycleSnapController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CycleSnapService cycleSnapService;

    public CycleSnapController(CycleSnapService cycleSnapService) {
        this.cycleSnapService = cycleSnapService;
    }


    @GetMapping("/{projectId}/name")
    public ResponseEntity<Object> findProjectNameById(@PathVariable("projectId") final int projectId) {

        logger.info("findProjectNameById: " + projectId);

        String projectName = cycleSnapService.findProjectNameById(projectId);

        if (projectName == null)
            return new ResponseEntity<>(new ErrorMessage(HttpStatus.NOT_FOUND, "Project: " + projectId + " could not be found."), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(projectName, HttpStatus.OK);
    }

}