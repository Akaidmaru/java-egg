import java.util.Scanner;

public class SquareMaker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el tamaño del lado del cuadrado: ");
        int userNumber = input.nextInt();
        input.close();

        for (int i = 0; i < userNumber; i++) {

            for (int j = 0; j < userNumber; j++) {

                if ((i == 0) || (i == userNumber - 1) || (j == 0) || (j == userNumber - 1)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
    }
}
}
