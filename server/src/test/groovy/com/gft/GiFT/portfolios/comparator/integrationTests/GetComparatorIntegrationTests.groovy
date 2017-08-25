package com.gft.GiFT.portfolios.comparator.integrationTests

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.portfolios.comparator.Expected
import com.gft.GiFT.portfolios.comparator.businessLogic.response.PortfolioComparatorDTO
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
        ResponseEntity<Object> expected = Expected.getExpectedResponseEntity()

        when:
        ResponseEntity<Object> response = getForEntity("${baseUrl}/portfolios/12345/comparator", PortfolioComparatorDTO.class)

        then:
        response.statusCode == expected.statusCode
        response.body == expected.body
    }
}
