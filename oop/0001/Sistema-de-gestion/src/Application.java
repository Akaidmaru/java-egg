import modelos.Empleado;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Juan", 30, 50000, "Ventas"),
                new Empleado("Ana", 45, 75000, "IT"),
                new Empleado("Luis", 25, 40000, "Ventas"),
                new Empleado("Sofía", 35, 60000, "Marketing"),
                new Empleado("Carlos", 40, 55000, "IT")
        );

        Empleado.mostrarTodosEmpleados(Arrays.asList(empleados));
    }

}
