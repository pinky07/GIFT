package com.gft.GiFT.projects.dashboard.businessLogic.businessRules.LastReleaseOperations

import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.LastReleaseInfo
import com.gft.GiFT.projects.dashboard.businessLogic.businessRules.LastReleaseOperations
import com.gft.GiFT.projects.dashboard.dataAccess.ReleaseSnap
import spock.lang.Specification

class GetLastReleaseTests extends Specification {

    def "There are no releases"() {
        given:
        def cycleEndDate = "2017-01-30"
        List<ReleaseSnap> releases = new LinkedList<>()
        LastReleaseInfo expected = new LastReleaseInfo(
                lastReleaseName: 'No releases yet',
                lastReleaseDate: 'No releases yet'

        )

        when:
        LastReleaseInfo actual = LastReleaseOperations.getLastRelease(cycleEndDate, releases)

        then:
        actual == expected
    }

    def "There are no releases before but others after"() {
        given:
        def cycleEndDate = "2017-01-30"
        List<ReleaseSnap> releases = new LinkedList<>()
        ReleaseSnap releaseAfter = new ReleaseSnap();
        releaseAfter.setReleaseDate("2017-03-02")
        releaseAfter.setReleaseName("Second update")

        ReleaseSnap releaseBefore = new ReleaseSnap();
        releaseBefore.setReleaseDate("2017-02-07")
        releaseBefore.setReleaseName("First version")

        releases.add(releaseAfter)
        releases.add(releaseBefore)

        LastReleaseInfo expected = new LastReleaseInfo(
                lastReleaseName: 'No releases yet',
                lastReleaseDate: 'No releases yet'

        )

        when:
        LastReleaseInfo actual = LastReleaseOperations.getLastRelease(cycleEndDate, releases)

        then:
        actual == expected
    }


    def "There is a release before"() {
        given:
        def cycleEndDate = "2017-02-14"
        List<ReleaseSnap> releases = new LinkedList<>()
        ReleaseSnap releaseOne = new ReleaseSnap();
        releaseOne.setReleaseDate("2017-02-07")
        releaseOne.setReleaseName("First version")
        releases.add(releaseOne)

        LastReleaseInfo expected = new LastReleaseInfo(
                lastReleaseName: 'First version',
                lastReleaseDate: '2017-02-07'
        )

        when:
        LastReleaseInfo actual = LastReleaseOperations.getLastRelease(cycleEndDate, releases)

        then:
        actual == expected
    }

    def "There is a release before and after "() {
        given:
        def cycleEndDate = "2017-02-28"

        List<ReleaseSnap> releases = new LinkedList<>()
        ReleaseSnap releaseAfter = new ReleaseSnap();
        releaseAfter.setReleaseDate("2017-03-02")
        releaseAfter.setReleaseName("Second update")

        ReleaseSnap releaseBefore = new ReleaseSnap();
        releaseBefore.setReleaseDate("2017-02-07")
        releaseBefore.setReleaseName("First version")

        releases.add(releaseAfter)
        releases.add(releaseBefore)

        LastReleaseInfo expected = new LastReleaseInfo(
                lastReleaseName: "First version",
                lastReleaseDate: '2017-02-07'
        )

        when:
        LastReleaseInfo actual = LastReleaseOperations.getLastRelease(cycleEndDate, releases)

        then:
        actual == expected
    }

    def "There are two releases before and one after"() {
        given:
        def cycleEndDate = "2017-03-15"

        ReleaseSnap releaseBefore2 = new ReleaseSnap();
        releaseBefore2.setReleaseDate("2017-02-07")
        releaseBefore2.setReleaseName("First version")

        List<ReleaseSnap> releases = new LinkedList<>()
        ReleaseSnap releaseBefore1 = new ReleaseSnap();
        releaseBefore1.setReleaseDate("2017-03-02")
        releaseBefore1.setReleaseName("Second update")

        ReleaseSnap releaseAfter = new ReleaseSnap();
        releaseAfter.setReleaseDate("2017-04-02")
        releaseAfter.setReleaseName("Third update")

        releases.add(releaseBefore1)
        releases.add(releaseBefore2)
        releases.add(releaseAfter)

        LastReleaseInfo expected = new LastReleaseInfo(
                lastReleaseName: "Second update",
                lastReleaseDate: '2017-03-02'
        )

        when:
        LastReleaseInfo actual = LastReleaseOperations.getLastRelease(cycleEndDate, releases)

        then:
        actual == expected
    }

    def "There is a release the same day of cycle end date"() {
        given:
        def cycleEndDate = "2017-06-14"
        List<ReleaseSnap> releases = new LinkedList<>()
        ReleaseSnap releaseOne = new ReleaseSnap();
        releaseOne.setReleaseDate("2017-06-14")
        releaseOne.setReleaseName("Other version")
        releases.add(releaseOne)

        LastReleaseInfo expected = new LastReleaseInfo(
                lastReleaseName: 'Other version',
                lastReleaseDate: '2017-06-14'
        )

        when:
        LastReleaseInfo actual = LastReleaseOperations.getLastRelease(cycleEndDate, releases)

        then:
        actual == expected
    }

}
