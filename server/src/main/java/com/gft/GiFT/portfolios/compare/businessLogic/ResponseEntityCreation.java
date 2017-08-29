package com.gft.GiFT.portfolios.comparator.businessLogic;

import com.gft.GiFT.portfolios.comparator.businessLogic.inputs.*;
import com.gft.GiFT.portfolios.comparator.businessLogic.response.*;
import org.springframework.http.*;

public class ResponseEntityCreation {
    public static ResponseEntity<Object> getResponse(ComparatorInputs inputs) {
        PortfolioComparatorDTO comparator = PortfolioComparatorCreation.getComparator(inputs);

        return new ResponseEntity<>(comparator, HttpStatus.OK);
    }
}
