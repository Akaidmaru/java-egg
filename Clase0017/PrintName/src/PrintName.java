import java.util.Scanner;

public class PrintName {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un nombre: ");
        String name = input.nextLine();
        printName(name);

        System.out.println("Ingresa una edad: ");
        int age = input.nextInt();
        printNameAndAge(name, age);
    }

    public static void printName(String name){
        System.out.println("Tu nombre es: " + name);
    }

    public static void printNameAndAge(String name, int age) {
        System.out.println("Tui nombre es: " + name + ". Y tu edad es: " + age);
    }
}
