package modelos;

import java.util.Arrays;

public class Empleado {
    private int id = 0;
    private String nombre;
    private int edad;
    private int salario; // Puede ser Float o Double
    private String departamento;


    public Empleado() {
    }

    public Empleado(String nombre, int edad, int salario, String departamento) {
        this.id = Empleado.id++;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void mostrarTodosEmpleados(Empleado[] empleados){
        System.out.println("Numero Nombre Edad Salario Departamento");
        for (Empleado e : empleados) {
            System.out.println(e.id+" "+e.nombre+" "+e.edad+" "+e.salario+" "+e.departamento);
        }
    }

    public static Empleado[] filtrarEmpleado(Empleado[] empleados, String criterio, String elemento) {
        return Arrays.stream(empleados).filter(e -> {
            switch(criterio.toLowerCase()){
                case "nombre" -> {
                    return e.getNombre().equalsIgnoreCase(elemento);
                }
                case "departamento" -> {
                    return e.getDepartamento().equalsIgnoreCase(elemento);
                }
                default -> {
                    return false;
                }
            }
        }).toArray(Empleado[]::new);
    }

    public static Empleado[] filtrarEmpleado(Empleado[] empleados, String criterio, int min, int max) {
        return Arrays.stream(empleados).filter(e -> {
            switch(criterio.toLowerCase()){
                case "edad" -> {
                    return e.getEdad() >= min && e.getEdad() <= max;
                }
                case "salario" -> {
                    return e.getSalario() >= min && e.getSalario() <= max;
                }
                default -> {
                    return false;
                }
            }
        }).toArray(Empleado[]::new);
    }


}
