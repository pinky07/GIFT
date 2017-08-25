package com.gft.GiFT.portfolio.comparator.integrationTests

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.portfolios.comparator.businessLogic.response.LastSnapDTO
import com.gft.GiFT.portfolios.comparator.businessLogic.response.PortfolioComparatorDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup

@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/portfolios/comparator/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/portfolios/comparator/after.sql")
])
class GetComparatorIntegrationTests extends AbstractIntegrationSpecification {

    def "Should get comparator by portfolio Id" () {
        given:
        ResponseEntity<Object> expected = getExpected()

        when:
        ResponseEntity<Object> response = getForEntity("${baseUrl}/portfolios/12345/comparator", PortfolioComparatorDTO.class)

        then:
        response.statusCode == expected.statusCode
        response.body == expected.body
    }

    private ResponseEntity<Object> getExpected() {
        ResponseEntity<Object> expected
        LastSnapDTO exceptionalProject = new LastSnapDTO()
        exceptionalProject.setProjectName("Exceptional project")
        exceptionalProject.setTac("100%")
        exceptionalProject.setDaysWithoutRelease("13")
        exceptionalProject.setRelatedIncidents("6")
        exceptionalProject.setWaste("No data")
        exceptionalProject.setMood("No data")

        LastSnapDTO appraisalTool = new LastSnapDTO()
        appraisalTool.setProjectName("No data")
        appraisalTool.setTac("No data")
        appraisalTool.setDaysWithoutRelease("No data")
        appraisalTool.setRelatedIncidents("No data")
        appraisalTool.setWaste("No data")
        appraisalTool.setMood("No data")

        PortfolioComparatorDTO comparator = new PortfolioComparatorDTO()
        comparator.setPortfolioName("Amazing projects")
        comparator.addSnap(exceptionalProject)
        comparator.addSnap(appraisalTool)

        expected = new ResponseEntity<>(comparator, HttpStatus.OK)
        expected
    }
}
