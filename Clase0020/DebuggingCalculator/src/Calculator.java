import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userOption = 0;
        double [] arrayNumbers = new double[2];
        do{
            menu();
            userOption = input.nextInt();
            getNumbers(arrayNumbers, input);

            switch (userOption) {
                case 1: Addition(arrayNumbers);
                    break;
                case 2: Substraction(arrayNumbers);
                    break;
                case 3: Multiplication(arrayNumbers);
                    break;
                case 4: Division(arrayNumbers);
                    break;

                default: System.out.println("Opción no válida.");
                    break;
            }

        } while(userOption != 5);

        input.close();
    }

    public static void menu(){
        System.out.println("CALCULADORA");
        System.out.println("Elija la opción de acuerdo al cáluculo que desee realilzar:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Salir");
    }

    public static void getNumbers(double[] arrayNumbers, Scanner input){
        System.out.print("Por favor digite el primer número:");
        arrayNumbers[0] = input.nextDouble();
        System.out.print("Por favor digite el segundo número:");
        arrayNumbers[1] = input.nextDouble();
    }

    public static void Addition(double[] arrayNumbers){
        System.out.println("La suma del número " + arrayNumbers[0] + " y el número " + arrayNumbers[0] + " es " + (arrayNumbers[0] + arrayNumbers[1]));
    }
    public static void Substraction(double[] arrayNumbers){
        System.out.println("La resta entre el número " + arrayNumbers[0] + " y el número " + arrayNumbers[0] + " es " + (arrayNumbers[0] - arrayNumbers[1]));
    }
    public static void Multiplication(double[] arrayNumbers){
        System.out.println("La multiplicación del número " + arrayNumbers[0] + " y el número " + arrayNumbers[0] + " es " + (arrayNumbers[0] * arrayNumbers[1]));
    }
    public static void Division(double[] arrayNumbers){
        if (arrayNumbers[1] != 0){
            System.out.println("La división del número " + arrayNumbers[0] + " y el número " + arrayNumbers[0] + " es " + (arrayNumbers[0] / arrayNumbers[1]));
        }else{
            System.out.println("NO es posible la división por cero.");
        }

    }
}