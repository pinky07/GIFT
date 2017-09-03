package com.gft.GiFT.projects.addCycleSnap.businessLogic;

import com.gft.GiFT.common.businessLogic.*;
import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.*;
import org.springframework.http.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class ResponseCreation {
    public static ResponseEntity<Object> getResponse(AbstractInputs inputs) throws ParseException {
        try {
            return tryToAddCycleSnap(inputs);
        } catch (IllegalArgumentException exception) {
            return getErrorResponse(inputs, exception);
        }
    }

    private static ResponseEntity<Object> tryToAddCycleSnap(AbstractInputs inputs) throws ParseException {
        // AbstractInputs is the only source of information for the algorithm
        // It is what makes the whole algorithm Isolated and thus easy to unit test
        CycleSnap newCycleSnap = inputs.newCycleSnap;
        validate(inputs, newCycleSnap);

        // Every call to a external dependency is abstract in AbstractInputs
        inputs.save(newCycleSnap);

        return new ResponseEntity<>(newCycleSnap, HttpStatus.CREATED);
    }

    private static void validate(AbstractInputs inputs, CycleSnap newCycleSnap) throws ParseException {
        List<CycleSnap> existingCycles = getExistingCycleSnaps(inputs, newCycleSnap);

        // Business logic validations
        CycleSnapValidation.validate(newCycleSnap, existingCycles);
    }

    private static List<CycleSnap> getExistingCycleSnaps(AbstractInputs inputs, CycleSnap newCycleSnap) {
        int projectId = newCycleSnap.getProjectId();

        // DIP allows us to access a data source without even knowing
        // if it is a relational database or not
        return inputs.getExistingCycles(projectId);
    }

    private static ResponseEntity<Object> getErrorResponse(AbstractInputs inputs, IllegalArgumentException exception) {
        ErrorMessage error = getErrorMessage(inputs, exception);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    private static ErrorMessage getErrorMessage(AbstractInputs inputs, IllegalArgumentException exception) {
        // Receiving current date from inputs creates a testable algorithm
        Date currentDate = inputs.getCurrentDate();
        String errorMessage = exception.getMessage();

        return new ErrorMessage(HttpStatus.BAD_REQUEST, errorMessage, currentDate);
    }
}