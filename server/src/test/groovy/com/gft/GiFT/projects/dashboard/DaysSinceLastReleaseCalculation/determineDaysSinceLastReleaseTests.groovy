package com.gft.GiFT.projects.dashboard.DaysSinceLastReleaseCalculation

import com.gft.GiFT.projects.dashboard.businessLogic.DaysSinceLastReleaseCalculation
import spock.lang.Specification

class determineDaysSinceLastReleaseTests extends Specification {

    def releaseDates

    def setup(){
        releaseDates = new LinkedList()
        releaseDates.add("2017-02-07")
        releaseDates.add("2017-03-02")
        releaseDates.add("2017-04-02")
    }

    def "There are no releases"() {
        given:
        def cycleSnapEndDate = "2017-01-30"

        when:
        def days = DaysSinceLastReleaseCalculation.determineDaysSinceLastRelease(cycleSnapEndDate, releaseDates)

        then:
        days == 'No releases yet'
    }

    def "There is a release before"() {
        given:
        def cycleSnapEndDate = "2017-02-14"

        when:
        def days = DaysSinceLastReleaseCalculation.determineDaysSinceLastRelease(cycleSnapEndDate, releaseDates)

        then:
        days == '7'
    }

    def "There are two releases before" () {
        given:
        def cycleSnapEndDate = "2017-03-15"

        when:
        def days = DaysSinceLastReleaseCalculation.determineDaysSinceLastRelease(cycleSnapEndDate, releaseDates)

        then:
        days == '13'
    }
}
