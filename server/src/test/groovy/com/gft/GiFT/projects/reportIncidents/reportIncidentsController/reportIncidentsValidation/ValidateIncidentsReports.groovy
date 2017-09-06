package com.gft.GiFT.projects.reportIncidents.reportIncidentsController.reportIncidentsValidation

import com.gft.GiFT.projects.reportIncidents.businessLogic.inputs.IncidentsReport
import com.gft.GiFT.projects.reportIncidents.businessLogic.inputs.ReportIncidentsValidation
import spock.lang.Specification

class ValidateIncidentsReports  extends Specification {

    IncidentsReport newIncidentsReport
    def setup(){
        newIncidentsReport = createValidReport()
    }
    def createValidReport(){
        IncidentsReport newIncidentsReport= new IncidentsReport()
        newIncidentsReport.projectId = 1
        newIncidentsReport.incidentsDate= "2017-08-31"
        newIncidentsReport.totalIncidents= 3
        newIncidentsReport.rationale= 'The release caused issues'

        return newIncidentsReport
    }
    def "All filed are valid"(){
        when :
        ReportIncidentsValidation.Validation(newIncidentsReport)

        then:
        notThrown IllegalArgumentException
    }
    def "Report date is required"(){
        setup:
        newIncidentsReport.incidentsDate= ""
        when :
        ReportIncidentsValidation.Validation(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }

    def "Report date should be a valid one"(){
        setup:
        newIncidentsReport.incidentsDate= "09-04-2000"

        when :
        ReportIncidentsValidation.isValidDate(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }
    def "Total incidents is required for empty value"(){
        setup:
        newIncidentsReport.totalIncidents

        when :
        ReportIncidentsValidation.isValidDate(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }
    def "Total incidents is required"(){
        setup:

        newIncidentsReport.totalIncidents = 0

        when :
        ReportIncidentsValidation.Validation(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }

    def "Total incidents min is 1"(){
        setup:

        newIncidentsReport.totalIncidents = 0

        when :
        ReportIncidentsValidation.Validation(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }
    def "Total incidents of 1 is valid "(){
        setup:

        newIncidentsReport.totalIncidents = 1

        when :
        ReportIncidentsValidation.Validation(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }
    def "Total incidents max is 100 "(){
        setup:

        newIncidentsReport.totalIncidents = 101

        when :
        ReportIncidentsValidation.Validation(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }
    def "Total incidents of 100 is valid"(){
        setup:

        newIncidentsReport.totalIncidents = 100

        when :
        ReportIncidentsValidation.Validation(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }
    def " Rationale is required"(){
        setup:

        newIncidentsReport.rationale =""

        when :
        ReportIncidentsValidation.Validation(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }
    def " A rationale with whitespaces is not valid"(){
        setup:

        newIncidentsReport.rationale ="   "

        when :
        ReportIncidentsValidation.Validation(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }
    def " Rationale has a max length of 1000 characters"(){
        setup:

        newIncidentsReport.rationale ="123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901\"123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901\"123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901\"123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901\"123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901\"qq\"  "

        when :
        ReportIncidentsValidation.Validation(newIncidentsReport)

        then:
        thrown IllegalArgumentException
    }
}
