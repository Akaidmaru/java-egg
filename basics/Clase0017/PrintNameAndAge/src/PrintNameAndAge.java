import java.util.Scanner;

public class PrintNameAndAge {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nombre = getName(input);
        int edad = getAge(input);

        printNameAndAge(nombre, edad);
    }

    public static String getName(Scanner inputName){
        System.out.println("Ingresa tu nombre: ");
        return inputName.nextLine();
    }
    public static int getAge(Scanner inputAge){
        System.out.println("Ingresa tu edad: ");
        return inputAge.nextInt();
    }
    public static void printNameAndAge(String name, int age){
        System.out.println("Tu nombre es: " + name + ". Tu edad es: " + age);
    }
}
