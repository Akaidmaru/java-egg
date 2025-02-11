package main.java.com.backend.estancias;

import main.java.com.backend.estancias.service.CasaService;
import main.java.com.backend.estancias.service.ClienteService;
import main.java.com.backend.estancias.service.FamiliaService;

import java.time.LocalDate;
import java.util.Scanner;

public class EstanciasApplication {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        EstanciasApplication app = new EstanciasApplication();
        app.menu(scanner);

    }


    public void menu(Scanner scanner) throws Exception {
        System.out.println("********** Menu **********");
        System.out.println("1. Buscar familias con al menos 3 hijos y con edad máxima inferior a 10 años.");
        System.out.println("2. Buscar casas disponibles entre 1 de agosto 2020 y 31 de agosto 2020.");
        System.out.println("3. Buscar todas aquellas familias cuyo email sea Hotmail.");
        System.out.println("4. Buscar casas disponibles a partir de una fecha dada y un número de días específico.");
        System.out.println("5. Buscar clientes que en algún momento realizaaron una estancia y la descripción de la casa.");
        System.out.println("6. Incrementar el precio por día y mostar el precio total de la estancia.");
        System.out.println("7. Obtener el número de casas que existen para cada país.");
        System.out.println("8. Buscar casas del Reino Unido de las que los comentarios digan que están 'limpias'.");
        System.out.println("9. Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.");
        System.out.println("0. Salir");
        int userOption = Integer.parseInt(scanner.nextLine());
        switch (userOption) {
            case 1 -> {
                FamiliaService familiaService = new FamiliaService();
                familiaService.listarFamiliasNumHijosAndEdadMaxima();
            }
            case 2 -> {
                CasaService casaService = new CasaService();
                casaService.listarCasasDisponiblesAgosto();
            }
            case 3 -> {
                FamiliaService familiaService = new FamiliaService();
                familiaService.listarFamiliasEmailHotmail();
            }
            case 4 -> {
                CasaService casaService = new CasaService();
                System.out.println("Ingrese la fecha de inicio en formato yyyy-MM-dd");
                LocalDate fecha = LocalDate.parse(scanner.nextLine());
                System.out.println("Ingrese el número de días de estancia");
                int diasEstadia = Integer.parseInt(scanner.nextLine());
                casaService.listarCasasDisponiblesFechaEIntervaloDias(fecha, diasEstadia);
            }
            case 5 -> {
                ClienteService clienteService = new ClienteService();
                clienteService.listarClientesEstanciaPrevia();
            }
            case 6 -> {
                CasaService casaService = new CasaService();
                System.out.println("Ingrese el porcentaje de incremento del precio por día: ");
                double porcentaje = Double.parseDouble(scanner.nextLine());
                System.out.println("Ingrese el país de la casa: ");
                String pais = scanner.nextLine();
                casaService.incrementarPrecioPorDia(porcentaje, pais);
            }
            case 7 -> {
                CasaService casaService = new CasaService();
                casaService.obtenerNumeroCasasPorPais();
            }
            case 8 -> {
                CasaService casaService = new CasaService();
                casaService.listarCasasReinoUnidoLimpias();
            }
            case 9 -> {
                // Code for option 9
            }
            case 0 -> {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid option");
            }
        }
    }
}
