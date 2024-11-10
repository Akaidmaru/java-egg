import java.util.Scanner;

public class VerificarContrasenia {
    public static void main(String[] args) {
        String secretPass = "abierto";
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        if (userInput.equals(secretPass)){
            System.out.println("Acceso concedido!");
        } else {
            System.out.println("Acceso denegado!");
        }
        input.close();
    }
}
