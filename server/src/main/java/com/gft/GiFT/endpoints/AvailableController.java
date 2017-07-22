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
@RequestMapping(value = "/api/v1/")
public class AvailableController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/available")
    public ResponseEntity<Boolean> areYouAvailable() {
        logger.info("API is available");

        return new ResponseEntity<>(true,
                HttpStatus.OK);
    }
}