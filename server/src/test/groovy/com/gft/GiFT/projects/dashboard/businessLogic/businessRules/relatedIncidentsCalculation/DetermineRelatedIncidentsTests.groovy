package com.gft.GiFT.projects.dashboard.businessLogic.businessRules.relatedIncidentsCalculation

import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.*
import spock.lang.Specification

class DetermineRelatedIncidentsTests extends Specification {

    List<IncidentReportBO> incidentReports
    List<String> releaseDates
    String cycleEndDate

    def setup(){
        incidentReports = new LinkedList()
        incidentReports.add(new IncidentReportBO("2017-02-07", 2))
        incidentReports.add(new IncidentReportBO("2017-02-09", 3))
        incidentReports.add(new IncidentReportBO("2017-02-21", 1))
        incidentReports.add(new IncidentReportBO("2017-03-02", 4))
        incidentReports.add(new IncidentReportBO("2017-03-02", 1))
        incidentReports.add(new IncidentReportBO("2017-03-14", 1))
        incidentReports.add(new IncidentReportBO("2017-03-16", 1))

        releaseDates = new LinkedList()
        releaseDates.add("2017-02-07")
        releaseDates.add("2017-03-02")
    }

    def "There are no releases yet before the current cycle end date"() {
        given:
        cycleEndDate = "2017-01-30"

        when:
        def days = RelatedIncidentsCalculation.determineRelatedIncidents(incidentReports, cycleEndDate, releaseDates)

        then:
        days == 'No releases yet'
    }

    def "There is one release before and a report is the same as the release date"() {
        given:
        cycleEndDate = "2017-02-14"

        when:
        def days = RelatedIncidentsCalculation.determineRelatedIncidents(incidentReports, cycleEndDate, releaseDates)

        then:
        days == '5'
    }

    def "There is one release before and should accumulate reports"() {
        given:
        cycleEndDate = "2017-02-28"

        when:
        def days = RelatedIncidentsCalculation.determineRelatedIncidents(incidentReports, cycleEndDate, releaseDates)

        then:
        days == '6'
    }

    def "There are two releases before and should accumulate reports for the most recent one only"() {
        given:
        cycleEndDate = "2017-03-15"

        when:
        def days = RelatedIncidentsCalculation.determineRelatedIncidents(incidentReports, cycleEndDate, releaseDates)

        then:
        days == '6'
    }

    def "Dashboard shows No data if there are no production incidents"() {
        given:
        cycleEndDate = "2017-02-14"
        incidentReports = new LinkedList()

        when:
        def days = RelatedIncidentsCalculation.determineRelatedIncidents(incidentReports, cycleEndDate, releaseDates)

        then:
        days == 'No reports available'
    }
}
