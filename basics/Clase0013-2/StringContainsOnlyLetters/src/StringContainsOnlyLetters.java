import java.util.Scanner;

public class StringContainsOnlyLetters {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una cadena: ");
        String userInput = input.nextLine();
        boolean hasOnlyLetters = true;

        for (int i = 0; i < userInput.length(); i++) {
            if (!Character.isLetter(userInput.charAt(i))){
                hasOnlyLetters = false;
                break;
            }
        }

        if (hasOnlyLetters) {
            System.out.println("La cadena solo contiene letras");
        } else {
            System.out.println("La cadena no solo contiene letras");
        }
    }
}
