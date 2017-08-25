package com.gft.GiFT.portfolios.comparator.businessLogic.inputs.project

import com.gft.GiFT.portfolios.comparator.businessLogic.inputs.*
import spock.lang.Specification

class GetLastSnapTests extends Specification {

    Project project
    CycleSnap expected
    CycleSnap actual

    def setup() {
        Set<CycleSnap> cycleSnaps = createExistingCycles()
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

        Set<CycleSnap> existingCycleSnaps = new HashSet<CycleSnap>()
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
