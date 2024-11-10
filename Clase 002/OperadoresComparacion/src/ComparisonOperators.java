import java.util.Scanner;

public class ComparisonOperators {
    public static void main(String[] args) {
        int num1, num2, num3, num4;
        boolean isGreater;
        boolean isGreater2;
        boolean isEqual;
        boolean isDivible;

        Scanner inputNum1 = new Scanner(System.in);
        Scanner inputNum2 = new Scanner(System.in);

        System.out.println("Ingresa un primer número: ");
        num1 = inputNum1.nextInt();
        System.out.println("Ingresa un segundo número: ");
        num2 = inputNum2.nextInt();

        isGreater = num1 > num2;
        isEqual = num1 == num2;
        isDivible = (num1 % 2) == 0;
        System.out.println("El número " + num1 + " es mayor al " + num2 + "? = " + isGreater);
        System.out.println("El número " + num1 + " es igual al " + num2 + "? = " + isEqual);
        System.out.println("El número " + num1 + " es divisible por 2? = " + isDivible);

        System.out.println("Ingresa otros dos números, vamos con el primero: ");
        num3 = inputNum1.nextInt();
        System.out.println("Ahora, vamos con el segundo número: ");
        num4 = inputNum2.nextInt();

        isGreater = (num1 > num2) && (num3 > num4);
        isGreater2 = (num1 > num2) || (num3 > num4);
        // Ternary operator
        String resultado = (num1 > num2) && (num3 > num4) ? "Sí se cumple la concidicón": "No se cumple la condición";
        // condicion ? retorna verdadero : retorna falso

        System.out.println("Is Greater 1: " + isGreater);
        System.out.println("Is Greater 2: " + isGreater2);



        inputNum1.close();
        inputNum2.close();
    }
}
