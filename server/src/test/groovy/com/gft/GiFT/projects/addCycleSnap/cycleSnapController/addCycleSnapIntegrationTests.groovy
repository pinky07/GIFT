package com.gft.GiFT.projects.addCycleSnap.cycleSnapController

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.CycleSnap
import org.springframework.http.HttpStatus
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup

@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/projects/addCycleSnap/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/projects/addCycleSnap/after.sql")
])
class addCycleSnapIntegrationTests extends AbstractIntegrationSpecification {
    def "Create Cycle Snap"() {
        given:
        def cycleSnap = getNewCycleSnap()

        when:
        def response = postForEntity("${baseUrl}/projects/cyclesnaps", cycleSnap, CycleSnap.class)

        then:
        response.statusCode == HttpStatus.CREATED
    }

    CycleSnap getNewCycleSnap() {
        return new CycleSnap(
                projectId: 12345,
                cycleSnapName: "Drop 3",
                startDate: "2017-07-31",
                endDate: "2017-08-04",
                targetedPoints: 8,
                achievedPoints: 8,
                moodAverage:3,
                isMoodAvailable: true,
                isWasteAvailable: true,
                wasteDays:5.00,
                teamCapacity:100.00
        )
    }

    def "Should get a 400 when the startDate is empty" () {
        given:
        def cycleSnap = new CycleSnap(
                projectId: 12345,
                cycleSnapName: "Drop 3",
                startDate: "",
                endDate: "2017-08-04",
                targetedPoints: 8,
                achievedPoints: 8,
                moodAverage:3,
                isMoodAvailable: true,
                isWasteAvailable: true,
                wasteDays:5.00,
                teamCapacity:100.00
        )

        when:
        def response = postForEntity("${baseUrl}/projects/cyclesnaps", cycleSnap, CycleSnap.class)

        then:
        response.statusCode == HttpStatus.BAD_REQUEST
    }
}
