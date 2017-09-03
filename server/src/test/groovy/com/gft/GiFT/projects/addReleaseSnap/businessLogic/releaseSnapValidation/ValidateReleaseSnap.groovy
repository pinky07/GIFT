package com.gft.GiFT.projects.addReleaseSnap.businessLogic.releaseSnapValidation

import com.gft.GiFT.projects.addReleaseSnap.businessLogic.inputs.ReleaseSnap
import com.gft.GiFT.projects.addReleaseSnap.businessLogic.inputs.ReleaseSnapValidation
import spock.lang.Specification

class ValidateReleaseSnap extends Specification {
    ReleaseSnap newRelease

    def setup() {
        newRelease = createValidRelease()
    }

    def createValidRelease() {
        ReleaseSnap newRelease = new ReleaseSnap()
        newRelease.projectId = 1
        newRelease.releaseName = "First version"
        newRelease.releaseDate = "2017-08-31"

        return newRelease
    }


    def "All fields are valid"() {
        when:
        ReleaseSnapValidation.validate(newRelease)

        then:
        notThrown IllegalArgumentException
    }

    def "projectID is required"() {
        setup:
        newRelease.projectId = 0

        when:
        ReleaseSnapValidation.validate(newRelease)

        then:
        thrown IllegalArgumentException
    }
    def "name is required"() {
        setup:
        newRelease.releaseName = ""
        when:
        ReleaseSnapValidation.validate(newRelease)

        then:
        thrown IllegalArgumentException
    }

    def "name cannot be null"() {
        setup:
        newRelease.releaseName = null
        when:
        ReleaseSnapValidation.validate(newRelease)

        then:
        thrown IllegalArgumentException
    }

    def "A name with with spaces is not valid"() {
        setup:
        newRelease.releaseName = " "
        when:
        ReleaseSnapValidation.validate(newRelease)

        then:
        thrown IllegalArgumentException
    }

    def " name has a max of 200 characters"() {
        setup:
        newRelease.releaseName = "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901"
        when:
        ReleaseSnapValidation.validate(newRelease)

        then:
        thrown IllegalArgumentException
    }

    def "Release Date is required"() {
        setup:
        newRelease.releaseDate = ""

        when:
        ReleaseSnapValidation.validate(newRelease)

        then:
        thrown IllegalArgumentException
    }

}
