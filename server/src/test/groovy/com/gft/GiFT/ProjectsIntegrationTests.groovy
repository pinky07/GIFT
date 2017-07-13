package com.gft.GiFT

import com.gft.GiFT.entities.Project
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles

@SpringBootTest( classes = GiFtApplication.class,
        webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = "server.port:8080")
@ActiveProfiles(["dev"])
@DirtiesContext
class ProjectsIntegrationTests extends AbstractIntegrationSpecification {

    def "Should add a new project" () {
        given:
        def firstProject = new Project(
                name: "My First Project",
                portfolioId: 1,
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
        response.portfolioId == 1
        response.releasePatternId == 2
        response.cycleTypeId ==  3
        response.projectStatus == 4
    }
}