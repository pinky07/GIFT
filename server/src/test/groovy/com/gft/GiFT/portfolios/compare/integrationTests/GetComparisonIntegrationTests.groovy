package com.gft.GiFT.portfolios.compare.integrationTests

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.portfolios.compare.Expected
import com.gft.GiFT.portfolios.compare.businessLogic.response.PortfolioCompareDTO
import org.springframework.http.ResponseEntity
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup

@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/portfolios/compare/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/portfolios/compare/after.sql")
])
class GetComparisonIntegrationTests extends AbstractIntegrationSpecification {

    def "Should get comparison by portfolio Id" () {
        given:
        ResponseEntity<Object> expected = Expected.getExpectedResponseEntity()

        when:
        ResponseEntity<Object> actual = getForEntity("${baseUrl}/portfolios/12345/comparison", PortfolioCompareDTO.class)

        then:
        actual.statusCode == expected.statusCode
        actual.body == expected.body
    }
}