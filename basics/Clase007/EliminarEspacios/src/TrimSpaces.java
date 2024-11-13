import java.util.Scanner;

public class TrimSpaces {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una frase o palabra con espacios antes y después: ");
        String fraseUsuario = input.nextLine();
        fraseUsuario = fraseUsuario.trim();
        System.out.println(fraseUsuario);

        input.close();
    }
}
