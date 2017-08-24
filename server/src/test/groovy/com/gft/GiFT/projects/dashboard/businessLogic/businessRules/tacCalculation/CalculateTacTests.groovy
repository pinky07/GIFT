package com.gft.GiFT.projects.dashboard.businessLogic.businessRules.tacCalculation

import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.TacCalculation
import spock.lang.Specification

class CalculateTacTests extends Specification {

    def "when targeted points is 0"(){
        given:

        int  targetedPoints = 0
        int archievedPoints = 0

        when:
        String tac = TacCalculation.calculateTac(targetedPoints,archievedPoints)

        then:
        tac == "No Data";
    }

    def "when targeted points is not 0"(){
        given:

        int  targetedPoints = 60
        int archievedPoints = 54

        when:
        String tac = TacCalculation.calculateTac(targetedPoints,archievedPoints)

        then:
        tac == "90%"
    }

}
