package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.dto.CompensationDTO;

public interface CompensationService {
    Compensation createCompensation(CompensationDTO compensationDTO);
    Compensation getCompensationByEmployeeId(String employeeId);
}
