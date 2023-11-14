package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingStructureController {

    @Autowired
    private ReportingStructureService reportingStructureService;


    /**
     * This Endpoint is used to calculate number of reporting using id provided
     * @param employeeId
     * @return ResponseStructure Object that have employee and numberOfReporting
     */
    @GetMapping("/reportingStructure/{employeeId}")
    public ResponseEntity<ReportingStructure> getReportingStructure(@PathVariable String employeeId) {
        ReportingStructure reportingStructure = reportingStructureService.getReportingStructure(employeeId);
        return ResponseEntity.ok(reportingStructure);
    }


}
