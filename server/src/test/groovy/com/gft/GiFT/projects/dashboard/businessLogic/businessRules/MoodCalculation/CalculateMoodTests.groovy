package com.gft.GiFT.projects.dashboard.businessLogic.businessRules.MoodCalculation

import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.MoodCalculation
import spock.lang.Specification

class CalculateMoodTests extends Specification {

    boolean isMoodAvailable
    double moodAverage
    String howIsMood

    def "Is there any mood available"() {
        given:

        moodAverage = 3
        isMoodAvailable = true

        when:
        howIsMood = MoodCalculation.calculateMood(isMoodAvailable,moodAverage)

        then:
        howIsMood == "3.00"
    }

    def "Mood can have two decimals"() {
        given:

        moodAverage = 2.5
        isMoodAvailable = true

        when:
        howIsMood = MoodCalculation.calculateMood(isMoodAvailable, moodAverage)

        then:
        howIsMood == "2.50"
    }

    def "Mood can have two decimals only"() {
        given:

        moodAverage = 2.599
        isMoodAvailable = true

        when:
        howIsMood = MoodCalculation.calculateMood(isMoodAvailable, moodAverage)

        then:
        howIsMood == "2.60"
    }

    def "A cycle snap may have no reported mood data"() {
        given:

        isMoodAvailable = false

        when:
        howIsMood = MoodCalculation.calculateMood(isMoodAvailable, moodAverage)

        then:
        howIsMood == "No data"
    }
}
