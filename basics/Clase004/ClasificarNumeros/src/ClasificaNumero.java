import java.util.Scanner;

public class ClasificaNumero {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un número: ");
        int num = input.nextInt();

        if (num == 0){
            System.out.println("El número es 0.");
        } else if (num > 0) {
            System.out.println("El número es Positivo.");
        } else {
            System.out.println("El número es Negativo.");
        }
        input.close();
    }
}
