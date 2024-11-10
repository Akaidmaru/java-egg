import java.util.InputMismatchException;
import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
        System.out.print("Ingresa un número entero positivo: ");
        double rootIndex = input.nextDouble();

        if (rootIndex <= 0) {
            System.out.println("Ingresa solo números mayores a 0.");
        } else {

                System.out.println("La raíz cuadrada de tu número es: " + Math.sqrt(rootIndex));
            } catch (InputMismatchException error){
                System.out.println("Ingresa solomente números, no letras.");
            }
        }

    }
}
