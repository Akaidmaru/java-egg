import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fullname;
        try {
            fullname = askNameLastname();
            System.out.println("Saludos " + fullname);
        } catch(Exception error) {
            System.out.println("Error: " + error.getMessage());


    }
    }

    public static String askNameLastname()   {
        Scanner input = new Scanner(System.in);
        String name;
        String lastname;
        try {
            System.out.println("Type your name: ");
            name = input.nextLine();
            if (name.length() <= 2) {
                throw new IllegalArgumentException("El nombre debe tener más de dos caracteres.");
            }
            System.out.println("Type your Lastname: ");
            lastname = input.nextLine();
        } finally {
            input.close();
        }
        return name + " " + lastname;
    }
}