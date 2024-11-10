import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = 0;

        while(opcion != 5){
            System.out.println("""
                    *** Menú Interactivo ***
                    1) Comprar producto.
                    2) Realizar devolución.
                    3) Ver mis pedidos.
                    4) Preguntas frecuentes.
                    5) Salir.
                    """);
            System.out.println("Ingresa un número que desees para la opción: ");
            opcion = input.nextInt();
        }

        System.out.println("Gracias por usar nuestro programa.");
    }
}
