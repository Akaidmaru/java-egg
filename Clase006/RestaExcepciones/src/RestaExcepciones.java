import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaExcepciones {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {

            System.out.println("Ingresa un número: ");
            int num1 = input.nextInt();
            System.out.println("Ingresa otro número: ");
            int num2 = input.nextInt();
            int resultado = num1 - num2;
            System.out.println("El resultado de la resta es: " + resultado);

        } catch (InputMismatchException error) {
            System.out.println("Ingresa solo números: " + error.getMessage());
        }
        input.close();
    }
}
