import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            double numerator =  getNumerator();
            double denominator =  getDenominator();

            double result = division(numerator, denominator);

            so

        }catch (Exception e) {
            System.out.println("");
        }
    }

    public static double getNumerator() throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un numerador: ");
        int numerator = Integer.parseInt(input.nextLine());

        if (numerator == 0){
            throw new Exception("No puedes dividir por 0");
        }
        return numerator;
    }

    public static double getDenominator() throws Exception{

        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un denominador: ");
        int denominator = Integer.parseInt(input.nextLine());

        if (denominator == 0){
            throw new Exception("No puedes dividir por 0");
        }
        return denominator;
    }

    public static double division(double numerator, double denominator){
        return numerator/ denominator;
    }
}
