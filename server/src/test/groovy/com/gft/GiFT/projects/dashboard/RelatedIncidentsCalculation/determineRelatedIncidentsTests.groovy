package com.gft.GiFT.projects.dashboard.RelatedIncidentsCalculation

import com.gft.GiFT.projects.dashboard.IncidentsReport
import com.gft.GiFT.projects.dashboard.RelatedIncidentsCalculation
import spock.lang.Specification

class determineRelatedIncidentsTests extends Specification {

    def releaseDates

    def setup(){
        releaseDates = new LinkedList()
        releaseDates.add("2017-02-07")
        releaseDates.add("2017-03-02")

//        incidentsReports   = new LinkedList()
//        //IncidentsReport incidentsreport = new IncidentsReport();
//        //incidentsReports.add(new IncidentsReport())
//        incidentsReports.add(2);
//        incidentsReports.add(3);

    }

    def "There are no releases"() {
        given:
        def cycleEndDate = "2017-01-30"
        incidentsReports ="";
        releaseDates=""

        when:
        def days = RelatedIncidentsCalculation.determineRelatedIncidents(incidentsReports,cycleEndDate, releaseDates)

        then:
        days == 'No releases yet'
    }

    def "There are some releases"() {
        incidentsReports   = new LinkedList();
        incidentsReports.add(2);
        incidentsReports.add(3);

        given:
        def cycleEndDate = "2017-02-14"
        releaseDates ="2017-02-07"
        incidentsReports

        when:
        def days = RelatedIncidentsCalculation.determineRelatedIncidents(incidentsReports,cycleEndDate, releaseDates)

        then:
        days == '5'
    }


}
