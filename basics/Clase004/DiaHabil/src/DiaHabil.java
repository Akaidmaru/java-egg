import java.util.Scanner;

public class DiaHabil {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un número del 1 al 7: ");
        int diaUsuario = input.nextInt();

        switch(diaUsuario){
            case 1, 2, 3, 4, 5 -> System.out.println("Es un día hábil");
            case 6, 7 -> System.out.println("No es un día hábil");
            default -> System.out.println("Valor fuera del rango.");
        }
        input.close();
    }
}
