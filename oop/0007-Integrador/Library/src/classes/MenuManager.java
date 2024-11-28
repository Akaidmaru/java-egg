package classes;

import java.util.Scanner;

public class MenuManager {
    private Scanner input;
    private Library library;

    public MenuManager() {
        this.input = new Scanner(System.in);
        this.library = new Library();
    }

    public void menu(){
        int userOption;
        do {
            System.out.println("""
        *********Menú*********
        1) Añadir un libro
        2) Mostrar información de los libros
        3) Salir
        """);
            userOption = Integer.parseInt(input.nextLine());
            switch (userOption){
                case 1 -> {
                    System.out.println("Ingresa el nombre del libro:");
                    String bookName = input.nextLine();
                    System.out.println("Ingresa el nombre del autor:");
                    String bookAuthor = input.nextLine();
                    System.out.println("Ingresa el número de páginas:");
                    int bookPagesNumber = Integer.parseInt(input.nextLine());
                    Book userBook = new Book(bookName, bookAuthor, bookPagesNumber);
                    library.addBook(userBook);
                }
                case 2 -> library.showAllBooksInfo();
                case 3 -> System.out.println("Exiting");
                default -> System.out.println("Not a valid option. Try again.");
            }
        }while (userOption != 3);

    }
}
