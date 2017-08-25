package com.gft.GiFT.portfolios.comparator

import com.gft.GiFT.portfolios.comparator.businessLogic.response.LastSnapDTO
import com.gft.GiFT.portfolios.comparator.businessLogic.response.PortfolioComparatorDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class Expected {
    static ResponseEntity<Object> getExpectedResponseEntity() {
        ResponseEntity<Object> expected
        PortfolioComparatorDTO comparator = getExpectedPortfolioComparator()

        expected = new ResponseEntity<>(comparator, HttpStatus.OK)
        return expected
    }

    static  PortfolioComparatorDTO getExpectedPortfolioComparator() {
        LinkedList<LastSnapDTO> snaps = getExpectedLastSnapList()

        PortfolioComparatorDTO comparator = new PortfolioComparatorDTO()
        comparator.setPortfolioName("Amazing projects")
        comparator.setLastSnaps(snaps)

        return comparator
    }

    static  List<LastSnapDTO> getExpectedLastSnapList() {
        LastSnapDTO exceptionalProject = getExpectedLastSnapWithSnaps()
        LastSnapDTO appraisalTool = getExpectedLastSnapWithoutSnaps()

        List<LastSnapDTO> snaps = new LinkedList<>()
        snaps.add(appraisalTool)
        snaps.add(exceptionalProject)

        return snaps
    }

    static  LastSnapDTO getExpectedLastSnapWithoutSnaps() {
        LastSnapDTO appraisalTool = new LastSnapDTO()
        appraisalTool.setProjectName("Appraisal tool")
        appraisalTool.setTac("No data")
//        appraisalTool.setDaysWithoutRelease("No data")
//        appraisalTool.setRelatedIncidents("No data")
//        appraisalTool.setWaste("No data")
//        appraisalTool.setMood("No data")
        appraisalTool
    }

    static LastSnapDTO getExpectedLastSnapWithSnaps() {
        LastSnapDTO exceptionalProject = new LastSnapDTO()
        exceptionalProject.setProjectName("Exceptional project")
        exceptionalProject.setTac("100%")
//        exceptionalProject.setDaysWithoutRelease("13")
//        exceptionalProject.setRelatedIncidents("6")
//        exceptionalProject.setWaste("No data")
//        exceptionalProject.setMood("No data")
        exceptionalProject
    }
}
