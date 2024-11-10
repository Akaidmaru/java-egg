import java.util.Scanner;

public class RoundNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ingresa un número: ");
        double userNumber = input.nextDouble();
        input.close();
        System.out.println("El número " + userNumber + " redondeado es " + Math.round(userNumber));
    }
}
