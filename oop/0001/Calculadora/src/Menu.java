import java.util.Scanner;
from  import Rectangulo;

public class Menu {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        final int MAX_RECT = 20;
        Rectangulo[] rectangulos = new Rectangulo[MAX_RECT];

        int opcion = 0;
        int numeroFigura = 0;

        while (opcion != 4) {
            imprimirOpciones();

            opcion = Integer.valueOf(scanner.nextLine());

            switch (opcion) {
                case 1:
                    rectangulos[Rectangulo.numeroRectangulos()] = crearRectangulo();
                    System.out.println("Rectangulo creado con exito!");
                    break;

                case 2:
                    if (!validarCantidadRectangulos()) {
                        System.out.println("No hay rectangulos!");
                        break;
                    }
                    numeroFigura = obtenerNumeroFigura("rectangulo");
                    if (numeroFigura < Rectangulo.numeroRectangulos() && numeroFigura > 0) {
                        rectangulos[numeroFigura].imprimirArea();
                    } else {
                        System.out.println("No existe ese rectangulo!");
                    }
                    break;

                case 3:
                    if (!validarCantidadRectangulos()) {
                        System.out.println("No hay rectangulos!");
                        break;
                    }

                    numeroFigura = obtenerNumeroFigura("rectangulo");
                    if (numeroFigura < Rectangulo.numeroRectangulos() && numeroFigura > 0) {
                        rectangulos[numeroFigura].imprimirPerimetro();
                    } else {
                        System.out.println("No existe ese rectangulo!");
                    }
                    break;

            }
        }
    }

    private static void imprimirOpciones() {

        System.out.println("""
INGRESE LA OPCION DESEADA:
1. Crear un rectangulo
2. Calcular el area de un rectangulo
3. Calcular el perimetro de un rectangulo
4. Salir
""");
    }

    private static Rectangulo crearRectangulo() {
        System.out.print("Ingrese el ancho del rectangulo: ");
        int ancho = Integer.valueOf(scanner.nextLine());
        System.out.print("Ingrese el alto del rectangulo: ");
        int alto = Integer.valueOf(scanner.nextLine());

        Rectangulo rectangulo = new Rectangulo(ancho, alto);
        return rectangulo;
    }

    private static int obtenerNumeroFigura(String tipoFigura) {

        System.out.printf("Ingrese el %s que desea calcular: ", tipoFigura);
        int numeroFigura = Integer.valueOf(scanner.nextLine()) - 1;
        return numeroFigura;
    }

    private static boolean validarCantidadRectangulos() {
        return Rectangulo.numeroRectangulos() > 0;
    }
}