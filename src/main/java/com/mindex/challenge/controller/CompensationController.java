package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.dto.CompensationDTO;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {

    @Autowired
    private CompensationService compensationService;

    /**
     * This method is used to create compensation for an employee
     * @param compensationDTO to transfer data between layers
     * @return Compensation object that is created
     */
    @PostMapping("/compensation")
    public ResponseEntity<Compensation> createCompensation(@RequestBody CompensationDTO compensationDTO) {
        Compensation createdCompensation = compensationService.createCompensation(compensationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCompensation);
    }

    /**
     * This method is used to get Compensation of employee according to id provided;
     * @param employeeId
     * @return
     */
    @GetMapping("/compensation/{employeeId}")
    public ResponseEntity<Compensation> getCompensationByEmployeeId(@PathVariable String employeeId) {
        Compensation compensation = compensationService.getCompensationByEmployeeId(employeeId);

        if (compensation == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(compensation);
    }
}
