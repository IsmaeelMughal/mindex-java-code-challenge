package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public ReportingStructure getReportingStructure(String employeeId) {
        Employee employee = employeeService.read(employeeId);

        int numberOfReports = calculateNumberOfReports(employee);
        return new ReportingStructure(employee, numberOfReports);
    }

    // This method is used to calculate direct and Indirect Reporting using recursive calls
    // null is our base case
    private int calculateNumberOfReports(Employee employee) {
        if(employee.getDirectReports() == null)
        {
            return 0;
        }
        int directReports = employee.getDirectReports().size();
        int indirectReports = 0;

        for (Employee directReportEmployee : employee.getDirectReports()) {
            Employee directReport = employeeService.read(directReportEmployee.getEmployeeId());
            indirectReports += calculateNumberOfReports(directReport);
        }

        return directReports + indirectReports;
    }
}
