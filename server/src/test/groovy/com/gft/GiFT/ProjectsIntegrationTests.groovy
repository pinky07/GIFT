package com.gft.GiFT

import com.gft.GiFT.dto.CycleSnapDTO
import com.gft.GiFT.dto.ProjectDTO
import com.gft.GiFT.entities.Project
import org.junit.Ignore
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.core.ParameterizedTypeReference

@SpringBootTest( classes = GiFtApplication.class,
        webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = "server.port:8080")
@ActiveProfiles(["dev"])
@DirtiesContext
class ProjectsIntegrationTests extends AbstractIntegrationSpecification {

    def "Should get projects by portfolio" () {
        given:
        def oneProject = new Project()
        oneProject.id = 1
        oneProject.name = "Phoenix"
        oneProject.portfolioId = 1
        oneProject.releasePatternId = 2
        oneProject.cycleTypeId = 1
        oneProject.projectStatus = 2

        def otherProject = new Project()
        otherProject.id = 2
        otherProject.name = "BAAM"
        otherProject.portfolioId = 1
        otherProject.releasePatternId = 1
        otherProject.cycleTypeId = 2
        otherProject.projectStatus = 1

        List<Project> expected = new ArrayList<Project>()
        expected.add(oneProject)
        expected.add(otherProject)

        when:
        ResponseEntity<List<Project>> projects = getForEntity("${BASE_URL}/projects/portfolio/1",
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

    @Ignore
    def "Should get dashboard by project Id" () {
        given:

        def cycleSnap = new CycleSnapDTO(
                cycleSnapName: "Sprint 84",
                startDate: new Date(2017-05-22),
                endDate: new Date(2017-06-18),
                targetedPoints: 136,
                achievedPoints: 70,
                tac: "51"
        )

        Set<CycleSnapDTO> cycleSnapDTOList = new HashSet<CycleSnapDTO>()
        cycleSnapDTOList.add(cycleSnap)

        def expectedProject = new ProjectDTO(
                name: 'Phoenix',
                cycleSnapList: cycleSnapDTOList
        )

        when:
        def response = getForEntity("${BASE_URL}/projects/1/dashboard", ProjectDTO.class)

        then:
        response.statusCode == HttpStatus.OK
        def project = response.body
        expectedProject == project
    }
}