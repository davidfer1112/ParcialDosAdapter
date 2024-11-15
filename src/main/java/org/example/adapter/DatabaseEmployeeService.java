package org.example.adapter;

import org.example.model.Employee;
import org.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseEmployeeService {
    public Employee getEmployeeByCode(String codigoEmpleado) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM empleados WHERE codigo_empleado = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, codigoEmpleado);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Employee(
                        resultSet.getString("codigo_empleado"),
                        resultSet.getString("nombre"),
                        resultSet.getString("puesto")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
