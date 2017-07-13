package com.gft.GiFT.endpoints;

import com.gft.GiFT.entities.Project;
import com.gft.GiFT.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository repository;

    @GetMapping
    public ResponseEntity<List<Project>> findAllProjects() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public Project persist(@RequestBody final Project project){
        repository.save(project);
        return project;
    }
}