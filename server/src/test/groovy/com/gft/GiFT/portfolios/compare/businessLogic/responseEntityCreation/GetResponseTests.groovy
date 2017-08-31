package com.gft.GiFT.portfolios.compare.businessLogic.responseEntityCreation

import com.gft.GiFT.portfolios.compare.Expected
import com.gft.GiFT.portfolios.compare.businessLogic.Inputs
import com.gft.GiFT.portfolios.compare.businessLogic.ResponseEntityCreation
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class GetResponseTests extends Specification {

    def "Should get response for existing portfolio given an existing portfolio" () {
        given:
        ResponseEntity<Object> expected = Expected.getExpectedResponseEntity()
        def inputs = Inputs.comparisonInputs

        when:
        ResponseEntity<Object> actual = ResponseEntityCreation.getResponse(inputs)

        then:
        actual == expected
    }

    def "Should get response for non existing portfolio" () {
        given:
        Date currentDate = new Date(117, 07, 31)
        ResponseEntity<Object> expected = Expected.getExpectedResponseEntityWhenPortfolioDoesNotExist(currentDate)
        def inputs = Inputs.getComparisonInputsWhenPortfolioDoesNotExist(currentDate)

        when:
        ResponseEntity<Object> actual = ResponseEntityCreation.getResponse(inputs)

        then:
        actual == expected
    }
}