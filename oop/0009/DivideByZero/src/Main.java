import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner input = new Scanner(System.in);
            double numerator =  getNumerator(input);
            double denominator =  getDenominator(input);

            double result = division(numerator, denominator);

            System.out.println("El resultado es: " + result);
        }catch (Exception e) {
            System.out.println("Error fatal: " + e.getMessage());
        }
    }

    public static double getNumerator(Scanner input) throws Exception{;
        System.out.println("Ingresa un numerador: ");
        double numerator = Double.parseDouble(input.nextLine());
        if (numerator == 0){
            throw new Exception("El numerador no puede ser 0");
        }
        return numerator;
    }

    public static double getDenominator(Scanner input) throws Exception{

        System.out.println("Ingresa un denominador: ");
        double denominator = Double.parseDouble(input.nextLine());

        if (denominator == 0){
            throw new Exception("El denominador no puede ser 0");
        }
        return denominator;
    }

    public static double division(double numerator, double denominator){
        return numerator/ denominator;
    }
}
