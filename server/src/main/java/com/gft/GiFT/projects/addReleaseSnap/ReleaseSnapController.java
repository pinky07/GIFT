package com.gft.GiFT.projects.addReleaseSnap;

import com.gft.GiFT.common.businessLogic.ErrorMessage;
import com.gft.GiFT.projects.addReleaseSnap.businessLogic.ReleaseSnapService;
import com.gft.GiFT.projects.addReleaseSnap.businessLogic.inputs.ReleaseSnap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class ReleaseSnapController {
    private ReleaseSnapService releaseSnapService;

    public ReleaseSnapController(ReleaseSnapService releaseSnapService) {
        this.releaseSnapService = releaseSnapService;
    }

    @PostMapping("/releases")
    public ResponseEntity<Object> addReleaseSnap(@RequestBody final ReleaseSnap newReleaseSnap) throws ParseException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("addCycleSnap received: " + newReleaseSnap);

        ResponseEntity<Object> response;
        try{
            ReleaseSnap cycleSnapCreated = releaseSnapService.createReleaseSnap(newReleaseSnap);
            response = new ResponseEntity<>(cycleSnapCreated, HttpStatus.CREATED);
        }
        catch(IllegalArgumentException exception){
            Date currentDate = new Date();
            String errorMessage = exception.getMessage();
            response = new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST, errorMessage, currentDate), HttpStatus.BAD_REQUEST);

        }
        logger.info("addReleaseSnap returned: {}\", response");

        return   response;
    }


}