package com.gft.GiFT.portfolios.comparator;

import com.gft.GiFT.portfolios.comparator.businessLogic.response.LastSnap;
import com.gft.GiFT.portfolios.comparator.dataAccess.ComparatorProjectRepository;
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
        LastSnap lastsnap = new LastSnap();
        lastsnap.getp
        ResponseEntity<Object> response= new ResponseEntity<> ("Hello comparator", HttpStatus.OK);
        logger.info("Portfolio comparator  returned {}", response);

        return response;
    }

}
