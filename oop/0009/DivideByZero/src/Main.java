import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un numerador: ");
        int numerador = Integer.parseInt(input.nextLine());
        System.out.println("Ingresa un denominador: ");
        int denominador = Integer.parseInt(input.nextLine());

        double resultado = obtenerDenominador(numerador, denominador);

        System.out.println("El resultado es: " + resultado);
    }

    public static double obtenerDenominador(int numerador, int denominador) throws Exception{
        try {
            int resultado = numerador / denominador;
            return resultado;
        } catch (Exception e) {
            throw new Exception("Ocurrió un error: " + e.getMessage());
        }
    }
}
