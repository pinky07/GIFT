package com.gft.GiFT.projects.cycleSnapsAdd.CycleSnapController

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.entities.CycleSnap
import org.springframework.http.HttpStatus
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup

@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/projects/cycleSnapsAdd/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/projects/cycleSnapsAdd/after.sql")
])
class createCycleSnapIntegrationTests extends AbstractIntegrationSpecification {
    def "Create Cycle Snap"() {
        given:
        def cycleSnap = new CycleSnap(
                projectId: 99999,
                cycleSnapName: "Drop 3",
                startDate: "2017-07-31",
                endDate: "2017-08-04",
                targetedPoints: 8,
                achievedPoints: 8
        )

        when:
        def response = postForEntity("${baseUrl}/projects/cyclesnaps", cycleSnap, CycleSnap.class)

        then:
        response.statusCode == HttpStatus.CREATED
    }

    def "Should get a 400 when the startDate is empty" () {
        given:
        def cycleSnap = new CycleSnap(
                projectId: 99999,
                cycleSnapName: "Drop 3",
                startDate: "",
                endDate: "2017-08-04",
                targetedPoints: 8,
                achievedPoints: 8
        )

        when:
        def response = postForEntity("${baseUrl}/projects/cyclesnaps", cycleSnap, CycleSnap.class)

        then:
        response.statusCode == HttpStatus.BAD_REQUEST
    }
}
