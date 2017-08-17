package com.gft.GiFT.projects.dashboard.businessLogic.businessRules.WasteMeasureCalculation

import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.WasteMeasureCalculation
import spock.lang.Specification

class CalculateWasteTests extends Specification {

    double teamCapacity
    double wasteDays
    boolean isWasteAvailable
    String wastePercentage

    def "Should show the percentage"() {
        given:
        teamCapacity = 100
        wasteDays = 5
        isWasteAvailable = true

        when:
        wastePercentage = WasteMeasureCalculation.calculateWaste(teamCapacity, wasteDays, isWasteAvailable)

        then:
        wastePercentage == "5.0%"
    }

    def "Should show only 2 rounded decimals"() {
        given:
        teamCapacity = 99
        wasteDays = 5.67
        isWasteAvailable = true

        when:
        wastePercentage = WasteMeasureCalculation.calculateWaste(teamCapacity, wasteDays, isWasteAvailable)

        then:
        wastePercentage == "5.73%"
    }

    def "Should allow 0% waste"() {
        given:
        teamCapacity = 99
        wasteDays = 0
        isWasteAvailable = true

        when:
        wastePercentage = WasteMeasureCalculation.calculateWaste(teamCapacity, wasteDays, isWasteAvailable)

        then:
        wastePercentage == "0.0%"
    }

    def "A cycle snap may have no reported waste data"() {
        given:
        teamCapacity = 0
        wasteDays = 0
        isWasteAvailable = false

        when:
        wastePercentage = WasteMeasureCalculation.calculateWaste(teamCapacity, wasteDays, isWasteAvailable)

        then:
        wastePercentage == "No data"
    }
}
