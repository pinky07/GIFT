package com.gft.GiFT.projects.dashboard.businessLogic.businessRules.daysSinceLastReleaseCalculation

import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.DaysSinceLastReleaseCalculation
import spock.lang.Specification

class DetermineDaysTests extends Specification {

    List<String> releaseDates
    Date firstCycleStartDate

    def setup(){
        releaseDates = new LinkedList()
        releaseDates.add("2017-04-02")
        releaseDates.add("2017-03-02")
        releaseDates.add("2017-02-07")

        firstCycleStartDate = new Date(117,0,25)
    }

    def "There are no releases"() {
        given:
        def cycleSnapEndDate = "2017-01-30"

        when:
        def days = DaysSinceLastReleaseCalculation.determineDays(firstCycleStartDate, cycleSnapEndDate, releaseDates)

        then:
        days == '5'
    }

    def "There is a release before"() {
        given:
        def cycleSnapEndDate = "2017-02-14"

        when:
        def days = DaysSinceLastReleaseCalculation.determineDays(firstCycleStartDate, cycleSnapEndDate, releaseDates)

        then:
        days == '7'
    }

    def "There are two releases before" () {
        given:
        def cycleSnapEndDate = "2017-03-15"

        when:
        def days = DaysSinceLastReleaseCalculation.determineDays(firstCycleStartDate, cycleSnapEndDate, releaseDates)

        then:
        days == '13'
    }
}
