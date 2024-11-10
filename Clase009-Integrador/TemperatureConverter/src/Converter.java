import java.util.InputMismatchException;
import java.util.Scanner;

public class Converter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.println("Ingresa la temperatura: ");
            float temperature = input.nextFloat();
            input.nextLine();

            System.out.println("Ingresa la unidad de medida (C/F): ");
            String measure = input.nextLine();
            input.close();
            float result = 0;
            if (measure.equalsIgnoreCase("C")) {
                result = (temperature - 32) * 5 / 9;
                System.out.println(temperature + " grados Celsisus equivale a: " + result);
            } else if (measure.equalsIgnoreCase("F")) {
                result = (temperature * 9 / 5) + 32;
                System.out.println(temperature + " grados Farenheit equivale a: " + result);
            } else {
                System.out.println("Error: Unidad de medida no válida. Ingrese C para Celsius o F para Fahrenheit.");
            }
        } catch (InputMismatchException error) {
            System.out.println("Error: Temperatura no válida. Ingrese una temperatura numérica.");
        }
    }
}