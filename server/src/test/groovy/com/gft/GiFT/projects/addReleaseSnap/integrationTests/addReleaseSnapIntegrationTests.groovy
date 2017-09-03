package com.gft.GiFT.projects.addReleaseSnap.integrationTests

import com.gft.GiFT.AbstractIntegrationSpecification
import com.gft.GiFT.projects.addReleaseSnap.businessLogic.inputs.ReleaseSnap
import org.springframework.http.HttpStatus
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup

@SqlGroup([
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:/test-sql/projects/addReleaseSnap/before.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:/test-sql/projects/addReleaseSnap/after.sql")
])
class addReleaseSnapIntegrationTests extends AbstractIntegrationSpecification{
    def "Create Release Snap"() {
        given:
        def releaseSnap = getNewReleaseSnap()

        when:
        def response = postForEntity("${baseUrl}/projects/releases", releaseSnap, ReleaseSnap.class)

        then:
        response.statusCode == HttpStatus.CREATED
    }

    ReleaseSnap getNewReleaseSnap() {
        return new ReleaseSnap(
                projectId: 1,
                releaseName: "First version",
                releaseDate: "2017-08-31"
        )
    }


}
