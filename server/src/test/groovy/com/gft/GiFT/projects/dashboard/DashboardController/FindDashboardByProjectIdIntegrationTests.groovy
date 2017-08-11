package com.gft.GiFT.projects.dashboard.DashboardController

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.GiFtApplication
import com.gft.GiFT.projects.dashboard.businessLogic.CycleSnapDTO
import com.gft.GiFT.projects.dashboard.businessLogic.ProjectDTO
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import org.springframework.transaction.annotation.Transactional

@SpringBootTest( classes = GiFtApplication.class,
        webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = "server.port:8080")
@ActiveProfiles(["dev"])
@Transactional
@Rollback
@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/projects/dashboard/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/projects/dashboard/after.sql")
])
class FindDashboardByProjectIdIntegrationTests extends AbstractIntegrationSpecification {

    def cycleSnapDTO1 = new CycleSnapDTO(
            cycleSnapName: "Sprint Test",
            startDate: '2017-05-22',
            endDate: '2017-06-18',
            targetedPoints: 136,
            achievedPoints: 70,
            daysSinceLastRelease: 'No releases yet',
            tac: "51%",
            relatedIncidents: 'No releases yet',
            lastReleaseName: 'No releases yet',
            lastReleaseDate: 'No releases yet'
    )

    def cycleSnapDTO2 = new CycleSnapDTO(
            cycleSnapName: "New Sprint Test",
            startDate: '2017-02-01',
            endDate: '2017-02-14',
            targetedPoints: 76,
            achievedPoints: 58,
            daysSinceLastRelease: '7',
            tac: "76%",
            relatedIncidents: 'No reports available',
            lastReleaseName: 'First version',
            lastReleaseDate: '2017-02-07'
    )

    def cycleSnapDTO3 = new CycleSnapDTO(
            cycleSnapName: "Sprint Test 2",
            startDate: '2017-03-02',
            endDate: '2017-03-15',
            targetedPoints: 87,
            achievedPoints: 45,
            daysSinceLastRelease: '13',
            tac: "51%",
            relatedIncidents: 'No reports available',
            lastReleaseName: 'Second update',
            lastReleaseDate: '2017-03-02'
    )

    def "Should get dashboard by project Id" () {
        given:
        Set<CycleSnapDTO> newCycleSnapDTOSet = new LinkedHashSet<CycleSnapDTO>()
        newCycleSnapDTOSet.add(cycleSnapDTO1)

        def expectedProject = new ProjectDTO (
                name: 'Project Test',
                cycleSnaps: newCycleSnapDTOSet
        )

        when:
        def response = getForEntity("${BASE_URL}/projects/99999/dashboard", ProjectDTO.class)

        then:
        response.statusCode == HttpStatus.OK
        def project = response.body
        expectedProject == project
    }

    def "Should get a 404 when the projectId does not exist" () {
        when:
        def response = getForEntity("${BASE_URL}/projects/999/dashboard", ProjectDTO.class)

        then:
        response.statusCode == HttpStatus.NOT_FOUND
    }

    def "Should get dashboard by project Id with Days since last release" () {
        given:
        Set<CycleSnapDTO> newCycleSnapDTOSet = new LinkedHashSet<CycleSnapDTO>()
        newCycleSnapDTOSet.add(cycleSnapDTO2)
        newCycleSnapDTOSet.add(cycleSnapDTO3)

        def expectedProject = new ProjectDTO (
                name: 'New Project Test',
                cycleSnaps: newCycleSnapDTOSet,
        )

        when:
        def response = getForEntity("${BASE_URL}/projects/12345/dashboard", ProjectDTO.class)

        then:
        response.statusCode == HttpStatus.OK
        def project = response.body
        expectedProject == project
    }
}
