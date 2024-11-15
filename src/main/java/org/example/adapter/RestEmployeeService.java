package org.example.adapter;

import com.google.gson.Gson;
import org.example.model.Employee;

// Clase para simular o conectar con un API REST
public class RestEmployeeService {

    // Método principal para obtener un empleado por su código
    public Employee getEmployeeByCode(String codigoEmpleado) {
        // Simulación de un API REST
        String jsonResponse = simulateApiResponse(codigoEmpleado);

        // Si fuera un servicio REST real, solicitud HTTP
        /*
        Client client = ClientBuilder.newClient();
        String jsonResponse = client.target(REST_API_URL)
                                    .path(codigoEmpleado)
                                    .request(MediaType.APPLICATION_JSON)
                                    .get(String.class);
        */

        // Convertir la respuesta JSON (simulada o real) en un objeto Employee
        if (jsonResponse != null) {
            return new Gson().fromJson(jsonResponse, Employee.class);
        }
        return null; // Si no hay respuesta (empleado no encontrado)
    }

    // Simulación de la respuesta de un API REST
    private String simulateApiResponse(String codigoEmpleado) {
        // Este método devuelve respuestas ficticias en formato JSON
        switch (codigoEmpleado) {
            case "DB123":
                return "{ \"codigoEmpleado\": \"DB123\", \"nombre\": \"Carlos López\", \"puesto\": \"Gerente de Proyectos\" }";
            case "DB124":
                return "{ \"codigoEmpleado\": \"DB124\", \"nombre\": \"María García\", \"puesto\": \"Desarrollador Backend\" }";
            case "DB125":
                return "{ \"codigoEmpleado\": \"DB125\", \"nombre\": \"Luis Martínez\", \"puesto\": \"\" }";
            default:
                return null; // Simula un empleado no encontrado
        }
    }

    // Comentarios sobre el uso con un API REST real
    /*
     *  API REST real:
     *
     * 1.constante para la URL base del API:
     *      private static final String REST_API_URL = "http://api.tu-servidor.com/employees";
     *
     * 2. cliente JAX-RS (por ejemplo, Jersey) para realizar la solicitud HTTP:
     *      Client client = ClientBuilder.newClient();
     *      String jsonResponse = client.target(REST_API_URL)
     *                                  .path(codigoEmpleado) // Agrega el código al endpoint
     *                                  .request(MediaType.APPLICATION_JSON) // Indica que esperas JSON
     *                                  .get(String.class); // Realiza la solicitud GET y obtiene la respuesta como String
     *
     * 3. Gson para deserializar la respuesta JSON:
     *      Employee employee = new Gson().fromJson(jsonResponse, Employee.class);
     *
     * 4. manejar excepciones para errores como:
     *      - Conexión fallida (java.net.ConnectException)
     *      - Respuesta no válida o error del servidor
     *
     */
}
