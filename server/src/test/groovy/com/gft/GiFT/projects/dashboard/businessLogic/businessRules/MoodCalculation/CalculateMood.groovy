package com.gft.GiFT.projects.dashboard.businessLogic.businessRules.MoodCalculation

import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.MoodCalculation
import spock.lang.Specification

class CalculateMoodTests extends Specification {

    boolean isMoodAvailabel
    double moodAvearge
    String howIsMood

    def "Is there any mood availabele"() {
        given:

        moodAvearge = 3.0
        isMoodAvailabel = true

        when:
        howIsMood = MoodCalculation.MoodCalculate(isMoodAvailabel,moodAvearge)

        then:
        howIsMood == "3.0"
    }

    def "Mood can have one decimal"() {
        given:

        moodAvearge = 2.5
        isMoodAvailabel = true

        when:
        howIsMood = MoodCalculation.MoodCalculate(isMoodAvailabel, moodAvearge)

        then:
        howIsMood == "2.5"
    }

    def "A cycle snap may have no reported mood data"() {
        given:

        moodAvearge = 0
        isMoodAvailabel = false

        when:
        howIsMood = MoodCalculation.MoodCalculate(isMoodAvailabel, moodAvearge)

        then:
        howIsMood == "No data"
    }
}
