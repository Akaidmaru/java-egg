import java.util.Scanner;

public class ValorAbsoluto {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingresa un valor: ");

        int absUser = input.nextInt();

        System.out.println("El valor absoluto de tu número es: " + Math.abs(absUser));

        input.close();
    }
}
