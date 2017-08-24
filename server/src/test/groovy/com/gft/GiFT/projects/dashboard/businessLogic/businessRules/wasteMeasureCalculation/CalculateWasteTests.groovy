package com.gft.GiFT.projects.dashboard.businessLogic.businessRules.wasteMeasureCalculation

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

    def "Should show only 1 rounded decimal"() {
        given:
        teamCapacity = 99
        wasteDays = 5.67
        isWasteAvailable = true

        when:
        wastePercentage = WasteMeasureCalculation.calculateWaste(teamCapacity, wasteDays, isWasteAvailable)

        then:
        wastePercentage == "5.7%"
    }

    def "Should allow two digits for the waste percentage"() {
        given:
        teamCapacity = 99
        wasteDays = 17.67
        isWasteAvailable = true

        when:
        wastePercentage = WasteMeasureCalculation.calculateWaste(teamCapacity, wasteDays, isWasteAvailable)

        then:
        wastePercentage == "17.8%"
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
