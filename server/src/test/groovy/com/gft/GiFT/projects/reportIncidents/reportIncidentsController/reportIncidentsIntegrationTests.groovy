package com.gft.GiFT.projects.reportIncidents.reportIncidentsController

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.projects.reportIncidents.businessLogic.inputs.IncidentsReport
import org.springframework.http.HttpStatus
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup

@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/projects/reportIncidents/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/projects/reportIncidents/after.sql")
])
class reportIncidentsIntegrationTests extends AbstractIntegrationSpecification{
    def "Create Incidents report"() {
        given:
        def incidentsReport = getNewIncidentsReport()

        when:
        def response = postForEntity("${baseUrl}/projects/incidents", incidentsReport, IncidentsReport.class)

        then:
        response.statusCode == HttpStatus.CREATED
    }

    IncidentsReport getNewIncidentsReport() {
        return new IncidentsReport(
                projectId: 1,
                incidentsDate: "2017-08-31",
                totalIncidents: 3,
                rationale  :"The release caused issues"

        )
    }


}
