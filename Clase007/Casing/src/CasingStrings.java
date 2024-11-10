import java.util.Scanner;

public class CasingStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una palabra o frase:");
        String fraseUsuario = input.nextLine();

        System.out.println("Minúsculas: " + fraseUsuario.toLowerCase());
        System.out.println("Mayúsculas: " + fraseUsuario.toUpperCase());

        input.close();
    }
}
