import java.util.Scanner;

public class ConversionCalificaciones {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una calificación del 1 al 5: ");
        int calificacionUsuario = input.nextInt();

        switch(calificacionUsuario){
            case 1-> System.out.println("Muy deficiente");
            case 2-> System.out.println("Deficiente");
            case 3-> System.out.println("Suficiente");
            case 4-> System.out.println("Notable");
            case 5-> System.out.println("Sobresaliente");
            default -> System.out.println("Ingresaste un valor fuera del rango.");
        }
    }
}
