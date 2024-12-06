import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library catalog1 = new Library();
        int userOption = 0;
        do {
            System.out.println("""
                    *********MENU*********
                    1) Agrega un libro al catálogo de libros.
                    2) Elimina un libro del catálogo de libros.
                    3) Muestra todos los libros del catálogo.
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
                    System.out.println("Ingresa el título del invitado a agregar: ");
                    String title = input.nextLine();
                    System.out.println("Ingresa el autor del libro: ");
                    String author =input.nextLine();
                    System.out.println("Ingresa el ISBN del libro: ");
                    int isbn = Integer.parseInt(input.nextLine());
                    Book book = new Book(isbn, author, title);
                    catalog1.addBook(book);
                }
                case 2 -> {
                    System.out.println("Ingresa el ISBN del libro a eliminar: ");
                    int isbn = Integer.parseInt(input.nextLine());
                    if (catalog1.deleteBook(isbn)) {
                        System.out.println("El libro ha sido eliminado");
                    } else {
                        System.out.println("El libro no existe en el catálogo.");
                    }
                }
                case 3 -> catalog1.showBooksCatalog();
                case 4 -> System.out.println("Saliendo del programa");
                default -> System.out.println("Ingresa una opción válida.");
            }

        } while (userOption != 4);
        input.close();
    }
}

