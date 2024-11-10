import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        int evenCounter = 0;
        int oddCounter = 0;

        while (isRunning) {
            System.out.println("""
                    Ingresa 'q' para salir.
                    Ingresa un número entero para calcular si es para o impar:
                    """);
            String userInput = input.nextLine();

            if (userInput.equalsIgnoreCase("q")) {
                isRunning = false;
            } else {
                int integerInput = Integer.parseInt(userInput);
                if (integerInput % 2 == 0) {
                    evenCounter++;
                } else {
                    oddCounter++;
                }
            }
        }
        System.out.println("La cantidad de números pares es: " + evenCounter);
        System.out.println("La cantidad de números impares es: " + oddCounter);
        input.close();
    }
}
