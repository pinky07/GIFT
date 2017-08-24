package com.gft.GiFT.projects.addCycleSnap;

import com.gft.GiFT.common.businessLogic.ErrorMessage;
import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.CycleSnap;
import com.gft.GiFT.projects.addCycleSnap.businessLogic.CycleSnapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class CycleSnapController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final CycleSnapService cycleSnapService;

    public CycleSnapController(CycleSnapService cycleSnapService) {
        this.cycleSnapService = cycleSnapService;
    }

    @PostMapping("/cyclesnaps")
    public ResponseEntity<Object> addCycleSnap(@RequestBody final CycleSnap newCycleSnap) throws ParseException {
        logger.info("addCycleSnap received: " + newCycleSnap);

        ResponseEntity<Object> response;
        try {
            CycleSnap cycleSnapCreated = cycleSnapService.createCycleSnap(newCycleSnap);
            response = new ResponseEntity<>(cycleSnapCreated, HttpStatus.CREATED);
        } catch (IllegalArgumentException exception) {
            Date currentDate = new Date();
            String errorMessage = exception.getMessage();
            response = new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST, errorMessage, currentDate), HttpStatus.BAD_REQUEST);
        }

        logger.info("addCycleSnap returned: {}", response);
        return response;
    }

}