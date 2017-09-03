package com.gft.GiFT.portfolios.compare.businessLogic.lastSnapCreation

import com.gft.GiFT.portfolios.compare.Expected
import com.gft.GiFT.portfolios.compare.businessLogic.response.*
import com.gft.GiFT.portfolios.compare.businessLogic.*
import spock.lang.Specification

class GetLastSnapForProjectWithSnapTests extends Specification {

    def "Should get last snap from an existing Last Cycle Snap" () {
        given:
        LastSnapDTO expected = Expected.getExpectedLastSnapWithSnaps()

        def project  = TestInputs.projectWithSnaps
        def lastCycle = TestInputs.getLatestCycleSnap()
        def releaseDates = TestInputs.getReleaseDates()
        def firstCycleStartDate = TestInputs.getFirstCycleStartDate()
        def reports = project.getIncidentsAsBusinessObjects()

        when:
        LastSnapDTO actual = LastSnapCreation.getLastSnapForProjectWithSnap(project.id, project.name, lastCycle, firstCycleStartDate, releaseDates, reports)

        then:
        actual == expected
    }
}