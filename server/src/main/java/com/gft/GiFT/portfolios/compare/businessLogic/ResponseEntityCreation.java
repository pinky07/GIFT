package com.gft.GiFT.portfolios.compare.businessLogic;

import com.gft.GiFT.common.businessLogic.ErrorMessage;
import com.gft.GiFT.portfolios.compare.businessLogic.inputs.*;
import com.gft.GiFT.portfolios.compare.businessLogic.response.*;
import org.springframework.http.*;

import java.text.ParseException;
import java.util.Date;

public class ResponseEntityCreation {
    public static ResponseEntity<Object> getResponse(CompareInputs inputs) throws ParseException {

        if (inputs.portfolioDoesNotExist())
            return getNotFoundResponseEntity(inputs);
        else
            return getComparisonResponseEntity(inputs);
    }

    private static ResponseEntity<Object> getComparisonResponseEntity(CompareInputs inputs) throws ParseException {
        PortfolioCompareDTO comparison = PortfolioCompareCreation.getComparison(inputs);

        return new ResponseEntity<>(comparison, HttpStatus.OK);
    }

    private static ResponseEntity<Object> getNotFoundResponseEntity(CompareInputs inputs) {
        ResponseEntity<Object> expected;
        int id = inputs.getPortfolioId();
        Date currentDate = inputs.getCurrentDate();

        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND,
                "Portfolio " + id + " could not be found",
                currentDate);
        expected = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

        return expected;
    }
}
