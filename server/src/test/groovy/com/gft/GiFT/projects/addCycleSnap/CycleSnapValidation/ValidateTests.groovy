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
        newCycle.moodAverage = 3
        newCycle.isMoodAvailable = true
        newCycle.isWasteAvailable= true
        newCycle.wasteDays=5.00
        newCycle.teamCapacity=100.00


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


    def "Two Decimals for Mood points are allowed for Mood column"() {
        given:
        newCycle.moodAverage = 1.56
        newCycle.isMoodAvailable = true

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        notThrown IllegalArgumentException
    }

    def "Mood points are not required if Mood data is not available for Mood column"() {
        given:
        newCycle.isMoodAvailable = false
        newCycle.moodAverage = 0


        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        notThrown IllegalArgumentException
    }
    def "Min number for Mood points is 1  for Mood column"() {
        given:
        newCycle.moodAverage = 0.99
        newCycle.isMoodAvailable = true

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }

    def "Mood points max is 3 for Mood column"() {
        given:
        newCycle.moodAverage = 3.01
        newCycle.isMoodAvailable = true

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "Two Decimals for waste days are allowed"() {
        given:
        newCycle.isWasteAvailable= true
        newCycle.wasteDays=2.59
        newCycle.teamCapacity=100.00
        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        notThrown IllegalArgumentException
    }
    def "Two Decimals for waste capacity are allowed"() {
        given:
        newCycle.isWasteAvailable= true
        newCycle.wasteDays=5.00
        newCycle.teamCapacity=95.89
        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        notThrown IllegalArgumentException
    }
//
    def "team capacity and waste days are not required if waste data is not available"() {
        given:
        newCycle.isWasteAvailable= false
        newCycle.wasteDays
        newCycle.teamCapacity
        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        notThrown IllegalArgumentException
    }



    def "team capacity min is 1"() {
        given:
        newCycle.isWasteAvailable= true
        newCycle.teamCapacity=0.99
        newCycle.wasteDays=5.00
        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "team capacity max is   10,000 "() {
        given:
        newCycle.isWasteAvailable= true
        newCycle.teamCapacity=10000.01
        newCycle.wasteDays=5.00
        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
    def "waste days min is 0 "() {
        given:
        newCycle.isWasteAvailable= true
        newCycle.teamCapacity= 100.00
        newCycle.wasteDays= -0.01

        when:
        CycleSnapValidation.validate(newCycle, existingCycleSnaps)

        then:
        thrown IllegalArgumentException
    }
}
