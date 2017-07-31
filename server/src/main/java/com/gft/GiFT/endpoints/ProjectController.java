package com.gft.GiFT.endpoints;

import com.gft.GiFT.entities.Project;
import com.gft.GiFT.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class ProjectController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProjectRepository repository;

    @GetMapping("/portfolio/{id}")
    public ResponseEntity<List<Project>> findAllProjectsByPortfolio(@PathVariable("id") final int id) {
        logger.debug("This is a debug message: findAllProjectsByPortfolio " + id);
        logger.info("This is an info message: findAllProjectsByPortfolio " + id);
        logger.warn("This is a warn message: findAllProjectsByPortfolio " + id);
        logger.error("This is an error message: findAllProjectsByPortfolio " + id);

        return new ResponseEntity<>(
                repository.findByPortfolioId(id),
                HttpStatus.OK);
    }

    @PostMapping()
    public Project persist(@RequestBody final Project project){
        repository.save(project);
        return project;
    }

}