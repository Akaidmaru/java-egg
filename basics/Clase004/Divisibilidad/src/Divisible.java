import java.util.Scanner;

public class Divisible {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un número: ");
        int numero = input.nextInt();

        if (numero % 15 == 0 ){ // Por 3 y por 5
            System.out.println("El número es divisible por ambos.");
        } else if ( numero % 5 == 0 ) {
            System.out.println("Tu número es divisible por 5.");
        } else if ( numero % 3 == 0 ){
            System.out.println("Tu número es divisible por 3.");
        } else {
            System.out.println("Tu número no es divisible ni por el 3 ni el 5.");
        }

        input.close();
    }
}
