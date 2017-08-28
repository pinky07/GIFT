package com.gft.GiFT.portfolios.comparator.businessLogic.lastSnapCreation

import com.gft.GiFT.portfolios.comparator.Expected
import com.gft.GiFT.portfolios.comparator.businessLogic.*
import com.gft.GiFT.portfolios.comparator.businessLogic.inputs.*
import com.gft.GiFT.portfolios.comparator.businessLogic.response.*
import spock.lang.Specification

class GetLastSnapTests extends Specification {

    def "Should get last snap from an existing Last Cycle Snap" () {
        given:
        LastSnapDTO expected = Expected.getExpectedLastSnapWithSnaps()

        def project = Inputs.projectWithSnaps
        def lastCycle = Inputs.getLatestCycleSnap()

        when:
        LastSnapDTO actual = LastSnapCreation.getLastSnap(project.id, project.name, lastCycle)

        then:
        actual == expected
    }

    def "Should get last snap from a project with no Last Cycle Snap" () {
        given:
        LastSnapDTO expected = Expected.getExpectedLastSnapWithoutSnaps()
        def project = Inputs.projectWithoutSnaps
        when:
        LastSnapDTO actual = LastSnapCreation.getLastSnap(project.id, project.name, null)

        then:
        actual == expected
    }
}