package com.gft.GiFT.projects.addCycleSnap

import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.CycleSnap

class TestInputs {
    static CycleSnap getValidCycleSnap() {
        CycleSnap newCycle = new CycleSnap()
        newCycle.projectId = 12345
        newCycle.cycleSnapName = "1"
        newCycle.startDate = "2016-11-15"
        newCycle.endDate = "2016-11-21"
        newCycle.targetedPoints = 8
        newCycle.achievedPoints = 8
        newCycle.isMoodAvailable = true
        newCycle.moodAverage = 3
        newCycle.isWasteAvailable = true
        newCycle.wasteDays = 5.00
        newCycle.teamCapacity = 100.00

        return newCycle
    }

    static List<CycleSnap> getExistingCycles() {
        CycleSnap cycle1 = new CycleSnap()
        cycle1.cycleSnapName = "1"
        cycle1.startDate = "2016-10-03"
        cycle1.endDate = "2016-10-24"

        CycleSnap cycle2 = new CycleSnap()
        cycle2.cycleSnapName = "2"
        cycle2.startDate = "2016-10-26"
        cycle2.endDate = "2016-11-14"

        List<CycleSnap> existingCycleSnaps = new LinkedList<>()
        existingCycleSnaps << cycle1
        existingCycleSnaps << cycle2

        return existingCycleSnaps
    }

    static getCurrentDate(){
        return new Date(117, 07, 31)
    }
}