import java.util.Scanner;

public class Option {
    public static void main(String[] args) {
        System.out.println("""
                Opción 1: \"Guardar\"
                Opción 2: \"Cargar\"
                Opción 3: \"Salir\"
                """);
        Scanner input = new Scanner(System.in);
        int opcionUsuario = input.nextInt();

        switch(opcionUsuario) {
            case 1 -> System.out.println("Partida guardada!");
            case 2 -> System.out.println("Partida Cargada!");
            case 3 -> System.out.println("Has salido del programa.");
            default -> System.out.println("Opción errónea.");
        }
        input.close();
    }
}
