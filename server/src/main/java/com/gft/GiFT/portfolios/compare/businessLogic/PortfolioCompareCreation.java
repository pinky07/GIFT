package com.gft.GiFT.portfolios.comparator.businessLogic;

import com.gft.GiFT.portfolios.comparator.businessLogic.inputs.*;
import com.gft.GiFT.portfolios.comparator.businessLogic.response.*;

import java.util.List;
import java.util.Set;

public class PortfolioComparatorCreation {
    public static PortfolioComparatorDTO getComparator(ComparatorInputs inputs) {
        Portfolio portfolio = inputs.getPortFolio();

        Set<Project> projects = portfolio.getProjects();
        List<LastSnapDTO> snaps = LastSnapListCreation.getList(projects);

        PortfolioComparatorDTO comparator = new PortfolioComparatorDTO();
        String name = portfolio.getPortfolioName();
        comparator.setPortfolioName(name);
        comparator.setLastSnaps(snaps);

        return comparator;
    }
}