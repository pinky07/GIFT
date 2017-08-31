package com.gft.GiFT.portfolios.compare.businessLogic.lastSnapCreation

import com.gft.GiFT.portfolios.compare.Expected
import com.gft.GiFT.portfolios.compare.businessLogic.response.*
import com.gft.GiFT.portfolios.compare.businessLogic.*
import spock.lang.Specification

class GetLastSnapForProjectWithSnapTests extends Specification {

    def "Should get last snap from an existing Last Cycle Snap" () {
        given:
        LastSnapDTO expected = Expected.getExpectedLastSnapWithSnaps()

        def project  = Inputs.projectWithSnaps
        def lastCycle = Inputs.getLatestCycleSnap()
        def releaseDates = Inputs.getReleaseDates()
        def firstCycleStartDate = Inputs.getFirstCycleStartDate()
        def reports = project.getIncidentsAsBusinessObjects()

        when:
        LastSnapDTO actual = LastSnapCreation.getLastSnapForProjectWithSnap(project.id, project.name, lastCycle, firstCycleStartDate, releaseDates, reports)

        then:
        actual == expected
    }
}