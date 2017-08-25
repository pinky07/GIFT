package com.gft.GiFT.portfolios.comparator.businessLogic.portfolioComparatorCreation

import com.gft.GiFT.portfolios.comparator.Expected
import com.gft.GiFT.portfolios.comparator.businessLogic.Inputs
import com.gft.GiFT.portfolios.comparator.businessLogic.PortfolioComparatorCreation
import com.gft.GiFT.portfolios.comparator.businessLogic.response.PortfolioComparatorDTO
import spock.lang.Specification

class GetComparatorTests extends Specification {

    def "Should get a comparator given a portfolio" () {
        given:
        PortfolioComparatorDTO expected = Expected.getExpectedPortfolioComparator()
        def inputs = Inputs.comparatorInputs

        when:
        PortfolioComparatorDTO actual = PortfolioComparatorCreation.getComparator(inputs)

        then:
        actual == expected
    }
}