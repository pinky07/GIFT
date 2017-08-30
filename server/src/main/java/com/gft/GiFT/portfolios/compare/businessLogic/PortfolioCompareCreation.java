package com.gft.GiFT.portfolios.compare.businessLogic;

import com.gft.GiFT.portfolios.compare.businessLogic.inputs.*;
import com.gft.GiFT.portfolios.compare.businessLogic.response.*;

import java.util.List;
import java.util.Set;

public class PortfolioCompareCreation {
    public static PortfolioCompareDTO getComparison(CompareInputs inputs) {
        Portfolio portfolio = inputs.getPortFolio();

        Set<Project> projects = portfolio.getProjects();
        List<LastSnapDTO> snaps = LastSnapListCreation.getList(projects);

        PortfolioCompareDTO comparator = new PortfolioCompareDTO();
        String name = portfolio.getPortfolioName();
        comparator.setPortfolioName(name);
        comparator.setLastSnaps(snaps);

        return comparator;
    }
}