package com.gft.GiFT.portfolios.comparator;

import com.gft.GiFT.portfolios.comparator.businessLogic.inputs.ComparatorInputs;
import com.gft.GiFT.portfolios.comparator.businessLogic.inputs.Portfolio;
import com.gft.GiFT.portfolios.comparator.dataAccess.*;
import com.gft.GiFT.portfolios.comparator.businessLogic.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        logger.info("getPortfolioComparator received: " + portfolioId);

        ComparatorInputs inputs = new ComparatorInputs();
        Portfolio portfolio = repository.findOne(portfolioId);
        inputs.setPortFolio(portfolio);
        inputs.setPortfolioId(portfolioId);
        ResponseEntity<Object> response= ResponseEntityCreation.getResponse(inputs);

        logger.info("getPortfolioComparator returned {}", response);

        return response;
    }
}