import java.util.Scanner;

public class ExtraccionSubcadena {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una frase: ");
        String fraseUsuario = input.nextLine();
        System.out.println("Ingresa un valor para el índice inicial: ");
        int indiceInicial = input.nextInt();
        System.out.println("Ingresa un valor para el índice final: ");
        int indiceFinal = input.nextInt();

        String subCadena = fraseUsuario.substring(indiceInicial, indiceFinal);

        System.out.println("La subcadena es: " + subCadena);

        input.close();
    }
}
