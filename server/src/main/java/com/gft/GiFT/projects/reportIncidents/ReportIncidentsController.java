package com.gft.GiFT.projects.reportIncidents;

import com.gft.GiFT.common.businessLogic.ErrorMessage;
import com.gft.GiFT.projects.reportIncidents.businessLogic.inputs.IncidentsReport;
import com.gft.GiFT.projects.reportIncidents.businessLogic.ReportIncidentsService;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import org.slf4j.Logger;

@RestController
@RequestMapping(value = "/api/v1/projects")
public class ReportIncidentsController {
    private ReportIncidentsService reportIncidentsService;

    public ReportIncidentsController(ReportIncidentsService reportIncidentsService) {
        this.reportIncidentsService = reportIncidentsService;
    }

    @PostMapping("/incidents")
    public ResponseEntity<Object> addReportIncidents(@RequestBody final IncidentsReport newReportIncidents) throws ParseException {
        Logger logger =  LoggerFactory.getLogger(this.getClass());
        logger.info("incidentsReport received: " + newReportIncidents);
        ResponseEntity<Object> response;

        try {
            IncidentsReport incidentsReportCreated = reportIncidentsService.createIncidentsReport(newReportIncidents);
            response = new ResponseEntity<>(incidentsReportCreated, HttpStatus.CREATED);
        }
        catch (IllegalArgumentException exception) {
            Date currentDate = new Date();
            String errorMessage = exception.getMessage();
            response = new ResponseEntity<>(new ErrorMessage(HttpStatus.BAD_REQUEST, errorMessage, currentDate), HttpStatus.BAD_REQUEST);

        }

        return response;
    }


}
