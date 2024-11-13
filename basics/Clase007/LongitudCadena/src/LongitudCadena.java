import java.util.Scanner;

public class LongitudCadena {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una palabra o frase:");
        String usuarioRespuesta = input.nextLine();
        System.out.println("La cadena " + "'" + input + "'" + " tiene una longitud de: " + usuarioRespuesta);

    }
}
