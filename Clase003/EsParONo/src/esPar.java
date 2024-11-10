import java.util.Scanner;

public class esPar {
    public static void main(String[] args) {
        String resultado;
        int num;

        Scanner inputUsuario = new Scanner(System.in);

        System.out.println("Ingresa un número: ");
        num = inputUsuario.nextInt();

        resultado = num % 2 == 0 ? "Es par" : "Es impar";

        System.out.println(resultado);

        inputUsuario.close();
    }
}
