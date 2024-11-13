import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una primera frase o palabra: ");
        String frase1 = input.nextLine();
        System.out.println("Ingresa una segunda frase o palabra: ");
        String frase2 = input.nextLine();

        boolean esIgual = frase1.equals(frase2);

        System.out.println("La coincidencia 1 es: " + esIgual);

        int esIgual2 = frase1.compareTo(frase2);

        System.out.println("La coincidencia 2 es: " + esIgual2);

        input.close();
    }
}
