package com.gft.GiFT.projects.cycleSnapsAdd;

import com.gft.GiFT.entities.CycleSnap;
import com.gft.GiFT.entities.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class CycleSnapController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CycleSnapService cycleSnapService;

    public CycleSnapController(CycleSnapService cycleSnapService) {
        this.cycleSnapService = cycleSnapService;
    }

    @PostMapping("/cyclesnaps")
    public ResponseEntity<Object> createCycleSnap(@RequestBody final CycleSnap newCycleSnap) throws ParseException {
        logger.info("createCycleSnap received: " + newCycleSnap);

        ResponseEntity<Object> response;
        try {
            CycleSnap cycleSnapCreated = cycleSnapService.createCycleSnap(newCycleSnap);
            response = new ResponseEntity<>(cycleSnapCreated, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            response = new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        logger.info("createCycleSnap returned: {}", response);
        return response;
    }

}