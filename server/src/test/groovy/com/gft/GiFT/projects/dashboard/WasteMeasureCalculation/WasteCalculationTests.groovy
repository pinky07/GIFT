package com.gft.GiFT.projects.dashboard.WasteMeasureCalculation

import com.gft.GiFT.projects.cycleSnapsAdd.WasteMeasure
import spock.lang.Specification

class WasteCalculationTests extends Specification  {

    def "Should show the percentage"(){
        given:
        int teamCapacity=100;
        int wasteDays=5;
        boolean isWasteAvailable = true;

        when:
        String wastePercentage = WasteMeasure.calculateWaste(teamCapacity,wasteDays,isWasteAvailable)

        then:
        wastePercentage == "5.0%";
    }
    def "Should show only 2 rounded decimals"(){
        given:
        int teamCapacity=99;
        int wasteDays=5.67;
        boolean wasteIndicator = true;

        when:
        String wastePercentage = WasteMeasure.calculateWaste(teamCapacity,wasteDays,wasteIndicator)

        then:
        wastePercentage == "5.05%";
    }

    def "Should allow 0% waste"(){
        given:
        int teamCapacity=99;
        int wasteDays=0;
        boolean wasteIndicator = true;

        when:
        String wastePercentage = WasteMeasure.calculateWaste(teamCapacity,wasteDays,wasteIndicator)

        then:
        wastePercentage == "0.0%";
    }
    def "A cycle snap may have no reported waste data"(){
        given:
        int teamCapacity=0;
        int wasteDays=0;
        def wasteIndicator = false;

        when:
        String wastePercentage = WasteMeasure.calculateWaste(teamCapacity,wasteDays,wasteIndicator)

        then:
        wastePercentage == "No data";
    }
}
