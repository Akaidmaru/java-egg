import java.util.Scanner;

public class BasicOps {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 10;
        int resultadoSum = num1 + num2;
        int resultadoRes = num1 - num2;
        int resultadoMul = num1 * num2;
        double resultadoDiv = num1 / num2;
        System.out.println("La suma de " +  num1 + " y " + num2 + " es: " + resultadoSum);
        System.out.println("La resta de " +  num1 + " y " + num2 + " es: " + resultadoRes);
        System.out.println("La multiplación de " +  num1 + " y " + num2 + " es: " + resultadoMul);
        System.out.println("La división de " +  num1 + " y " + num2 + " es: " + resultadoDiv);

        Scanner inputUsuario1 = new Scanner(System.in);
        System.out.println("Ingresa un primer número: ");
        num1 = inputUsuario1.nextInt();

        Scanner inputUsuario2 = new Scanner(System.in);
        System.out.println("Ingresa un segundo número: ");
        num2 = inputUsuario2.nextInt();

        resultadoSum = num1 + num2;
        System.out.println("El resultado de la suma del usuario es: " + resultadoSum);
        inputUsuario1.close();
        inputUsuario2.close();
    }
}
