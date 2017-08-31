package com.gft.GiFT.portfolios.compare.businessLogic.inputs.project

import com.gft.GiFT.portfolios.compare.businessLogic.inputs.CycleSnap
import com.gft.GiFT.portfolios.compare.businessLogic.inputs.Project
import spock.lang.Specification

class GetLastSnapTests extends Specification {

    Project project
    CycleSnap expected
    CycleSnap actual

    def setup() {
        List<CycleSnap> cycleSnaps = createExistingCycles()
        project = new Project()
        project.cycleSnapSet = cycleSnaps
    }

    def createExistingCycles() {
        CycleSnap cycle1 = new CycleSnap()
        cycle1.cycleSnapName = "1"
        cycle1.endDate = "2016-10-24"

        expected = new CycleSnap()
        expected.cycleSnapName = "2"
        expected.endDate = "2016-11-14"

        List<CycleSnap> existingCycleSnaps = new LinkedList<>()
        existingCycleSnaps.add(cycle1)
        existingCycleSnaps.add(expected)

        return existingCycleSnaps
    }

    def "Gets the latest cycle snap by end date"() {
        when:
        actual = project.getLastSnap()

        then:
        actual == expected
    }

    def "Get null when no snaps are present"() {
        when:
        actual = new Project().getLastSnap()

        then:
        actual == null
    }
}
