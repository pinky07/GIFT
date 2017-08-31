package com.gft.GiFT.projects.dashboard.businessLogic;

import com.gft.GiFT.common.businessLogic.ErrorMessage;
import com.gft.GiFT.projects.dashboard.businessLogic.inputs.*;
import com.gft.GiFT.projects.dashboard.businessLogic.response.ProjectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.text.ParseException;
import java.util.*;

public class ResponseEntityCreation {

    public static ResponseEntity<Object> getResponse(DashboardInputs data) throws ParseException {
        if (data.projectDoesNotExist())
            return getNotFoundResponseEntity(data);
        else
            return getDashboardResponseEntity(data);
    }

    private static ResponseEntity<Object> getDashboardResponseEntity(DashboardInputs data) throws ParseException {
        ProjectDTO projectDTO = ProjectDTOCreation.get(data);

        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }

    private static ResponseEntity<Object> getNotFoundResponseEntity(DashboardInputs data) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorMessage errorMessage = getErrorMessage(data, status);

        return new ResponseEntity<>(errorMessage, status);
    }

    private static ErrorMessage getErrorMessage(DashboardInputs data, HttpStatus status) {
        String message = getErrorMessage(data);
        Date currentDate = data.getCurrentDate();

        return new ErrorMessage(status, message, currentDate);
    }

    private static String getErrorMessage(DashboardInputs data) {
        int projectId = data.getProjectId();

        return "Project " + projectId + " could not be found";
    }
}