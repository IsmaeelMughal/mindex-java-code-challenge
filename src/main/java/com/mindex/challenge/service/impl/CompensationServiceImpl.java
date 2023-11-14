package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.dto.CompensationDTO;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService {
    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public Compensation createCompensation(CompensationDTO compensationDTO) {
        Employee employee = employeeService.read(compensationDTO.employeeId);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + compensationDTO.employeeId);
        }
        Compensation compensation = new Compensation(employee, compensationDTO.salary, compensationDTO.effectiveDate);

        return compensationRepository.save(compensation);
    }

    @Override
    public Compensation getCompensationByEmployeeId(String employeeId) {
        return compensationRepository.findByEmployeeEmployeeId(employeeId);
    }
}
