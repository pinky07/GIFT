package com.gft.GiFT.portfolios.comparison.businessLogic.portfolioComparisonCreation

import com.gft.GiFT.portfolios.comparison.Expected
import com.gft.GiFT.portfolios.comparison.businessLogic.Inputs
import com.gft.GiFT.portfolios.compare.businessLogic.PortfolioCompareCreation
import com.gft.GiFT.portfolios.compare.businessLogic.response.PortfolioCompareDTO
import spock.lang.Specification

class GetComparatorTests extends Specification {

    def "Should get a comparator given a portfolio" () {
        given:
        PortfolioCompareDTO expected = Expected.getExpectedPortfolioComparator()
        def inputs = Inputs.comparisonInputs

        when:
        PortfolioCompareDTO actual = PortfolioCompareCreation.getComparison(inputs)

        then:
        actual == expected
    }
}