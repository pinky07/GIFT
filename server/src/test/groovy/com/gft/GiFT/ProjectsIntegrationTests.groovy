package com.gft.GiFT

import com.gft.GiFT.entities.Project
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
        oneProject.name = "GiFT"
        oneProject.portfolioId = 1
        oneProject.releasePatternId = 2
        oneProject.cycleTypeId = 1
        oneProject.projectStatus = 2

        def otherProject = new Project()
        otherProject.id = 2
        otherProject.name = "Big Ball"
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
}