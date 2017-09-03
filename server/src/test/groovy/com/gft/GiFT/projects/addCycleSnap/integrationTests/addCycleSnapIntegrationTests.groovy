package com.gft.GiFT.projects.addCycleSnap.integrationTests

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.projects.addCycleSnap.TestInputs
import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup

@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/projects/addCycleSnap/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/projects/addCycleSnap/after.sql")
])
class addCycleSnapIntegrationTests extends AbstractIntegrationSpecification {
    def "Adds a cycle snap successfully"() {
        given:
        def cycleSnap = TestInputs.getValidCycleSnap()

        when:
        ResponseEntity<CycleSnap> response = postForEntity("${baseUrl}/projects/cyclesnaps", cycleSnap, CycleSnap.class)

        then:
        response.statusCode == HttpStatus.CREATED
        response.body.projectId != 0
    }
}