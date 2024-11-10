import java.util.Arrays;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        int attempts = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la longitud de la contraseña deseada: ");
        int userLength = input.nextInt();
        input.close();
        char[] password = new char[userLength];
        boolean isValid;

        if (userLength >= 3) {
            boolean hasUpper = false;
            boolean hasLower = false;
            boolean hasNumber = false;
            do {
                attempts++;

                for (int i = 0; i < userLength; i++) {
                    int element = (int) (Math.random() * 3);
                    int asciiValue = switch (element) {
                        case 0 -> (int) (Math.random() * (90 - 65 + 1) + 65); // Mayúsculas: Min: 65, Max: 90 (A-Z)
                        case 1 -> (int) (Math.random() * (122 - 97 + 1) + 97); // Minúsculas: Min: 97, Max: 122 (a-z)
                        case 2 -> (int) (Math.random() * (57 - 48 + 1) + 48); //  Números: Min: 48, Max: 57 (0-9)
                        default -> 1;
                    };

                    char letter = (char) asciiValue;
                    password[i] = letter;
                    System.out.println("Letter: " + letter + ", AsciiValue: " + asciiValue);

                    if (Character.isUpperCase(letter)) {
                        hasUpper = true;
                        System.out.println("Cambio de flag hasUpper: " + password[i]);
                    }
                    if (Character.isLowerCase(letter)) {
                        hasLower = true;
                        System.out.println("Cambio de flag hasLower: " + password[i]);
                    }
                    if (Character.isDigit(letter)) {
                        hasNumber = true;
                        System.out.println("Cambio de flag hasNumber: " + password[i]);
                    }
                }

                isValid = hasUpper && hasLower && hasNumber;
            } while (!isValid);

            System.out.println(Arrays.toString(password));
            System.out.println("Cantidad de iteraciones: " + attempts);
        } else {
            System.out.println("Ingresa un tamaño mayor o igual a 3.");
        }
    }
}
