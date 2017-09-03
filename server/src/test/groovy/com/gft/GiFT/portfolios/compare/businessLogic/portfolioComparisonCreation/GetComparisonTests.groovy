package com.gft.GiFT.portfolios.compare.businessLogic.portfolioComparisonCreation

import com.gft.GiFT.portfolios.compare.Expected
import com.gft.GiFT.portfolios.compare.businessLogic.TestInputs
import com.gft.GiFT.portfolios.compare.businessLogic.PortfolioCompareCreation
import com.gft.GiFT.portfolios.compare.businessLogic.response.PortfolioCompareDTO
import spock.lang.Specification

class GetComparisonTests extends Specification {

    def "Should get a comparator given a portfolio" () {
        given:
        PortfolioCompareDTO expected = Expected.getExpectedPortfolioComparison()
        def inputs = TestInputs.comparisonInputs

        when:
        PortfolioCompareDTO actual = PortfolioCompareCreation.getComparison(inputs)

        then:
        actual == expected
    }
}