package com.gft.GiFT.projects.addCycleSnap

import com.gft.GiFT.common.businessLogic.ErrorMessage
import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.CycleSnap
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import static TestInputs.*

class Expected {
    static ResponseEntity<CycleSnap> getSuccessfulResponse() {
        CycleSnap newCycle = getValidCycleSnap()

        return new ResponseEntity<CycleSnap>(newCycle, HttpStatus.CREATED)
    }

    static ResponseEntity<ErrorMessage> getErrorResponse() {
        String errorMessage = "Start Date is required"
        Date currentDate = getCurrentDate()
        ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST, errorMessage, currentDate)

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST)
    }
}