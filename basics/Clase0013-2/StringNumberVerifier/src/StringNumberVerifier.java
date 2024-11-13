import java.util.Scanner;

public class StringNumberVerifier {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una cadena para convertirla a número: ");
        String userInput = input.nextLine();
        try {
            Double userInputConverted = Double.valueOf(userInput);
            System.out.println(userInputConverted);
        } catch (NumberFormatException error) {
            System.out.println("Ingresa un nùmero válido: " + error);
        }
    }
}


