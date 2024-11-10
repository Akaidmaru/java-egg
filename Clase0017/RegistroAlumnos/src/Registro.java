import java.util.Arrays;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] arrayNombres = new String[1];
        double[] arrayNotas = new double[1];
        String userOption;

        do {
            System.out.println("""
                    ***** Menú de opciones *****
                    1) Registar alumno
                    2) Mostrar todos los alumnos
                    3) Mostrar promedio de notas
                    4) Buscar alumnos por nombre
                    5) Modificar nota por nombre
                    6) Eliminar alumno por nombre
                    7) Salir
                    """);
            userOption = input.nextLine();
            switch (Integer.parseInt(userOption)) {
                case 1 -> {
                        System.out.println("Ingresa el nombre del alumno: ");
                        arrayNombres[arrayNombres.length - 1] = input.nextLine();
                        System.out.println("Ingresa la nota del alumno: ");
                        arrayNotas[arrayNotas.length - 1] = input.nextDouble();
                        arrayNombres = Arrays.copyOf(arrayNombres, arrayNombres.length + 1);
                        arrayNotas = Arrays.copyOf(arrayNotas, arrayNotas.length + 1);

                        System.out.println("Array nombres longitud: " + arrayNombres.length); // DEBUG
                        System.out.println("Array notas longitud: " + arrayNotas.length); // DEBUG
                        input.nextLine();
                }
                case 2 -> {
                    for (int i = 0; i < arrayNombres.length - 1; i++) {
                        System.out.println("Nombre de Alumno: " + arrayNombres[i] + ", Nota: "  + arrayNotas[i]);
                    }
                }
                case 3 -> {
                    double promedio = 0;
                    for (int i = 0; i < arrayNotas.length - 1 ; i++) {
                        promedio += arrayNotas[i];
                    }
                    promedio = promedio / (arrayNotas.length - 1);
                    System.out.println("El promedio de notas es: " + promedio);
                }
                case 4 -> {
                    System.out.println("Ingresa el nombre de un alumno: ");
                    String nombreBusqueda = input.nextLine();
                    for (int i = 0; i < arrayNombres.length - 1; i++) {
                        if(arrayNombres[i].equalsIgnoreCase(nombreBusqueda)){
                            System.out.println("La nota de " + arrayNombres[i] + " es: " + arrayNotas[i]);
                        }
                    }
                }
            }
        } while (Integer.parseInt(userOption) != 7);
        input.close();

    }
    }

