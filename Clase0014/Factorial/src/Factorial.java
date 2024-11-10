import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un número: ");
        int number = input.nextInt();
        int counter = 1;
        int result = 1;

        do {
            result *= counter;
            counter++;
        } while(counter <= number);

        if(number < 0) {
            System.out.println("El factorial de " + number + " no es calculable.");
        } else {
            System.out.println("El factorial de " + number + " es: " + result);
        }
    }
}
