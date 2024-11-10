import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingresa la base: ");
        double base = input.nextInt();
        System.out.print("Ingresa el exponente: ");
        double exponent = input.nextInt();
        input.close();

        double result = Math.pow(base, exponent);

        System.out.print("El resultado es: " + result);
    }
}
