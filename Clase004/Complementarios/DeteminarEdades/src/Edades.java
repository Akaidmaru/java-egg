import java.util.Scanner;

public class Edades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa tu edad: ");
        int edadUsuario = input.nextInt();

        if (edadUsuario < 18 && edadUsuario >= 0){
            System.out.println("Eres menor de edad.");
        } else if (edadUsuario >= 18 && edadUsuario <= 64 ) {
            System.out.println("Eres adulto.");
        } else if (edadUsuario >= 65) {
            System.out.println("Eres unn adulto mayor.");
        } else {
            System.out.println("Ingresa una edad válida");
        }
        input.close();
    }
}
