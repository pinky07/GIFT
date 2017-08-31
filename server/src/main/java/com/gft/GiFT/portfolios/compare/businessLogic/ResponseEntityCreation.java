package com.gft.GiFT.portfolios.compare.businessLogic;

import com.gft.GiFT.portfolios.compare.businessLogic.inputs.*;
import com.gft.GiFT.portfolios.compare.businessLogic.response.*;
import org.springframework.http.*;

import java.text.ParseException;

public class ResponseEntityCreation {
    public static ResponseEntity<Object> getResponse(CompareInputs inputs) throws ParseException {
        PortfolioCompareDTO comparison = PortfolioCompareCreation.getComparison(inputs);

        return new ResponseEntity<>(comparison, HttpStatus.OK);
    }
}
