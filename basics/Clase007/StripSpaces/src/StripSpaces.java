import java.util.Scanner;

public class StripSpaces {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una cadena para calcular su logitud: ");
        String cadenaUsuario = input.nextLine();

        cadenaUsuario = cadenaUsuario.replaceAll("\\s+", "");

        System.out.println("La longitud de la cadena sin espacios es: " + cadenaUsuario.length());

        input.close();
    }
}
