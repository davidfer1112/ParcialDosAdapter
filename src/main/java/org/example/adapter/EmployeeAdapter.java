package org.example.adapter;

import org.example.model.Employee;

public class EmployeeAdapter {
    private DatabaseEmployeeService databaseService;
    private RestEmployeeService restService;

    public EmployeeAdapter(DatabaseEmployeeService databaseService, RestEmployeeService restService) {
        this.databaseService = databaseService;
        this.restService = restService;
    }

    public Employee getEmployee(String codigoEmpleado, boolean useDatabase) {
        if (useDatabase) {
            return databaseService.getEmployeeByCode(codigoEmpleado);
        } else {
            return restService.getEmployeeByCode(codigoEmpleado);
        }
    }
}
