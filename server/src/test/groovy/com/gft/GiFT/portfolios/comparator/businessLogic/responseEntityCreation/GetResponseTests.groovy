package com.gft.GiFT.portfolios.comparator.businessLogic.responseEntityCreation

import com.gft.GiFT.portfolios.comparator.Expected
import com.gft.GiFT.portfolios.comparator.businessLogic.Inputs
import com.gft.GiFT.portfolios.comparator.businessLogic.ResponseEntityCreation
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class GetResponseTests extends Specification {

    def "Should get response for existing portfolio given an existing portfolio" () {
        given:
        ResponseEntity<Object> expected = Expected.getExpectedResponseEntity()

        def inputs = Inputs.comparatorInputs
        when:

        ResponseEntity<Object> actual = ResponseEntityCreation.getResponse(inputs)

        then:
        actual == expected
    }
}