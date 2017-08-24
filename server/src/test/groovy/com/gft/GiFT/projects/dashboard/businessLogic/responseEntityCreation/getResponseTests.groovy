package com.gft.GiFT.projects.dashboard.businessLogic.responseEntityCreation

import com.gft.GiFT.common.businessLogic.ErrorMessage
import com.gft.GiFT.projects.dashboard.businessLogic.inputs.CycleSnap
import com.gft.GiFT.projects.dashboard.businessLogic.response.CycleSnapDTO
import com.gft.GiFT.projects.dashboard.businessLogic.ResponseEntityCreation
import com.gft.GiFT.projects.dashboard.businessLogic.inputs.Project
import com.gft.GiFT.projects.dashboard.businessLogic.response.ProjectDTO
import com.gft.GiFT.projects.dashboard.businessLogic.inputs.DashboardInputs
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class getResponseTests extends Specification {

    def "Should get a 404 when the projectId does not exist" () {
        given:
        Date currentDate = new Date(117, 07, 31)
        DashboardInputs inputs = initilizeInvalidInputs(currentDate)
        ResponseEntity<ErrorMessage> expected = initilizeExpectedErrorResponse(currentDate)

        when:
        def response = ResponseEntityCreation.getResponse(inputs)

        then:
        response == expected
    }

    private ResponseEntity<ErrorMessage> initilizeExpectedErrorResponse(Date currentDate) {
        ErrorMessage error = new ErrorMessage(
                HttpStatus.NOT_FOUND,
                "Project 12345 could not be found",
                currentDate)
        ResponseEntity<ErrorMessage> expected = new ResponseEntity<>(error, HttpStatus.NOT_FOUND)
        expected
    }

    private DashboardInputs initilizeInvalidInputs(Date currentDate) {
        DashboardInputs inputs = new DashboardInputs()
        inputs.projectId = 12345
        inputs.project = null
        inputs.currentDate = currentDate
        inputs
    }

    def "Should get dashboard by project Id" () {
        given: "There is a project with no cycle snaps"
        ResponseEntity<ProjectDTO> expected = initializeExpected()
        DashboardInputs inputs = initializeInputs()

        when:
        def response = ResponseEntityCreation.getResponse(inputs)

        then:
        response == expected
    }

    private ResponseEntity<ProjectDTO> initializeExpected() {
        Set<CycleSnapDTO> newCycleSnapDTOSet = new HashSet<CycleSnapDTO>()
        ProjectDTO projectDTO = new ProjectDTO(
                name: 'Exceptional Project',
                cycleSnaps: newCycleSnapDTOSet)
        ResponseEntity<ProjectDTO> expected = new ResponseEntity<>(projectDTO, HttpStatus.OK)
        expected
    }

    private DashboardInputs initializeInputs() {
        DashboardInputs inputs = new DashboardInputs()

        inputs.projectId = 12345

        Project existingProject = new Project()
        existingProject.setName('Exceptional Project')
        Set<CycleSnap> existingSnaps = new LinkedList<CycleSnap>()
        existingProject.setCycleSnapSet(existingSnaps)
        inputs.project = existingProject

        Date currentDate = new Date(117, 07, 31)
        inputs.currentDate = currentDate

        return inputs
    }
}