package com.gft.GiFT.portfolios.comparator;

import com.gft.GiFT.portfolios.comparator.businessLogic.response.*;
import com.gft.GiFT.portfolios.comparator.dataAccess.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping(value = "/api/v1/portfolios")
public class PortfoliosComparatorController {
    private final ComparatorProjectRepository repository;

    public PortfoliosComparatorController(ComparatorProjectRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/{portfolioId}/comparator")
    public ResponseEntity<Object> getPortfolioComparator(@PathVariable("portfolioId") final int portfolioId) throws ParseException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("Portfolio comparator received: " + portfolioId);

        LastSnapDTO exceptionalProject = new LastSnapDTO();
        exceptionalProject.setProjectName("Exceptional project");
        exceptionalProject.setTac("100%");
        exceptionalProject.setDaysWithoutRelease("13");
        exceptionalProject.setRelatedIncidents("6");
        exceptionalProject.setWaste("No data");
        exceptionalProject.setMood("No data");

        LastSnapDTO appraisalTool = new LastSnapDTO();
        appraisalTool.setProjectName("No data");
        appraisalTool.setTac("No data");
        appraisalTool.setDaysWithoutRelease("No data");
        appraisalTool.setRelatedIncidents("No data");
        appraisalTool.setWaste("No data");
        appraisalTool.setMood("No data");

        PortfolioComparatorDTO comparator = new PortfolioComparatorDTO();
        comparator.setPortfolioName("Amazing projects");
        comparator.addSnap(exceptionalProject);
        comparator.addSnap(appraisalTool);

        ResponseEntity<Object> response= new ResponseEntity<> (comparator, HttpStatus.OK);

        logger.info("Portfolio comparator  returned {}", response);

        return response;
    }
}