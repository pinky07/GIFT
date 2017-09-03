package com.gft.GiFT.projects.addCycleSnap.businessLogic.responseCreation

import com.gft.GiFT.projects.addCycleSnap.Expected
import com.gft.GiFT.projects.addCycleSnap.TestInputs
import com.gft.GiFT.projects.addCycleSnap.businessLogic.ResponseCreation
import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.AbstractInputs
import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.CycleSnap
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class GetResponseTests extends Specification {
    ResponseEntity<Object> expected
    AbstractInputs inputs
    ResponseEntity<Object> actual
    CycleSnap newCycle

    def "When valid, returns the correct response"() {
        setup:
        expected = Expected.getSuccessfulResponse()
        inputs = initializeInputs()

        when:
        actual = ResponseCreation.getResponse(inputs)

        then:
        actual == expected
    }

    private AbstractInputs initializeInputs() {
        AbstractInputs inputs = Mock()

        // Initialize user inputs
        newCycle = TestInputs.getValidCycleSnap()
        inputs.newCycleSnap = newCycle

        // Initialize expected responses
        inputs.getExistingCycles(12345) >> TestInputs.getExistingCycles()
        inputs.getCurrentDate() >> TestInputs.getCurrentDate()

        return inputs
    }

    def "When valid, saves the new Cycle Snap"() {
        setup:
        expected = Expected.getSuccessfulResponse()
        inputs = initializeInputs()

        when:
        actual = ResponseCreation.getResponse(inputs)

        then:
        1 * inputs.save(newCycle)
    }

    def "When invalid, returns the correct response"() {
        setup:
        expected = Expected.getErrorResponse()
        inputs = initializeInputs()
        newCycle.startDate = ""

        when:
        actual = ResponseCreation.getResponse(inputs)

        then:
        actual == expected
    }
}