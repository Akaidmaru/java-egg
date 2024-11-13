import java.util.Scanner;

public class CalculaAreaPerimetro {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("""
                Selecciona una opción:
                1) "Círculo"
                2) "Rectángulo"
                """);
        int opcionUsuario = input.nextInt();
        switch(opcionUsuario){
            case 1 ->{
                System.out.println("""
                        Seleccionaste círculo, ¡Perfecto!
                        Ahora, ingresa un valor para el radio:
                        """);

            }
            case 2 -> {

            }
            default -> System.out.println("Opción no válida.");
        }
    }
}
