package com.gft.GiFT.projects.addCycleSnap;

import com.gft.GiFT.projects.addCycleSnap.businessLogic.ResponseCreation;
import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.*;
import com.gft.GiFT.projects.addCycleSnap.dataAccess.*;
import org.slf4j.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class CycleSnapController {
    private final CycleSnapRepository repository;
    private final Logger logger;

    public CycleSnapController(CycleSnapRepository repository) {
        this.repository = repository;
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @PostMapping("/cyclesnaps")
    public ResponseEntity<Object> addCycleSnap(@RequestBody final CycleSnap newCycleSnap) throws ParseException {
        logReceivedData(newCycleSnap);
        ResponseEntity<Object> response = processAddCycleSnap(newCycleSnap);
        logReturnedData(response);

        return response;
    }

    private ResponseEntity<Object> processAddCycleSnap(CycleSnap newCycleSnap) throws ParseException {
        AbstractInputs inputs = initializeInputs(newCycleSnap);
        return ResponseCreation.getResponse(inputs);
    }

    private AbstractInputs initializeInputs(CycleSnap newCycleSnap) {
        // Initialize external dependencies of the algorithm
        AbstractInputs inputs = new PersistentInputs(repository);
        // Initialize user inputs for the algorithm
        inputs.newCycleSnap = newCycleSnap;

        return inputs;
    }

    private void logReceivedData(CycleSnap newCycleSnap) {
        logger.info("addCycleSnap received: " + newCycleSnap);
    }
    private void logReturnedData(ResponseEntity<Object> response) {
        logger.info("addCycleSnap returned: {}", response);
    }
}