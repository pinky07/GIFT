package com.gft.GiFT.projects.dashboard.DashboardController

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.projects.dashboard.businessLogic.CycleSnapDTO
import com.gft.GiFT.projects.dashboard.businessLogic.ProjectDTO
import org.springframework.http.HttpStatus
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup

@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/projects/dashboard/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/projects/dashboard/after.sql")
])
class FindDashboardByProjectIdIntegrationTests extends AbstractIntegrationSpecification {

    def cycleSnapDTO2 = new CycleSnapDTO(
            cycleSnapName: "Sprint #3",
            startDate: '2017-02-18',
            endDate: '2017-02-28',
            targetedPoints: 70,
            achievedPoints: 68,
            daysSinceLastRelease: '21',
            tac: "97%",
            relatedIncidents: '5',
            lastReleaseName: 'First Version',
            lastReleaseDate: '2017-02-07',
            teamCapacity: 99.0,
            wasteDays: 0.0,
            wastePercentage: '0.0%',
            mood: '2.50'
    )

    def cycleSnapDTO3 = new CycleSnapDTO(
            cycleSnapName: "Sprint #4",
            startDate: '2017-03-01',
            endDate: '2017-03-15',
            targetedPoints: 100,
            achievedPoints: 100,
            daysSinceLastRelease: '13',
            tac: "100%",
            relatedIncidents: 'No reports available',
            lastReleaseName: 'Second Update',
            lastReleaseDate: '2017-03-02',
            teamCapacity: 0.0,
            wasteDays: 0.0,
            wastePercentage: 'No data',
            mood: 'No data'
    )

    def "Should get a 404 when the projectId does not exist" () {
        when:
        def response = getForEntity("${baseUrl}/projects/999/dashboard", ProjectDTO.class)

        then:
        response.statusCode == HttpStatus.NOT_FOUND
    }

    def "Should get dashboard by project Id with Days since last release" () {
        given:
        Set<CycleSnapDTO> newCycleSnapDTOSet = new HashSet<CycleSnapDTO>()
        newCycleSnapDTOSet.add(cycleSnapDTO3)
        newCycleSnapDTOSet.add(cycleSnapDTO2)

        def expectedProject = new ProjectDTO (
                name: 'Exceptional Project',
                cycleSnaps: newCycleSnapDTOSet,
        )

        when:
        def response = getForEntity("${baseUrl}/projects/12345/dashboard", ProjectDTO.class)

        then:
        response.statusCode == HttpStatus.OK
        def project = response.body
        expectedProject == project
    }
}
