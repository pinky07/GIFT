package com.gft.GiFT.portfolios.comparator.businessLogic.lastSnapListCreation

import com.gft.GiFT.portfolios.comparator.Expected
import com.gft.GiFT.portfolios.comparator.businessLogic.Inputs
import com.gft.GiFT.portfolios.comparator.businessLogic.LastSnapListCreation
import com.gft.GiFT.portfolios.comparator.businessLogic.response.LastSnapDTO
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