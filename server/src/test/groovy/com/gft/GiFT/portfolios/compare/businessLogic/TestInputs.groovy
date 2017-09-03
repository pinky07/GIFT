package com.gft.GiFT.portfolios.compare.businessLogic

import com.gft.GiFT.portfolios.compare.businessLogic.inputs.CompareInputs
import com.gft.GiFT.portfolios.compare.businessLogic.inputs.CycleSnap
import com.gft.GiFT.portfolios.compare.businessLogic.inputs.Portfolio
import com.gft.GiFT.portfolios.compare.businessLogic.inputs.Project
import com.gft.GiFT.portfolios.compare.businessLogic.inputs.ReleaseSnap
import com.gft.GiFT.portfolios.compare.businessLogic.inputs.IncidentsReport

class TestInputs {

    static CompareInputs getComparisonInputsWhenPortfolioDoesNotExist(Date currentDate){
        CompareInputs inputs = new CompareInputs()

        inputs.setPortfolioId(999)
        inputs.setPortFolio(null)
        inputs.setCurrentDate(currentDate)

        return inputs
    }

    static CompareInputs getComparisonInputs(){
        CompareInputs inputs = new CompareInputs()

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

    static List<Project> getProjects() {
        List<Project> projects = new LinkedList<>()

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

        List<CycleSnap> snaps = getCycleSnaps(projectWithLastSnap)
        projectWithLastSnap.cycleSnapSet = snaps

        List<ReleaseSnap> releases = getReleases(projectWithLastSnap)
        projectWithLastSnap.releaseSnaps = releases

        List<IncidentsReport> incidents = getIncidents(projectWithLastSnap)
        projectWithLastSnap.incidentsReports = incidents

        projectWithLastSnap
    }

    static List<IncidentsReport> getIncidents(Project projectWithLastSnap) {
        List<IncidentsReport> incidents = projectWithLastSnap.incidentsReports
        incidents.add(new IncidentsReport('2017-02-07', 2))
        incidents.add(new IncidentsReport('2017-02-09', 3))
        incidents.add(new IncidentsReport('2017-02-21', 1))
        incidents.add(new IncidentsReport('2017-03-02', 4))
        incidents.add(new IncidentsReport('2017-03-02', 1))
        incidents.add(new IncidentsReport('2017-03-14', 1))
        incidents.add(new IncidentsReport('2017-03-16', 1))

        incidents
    }

    private static List<ReleaseSnap> getReleases(Project projectWithLastSnap) {
        List<ReleaseSnap> releases = projectWithLastSnap.releaseSnaps
        releases.add(new ReleaseSnap('2017-02-07', 12345))
        releases.add(new ReleaseSnap('2017-03-02', 12345))
        releases.add(new ReleaseSnap('2017-04-02', 12345))
        releases
    }

    private static List<CycleSnap> getCycleSnaps(Project projectWithLastSnap) {
        List<CycleSnap> snaps = projectWithLastSnap.cycleSnapSet
        snaps.add(new CycleSnap(12345, 'Sprint #1', '2017-01-25', '2017-01-30', 0, 0, 100, 5, true, true, 3.00));
        snaps.add(new CycleSnap(12345, 'Sprint #2', '2017-02-01', '2017-02-14', 60, 55, 99, 5.67, true, true, 3.00));
        snaps.add(new CycleSnap(12345, 'Sprint #3', '2017-02-18', '2017-02-28', 70, 68, 99, 0, true, true, 2.50));
        CycleSnap latest = getLatestCycleSnap()
        snaps.add(latest)
        snaps
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

    static List<String> getReleaseDates() {
        List<String> dates = new LinkedList<>()
        dates.add('2017-02-07')
        dates.add('2017-03-02')
        dates.add('2017-04-02')

        return dates
    }

    static Date getFirstCycleStartDate() {
        return new Date(117, 0, 25)
    }
}