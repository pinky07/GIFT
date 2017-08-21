package com.gft.GiFT.projects.addCycleSnap.CycleSnapValidation

import com.gft.GiFT.projects.addCycleSnap.businessLogic.CycleSnap
import com.gft.GiFT.projects.addCycleSnap.businessLogic.CycleSnapValidation
import spock.lang.Specification

class ValidateTests extends Specification {

    CycleSnap newCycle
    Set<CycleSnap> existingCycleSnaps
    def setup() {
        newCycle = createValidCycle()
        existingCycleSnaps = createExistingCycles()
    }

    def createValidCycle(){
        CycleSnap newCycle = new CycleSnap()
        newCycle.cycleSnapName = "1"
        newCycle.startDate = "2016-11-15"
        newCycle.endDate = "2016-11-21"
        newCycle.targetedPoints = 8
        newCycle.achievedPoints = 8

        return newCycle
    }
    def createExistingCycles(){
        CycleSnap cycle1 = new CycleSnap()
        cycle1.cycleSnapName = "1"
        cycle1.startDate = "2016-10-03"
        cycle1.endDate = "2016-10-24"

        CycleSnap cycle2 = new CycleSnap()
        cycle2.cycleSnapName = "2"
        cycle2.startDate = "2016-10-26"
        cycle2.endDate = "2016-11-14"

        Set<CycleSnap> existingCycleSnaps = new HashSet<CycleSnap>()
        existingCycleSnaps.add(cycle1)
        existingCycleSnaps.add(cycle2)

        return existingCycleSnaps
    }

    def "All fields are valid"() {
        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        notThrown IllegalArgumentException
    }
    def "Cycle name is required"() {
        setup:
        newCycle.cycleSnapName = ""

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "Cycle name can be any text"() {
        setup:
        newCycle.cycleSnapName = "Drop 1"

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        notThrown IllegalArgumentException
    }
    def "Cycle name has a max of 200 characters"() {
        setup:
        newCycle.cycleSnapName = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901"

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "Start Date is required"() {
        setup:
        newCycle.startDate = ""

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "End Date is required"() {
        setup:
        newCycle.endDate = ""

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "Start Date should precede End Date"() {
        given:
        newCycle.endDate = "2016-11-14"

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "Zero points are allowed for Targeted Points"() {
        given:
        newCycle.targetedPoints = 0

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        notThrown IllegalArgumentException
    }
    def "Zero points are allowed for Achieved Points"() {
        given:
        newCycle.achievedPoints = 0

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        notThrown IllegalArgumentException
    }
    def "Min number for Targeted Points is 0"() {
        given:
        newCycle.targetedPoints = -1

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "Min number for Achieved Points is 0"() {
        given:
        newCycle.achievedPoints = -1

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "Max number for Targeted Points is 10000"() {
        given:
        newCycle.targetedPoints = 10001

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "Max number for Achieved Points is 10000"() {
        given:
        newCycle.achievedPoints = 10001

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }

    def "New cycle dates shouldn't overlap with existing ones - Start Date overlaps an existing cycle"() {
        given:
        newCycle.startDate = "2016-11-12"
        newCycle.endDate = "2016-11-21"

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "New cycle dates shouldn't overlap with existing ones - End Date overlaps an existing cycle"() {
        given:
        newCycle.startDate = "2016-09-21"
        newCycle.endDate = "2016-10-05"

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "New cycle dates shouldn't overlap with existing ones - Range contains an existing cycle"() {
        given:
        newCycle.startDate = "2016-10-02"
        newCycle.endDate = "2016-10-25"

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
}