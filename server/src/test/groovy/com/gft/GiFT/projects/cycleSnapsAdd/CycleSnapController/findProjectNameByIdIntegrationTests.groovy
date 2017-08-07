package com.gft.GiFT.projects.cycleSnapsAdd.CycleSnapController

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.GiFtApplication
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/projects/cycleSnapsAdd/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/projects/cycleSnapsAdd/after.sql")
])
class findProjectNameByIdIntegrationTests extends AbstractIntegrationSpecification {

    def "Find Project Name By Id" () {
        when:
        def response = getForEntity("${BASE_URL}/projects/99999/name", String.class)

        then:
        response.statusCode == HttpStatus.OK
        def projectName = response.body
        projectName == 'Project Test'
    }

    def "Should get a 404 when the projectId does not exist" () {
        when:
        def response = getForEntity("${BASE_URL}/projects/999/name", String.class)

        then:
        response.statusCode == HttpStatus.NOT_FOUND
    }

}
