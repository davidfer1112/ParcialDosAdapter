package org.example.model;

public class Employee {
    private String codigoEmpleado;
    private String nombre;
    private String puesto;

    public Employee(String codigoEmpleado, String nombre, String puesto) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "codigoEmpleado='" + codigoEmpleado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}
