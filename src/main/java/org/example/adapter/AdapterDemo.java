package org.example.adapter;

import org.example.model.Employee;

public class AdapterDemo {
    public static void main(String[] args) {
        DatabaseEmployeeService databaseService = new DatabaseEmployeeService();
        RestEmployeeService restService = new RestEmployeeService();

        EmployeeAdapter adapter = new EmployeeAdapter(databaseService, restService);

        // Get employee from the database
        Employee employeeFromDB = adapter.getEmployee("DB123", true);
        System.out.println("Employee from Database: " + employeeFromDB);

        // Get employee from REST API
        Employee employeeFromREST = adapter.getEmployee("DB124", false);
        System.out.println("Employee from REST API: " + employeeFromREST);
    }
}
