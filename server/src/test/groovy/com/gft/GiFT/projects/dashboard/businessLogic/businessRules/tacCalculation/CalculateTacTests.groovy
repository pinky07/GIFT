package com.gft.GiFT.projects.dashboard.businessLogic.businessRules.tacCalculation

import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.TacCalculation
import spock.lang.Specification

class CalculateTacTests extends Specification {

    int targetedPoints
    int achievedPoints
    String tac

    def "when targeted points is 0"() {
        given:

        targetedPoints = 0
        achievedPoints = 0

        when:
        tac = TacCalculation.calculateTac(targetedPoints, achievedPoints)

        then:
        tac == "No Data"
    }

    def "when targeted points is not 0"() {
        given:
        targetedPoints = 60
        achievedPoints = 54

        when:
        String tac = TacCalculation.calculateTac(targetedPoints, achievedPoints)

        then:
        tac == "90%"
    }
}