package com.gft.GiFT.portfolios.comparator.businessLogic;

import com.gft.GiFT.portfolios.comparator.businessLogic.inputs.*

class Inputs {

    static ComparatorInputs getComparatorInputs(){
        ComparatorInputs inputs = new ComparatorInputs()

        inputs.setPortfolioId(12345)

        Portfolio portfolio = getPortfolio()
        inputs.setPortFolio(portfolio)

        return inputs
    }

    static Portfolio getPortfolio() {
        Portfolio portfolio = new Portfolio()
        portfolio.portfolioName = "Amazing projects"
        portfolio.id = 12345

        portfolio.projects = getProjects()
        portfolio
    }

    static Set<Project> getProjects() {
        Set<Project> projects = new LinkedList<>()

        Project projectWithLastSnap = getProjectWithSnaps()
        projects.add(projectWithLastSnap)

        Project projectWithNoLastSnap = getProjectWithoutSnaps()
        projects.add(projectWithNoLastSnap)

        return projects
    }

    static Project getProjectWithSnaps() {
        Project projectWithLastSnap = new Project()
        projectWithLastSnap.id = 12345
        projectWithLastSnap.name = "Exceptional project"

        Set<CycleSnap> snaps = projectWithLastSnap.cycleSnapSet
        snaps.add(new CycleSnap(12345, 'Sprint #1', '2017-01-25', '2017-01-30', 0, 0, 100, 5, true, true, 3.00));
        snaps.add(new CycleSnap(12345, 'Sprint #2', '2017-02-01', '2017-02-14', 60, 55, 99, 5.67, true, true, 3.00));
        snaps.add(new CycleSnap(12345, 'Sprint #3', '2017-02-18', '2017-02-28', 70, 68, 99, 0, true, true, 2.50));
        CycleSnap latest = getLatestCycleSnap()
        snaps.add(latest);

        projectWithLastSnap.cycleSnapSet = snaps
        projectWithLastSnap
    }

    static CycleSnap getLatestCycleSnap() {
        CycleSnap latest = new CycleSnap(12345, 'Sprint #4', '2017-03-01', '2017-03-15', 100, 100, 0, 0, false, false, 0)
        latest
    }

    static Project getProjectWithoutSnaps() {
        Project projectWithNoLastSnap = new Project()
        projectWithNoLastSnap.id = 12346
        projectWithNoLastSnap.name = "Appraisal tool"
        return projectWithNoLastSnap
    }
}