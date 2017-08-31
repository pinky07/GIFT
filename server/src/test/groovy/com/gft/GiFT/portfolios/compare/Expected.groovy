package com.gft.GiFT.portfolios.compare

import com.gft.GiFT.portfolios.compare.businessLogic.response.LastSnapDTO
import com.gft.GiFT.portfolios.compare.businessLogic.response.PortfolioCompareDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class Expected {
    static ResponseEntity<Object> getExpectedResponseEntity() {
        ResponseEntity<Object> expected
        PortfolioCompareDTO comparison = getExpectedPortfolioComparison()

        expected = new ResponseEntity<>(comparison, HttpStatus.OK)
        return expected
    }

    static  PortfolioCompareDTO getExpectedPortfolioComparison() {
        LinkedList<LastSnapDTO> snaps = getExpectedLastSnapList()

        PortfolioCompareDTO comparison = new PortfolioCompareDTO()
        comparison.setPortfolioName("Amazing projects")
        comparison.setLastSnaps(snaps)

        return comparison
    }

    static  List<LastSnapDTO> getExpectedLastSnapList() {
        LastSnapDTO exceptionalProject = getExpectedLastSnapWithSnaps()
        LastSnapDTO appraisalTool = getExpectedLastSnapWithoutSnaps()

        List<LastSnapDTO> snaps = new LinkedList<>()
        snaps.add(exceptionalProject)
        snaps.add(appraisalTool)

        return snaps
    }

    static  LastSnapDTO getExpectedLastSnapWithoutSnaps() {
        LastSnapDTO appraisalTool = new LastSnapDTO()
        appraisalTool.setProjectId(12346)
        appraisalTool.setProjectName("Appraisal tool")
        appraisalTool.setTac("No data")
        appraisalTool.setDaysWithoutRelease("No data")
        appraisalTool.setRelatedIncidents("No data")
        appraisalTool.setWaste("No data")
        appraisalTool.setMood("No data")
        appraisalTool
    }

    static LastSnapDTO getExpectedLastSnapWithSnaps() {
        LastSnapDTO exceptionalProject = new LastSnapDTO()
        exceptionalProject.setProjectId(12345)
        exceptionalProject.setProjectName("Exceptional project")
        exceptionalProject.setTac("100%")
        exceptionalProject.setDaysWithoutRelease("13")
        exceptionalProject.setRelatedIncidents("6")
        exceptionalProject.setWaste("No data")
        exceptionalProject.setMood("No data")
        exceptionalProject
    }
}
