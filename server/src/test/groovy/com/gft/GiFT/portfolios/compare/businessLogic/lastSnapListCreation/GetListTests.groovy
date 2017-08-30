package com.gft.GiFT.portfolios.compare.businessLogic.lastSnapListCreation

import com.gft.GiFT.portfolios.compare.Expected
import com.gft.GiFT.portfolios.compare.businessLogic.*
import com.gft.GiFT.portfolios.compare.businessLogic.response.*
import spock.lang.Specification

class GetListTests extends Specification {

    def "Should get the list of last snaps given a list of projects" () {
        given:
        List<LastSnapDTO> expected = Expected.getExpectedLastSnapList()

        when:
        List<LastSnapDTO> actual = LastSnapListCreation.getList(Inputs.projects)

        then:
        actual == expected
    }
}