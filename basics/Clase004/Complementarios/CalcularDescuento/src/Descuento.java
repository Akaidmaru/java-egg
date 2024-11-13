import java.util.Scanner;

public class Descuento {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el precio de tu producto: ");
        double precioProducto = input.nextDouble();
        double precioFinal;

        if (precioProducto > 100){
            precioFinal = precioProducto - precioProducto * 0.10;
            System.out.println("El precio final con descuento de 10% es: " + precioFinal);
        } else {
            System.out.println("No tienes descuento, precio final: " + precioProducto);
        }
        input.close();
    }
}
