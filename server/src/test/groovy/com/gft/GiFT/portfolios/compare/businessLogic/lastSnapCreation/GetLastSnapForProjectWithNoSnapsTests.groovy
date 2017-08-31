package com.gft.GiFT.portfolios.compare.businessLogic.lastSnapCreation

import com.gft.GiFT.portfolios.compare.Expected
import com.gft.GiFT.portfolios.compare.businessLogic.Inputs
import com.gft.GiFT.portfolios.compare.businessLogic.LastSnapCreation
import com.gft.GiFT.portfolios.compare.businessLogic.response.LastSnapDTO
import spock.lang.Specification

class GetLastSnapForProjectWithNoSnapsTests extends Specification {

    def "Should get last snap from a project with no snaps" () {
        given:
        LastSnapDTO expected = Expected.getExpectedLastSnapWithoutSnaps()
        def project = Inputs.projectWithoutSnaps
        when:
        LastSnapDTO actual = LastSnapCreation.getLastSnapForProjectWithNoSnaps(project.id, project.name)

        then:
        actual == expected
    }
}