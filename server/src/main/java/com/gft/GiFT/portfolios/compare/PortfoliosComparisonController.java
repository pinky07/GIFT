package com.gft.GiFT.portfolios.compare;

import com.gft.GiFT.portfolios.compare.businessLogic.inputs.CompareInputs;
import com.gft.GiFT.portfolios.compare.businessLogic.inputs.Portfolio;
import com.gft.GiFT.portfolios.compare.businessLogic.ResponseEntityCreation;
import com.gft.GiFT.portfolios.compare.dataAccess.ComparisonProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/portfolios")
public class PortfoliosComparisonController {
    private final ComparisonProjectRepository repository;

    public PortfoliosComparisonController(ComparisonProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{portfolioId}/comparison")
    public ResponseEntity<Object> getPortfolioComparison(@PathVariable("portfolioId") final int portfolioId) throws ParseException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("getPortfolioComparison received: " + portfolioId);

        CompareInputs inputs = getCompareInputs(portfolioId);
        ResponseEntity<Object> response = ResponseEntityCreation.getResponse(inputs);

        logger.info("getPortfolioComparison returned {}", response);

        return response;
    }

    private CompareInputs getCompareInputs(@PathVariable("portfolioId") int portfolioId) {
        CompareInputs inputs = new CompareInputs();
        Portfolio portfolio = repository.findOne(portfolioId);
        inputs.setPortFolio(portfolio);
        inputs.setPortfolioId(portfolioId);
        Date currentDate = new Date();
        inputs.setCurrentDate(currentDate);
        return inputs;
    }
}