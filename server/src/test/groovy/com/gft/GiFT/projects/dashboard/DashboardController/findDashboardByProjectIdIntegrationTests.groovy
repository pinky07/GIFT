package com.gft.GiFT.projects.dashboard.DashboardController

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.GiFtApplication
import com.gft.GiFT.projects.dashboard.CycleSnapDTO
import com.gft.GiFT.projects.dashboard.ProjectDTO
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Shared

@SpringBootTest( classes = GiFtApplication.class,
        webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = "server.port:8080")
@ActiveProfiles(["dev"])
@DirtiesContext
class findDashboardByProjectIdIntegrationTests extends AbstractIntegrationSpecification {

    def cycleSnapDTO1 = new CycleSnapDTO(
            cycleSnapName: "Sprint 84",
            startDate: '2017-05-22',
            endDate: '2017-06-18',
            targetedPoints: 136,
            achievedPoints: 70,
            tac: "51%"
    )

    def "Should get dashboard by project Id" () {
        given:
        Set<CycleSnapDTO> newCycleSnapDTOSet = new LinkedHashSet<CycleSnapDTO>()
        newCycleSnapDTOSet.add(cycleSnapDTO1)

        def expectedProject = new ProjectDTO(
                name: 'A-Team',
                cycleSnaps: newCycleSnapDTOSet
        )

        when:
        def response = getForEntity("${BASE_URL}/projects/3/dashboard", ProjectDTO.class)

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
}
