import java.util.InputMismatchException;
import java.util.Scanner;

public class Dividir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un número como dividendo: ");
        int dividendo = input.nextInt();
        System.out.println("Ingresa un número como dividendo: ");
        int divisor = input.nextInt();
        int resultado;

        try {
            resultado = dividendo / divisor;
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException error) {
            System.out.println("No se puede dividir por cero.");
        } catch (InputMismatchException error) {
            System.out.println("Ingresa solo números.");
        }
        input.close();
    }
}
