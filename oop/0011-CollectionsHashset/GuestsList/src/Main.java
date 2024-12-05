import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GuestsRegister guestList = new GuestsRegister();
        int userOption = 0;
        do {
            System.out.println("""
                    *********MENU*********
                    1) Agrega invitados a la lista.
                    2) Elimina invitados de la lista.
                    3) Muestra todos los invitados en la lista.
                    4) Salir
                    """);
            try {
                userOption = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido.");
                continue;
            }

            switch (userOption) {
                case 1 -> {
                    System.out.println("Ingresa el nombre del invitado a agregar: ");
                    String name = input.nextLine();
                    guestList.addGuest(name);
                }
                case 2 -> {
                    System.out.println("Ingresa el nombre del invitado a eliminar: ");
                    String name = input.nextLine();
                    guestList.deleteGuest(name);
                }
                case 3 -> guestList.showGuests();
                case 4 -> System.out.println("Saliendo del programa");
                default -> System.out.println("Ingresa una opción válida.");
            }

        } while (userOption != 4);
        input.close();
    }
}

