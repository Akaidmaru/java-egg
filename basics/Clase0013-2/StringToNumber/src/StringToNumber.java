import java.util.Scanner;

public class StringToNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una cadena de texto a convertir a número: ");
        String userInput = input.nextLine();

        try {
            int userInputConverted = Integer.parseInt(userInput);
            System.out.println("El siguiente número en integer: ");
            System.out.println(userInputConverted);
        } catch (NumberFormatException error) {
            System.out.println("Ingresa un número correcto: " + error);
        }


    }
}
