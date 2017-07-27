package com.gft.GiFT

import com.gft.GiFT.dto.CycleSnapDTO
import com.gft.GiFT.dto.ProjectDTO
import com.gft.GiFT.entities.CycleSnap
import com.gft.GiFT.entities.Project
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.core.ParameterizedTypeReference
import spock.lang.Shared

@SpringBootTest( classes = GiFtApplication.class,
        webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = "server.port:8080")
@ActiveProfiles(["dev"])
@DirtiesContext
class ProjectsIntegrationTests extends AbstractIntegrationSpecification {

    @Shared  def cycleSnapDTO1 = new CycleSnapDTO(
            cycleSnapName: "Sprint 84",
            startDate: '2017-05-22',
            endDate: '2017-06-18',
            targetedPoints: 136,
            achievedPoints: 70,
            tac: "51%"
    )

    @Shared  def cycleSnap1 = new CycleSnap(
            cycleSnapId: 11,
            cycleSnapName: "Sprint 84",
            startDate: Date.parse( 'yyyy-MM-dd', '2017-05-22' ),
            endDate: Date.parse( 'yyyy-MM-dd', '2017-06-18'),
            targetedPoints: 136,
            achievedPoints: 70,
            projectId: 3
    )

    def "Should get projects by portfolio" () {
        given:
        Set<CycleSnap> newCycleSnapSet = new HashSet<CycleSnap>()
        newCycleSnapSet.add(cycleSnap1)

        def oneProject = new Project()
        oneProject.id = 3
        oneProject.name = "A-Team"
        oneProject.portfolioId = 2
        oneProject.releasePatternId = 1
        oneProject.cycleTypeId = 2
        oneProject.projectStatus = 1
        oneProject.cycleSnapSet = newCycleSnapSet

        def otherProject = new Project()
        otherProject.id = 4
        otherProject.name = "Bootcamp"
        otherProject.portfolioId = 2
        otherProject.releasePatternId = 1
        otherProject.cycleTypeId = 2
        otherProject.projectStatus = 1

        List<Project> expected = new ArrayList<Project>()
        expected.add(oneProject)
        expected.add(otherProject)

        when:
        ResponseEntity<List<Project>> projects = getForEntity("${BASE_URL}/projects/portfolio/2",
                new ParameterizedTypeReference<List<Project>>() {})
        then:
        projects.statusCode == HttpStatus.OK
        def response = projects.body
        response != null
        expected == response
    }

    def "Should add a new project" () {
        given:
        def firstProject = new Project(
                name: "My First Project",
                portfolioId: 2,
                releasePatternId: 2,
                cycleTypeId: 3,
                projectStatus:  4
        )

        when:
        def projectCreated = postForEntity("${BASE_URL}/projects", firstProject, Project.class)

        then:
        projectCreated.statusCode == HttpStatus.OK
        Project response = projectCreated.body
        response != null
        response.id != 0
        response.name == "My First Project"
        response.portfolioId == 2
        response.releasePatternId == 2
        response.cycleTypeId ==  3
        response.projectStatus == 4
    }

    def "Should get dashboard by project Id" () {
        given:
        Set<CycleSnapDTO> newCycleSnapDTOSet = new HashSet<CycleSnapDTO>()
        newCycleSnapDTOSet.add(cycleSnapDTO1)

        def expectedProject = new ProjectDTO(
                name: 'A-Team',
                setCycleSnaps: newCycleSnapDTOSet
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