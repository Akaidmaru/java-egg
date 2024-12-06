import java.util.HashSet;

public class Library {
    private HashSet<Book> booksCatalog;

    public Library() {
        this.booksCatalog = new HashSet<>();
    }

    public HashSet<Book> getBooksCatalog() {
        return new HashSet<>(booksCatalog);
    }

    public void addBook(Book book){
        if(this.booksCatalog.contains(book)){
            System.out.println(book.getTitle() + " ya existe.");
            return;
        }
        booksCatalog.add(book);
        System.out.println(book.getTitle() + " ha sido agregado.");

    }

    public boolean deleteBook(int isbn){
        if (booksCatalog.isEmpty()){
            System.out.println("El catálogo está vacío. No hay libros para eliminar.");
            return false;
        }
        return booksCatalog.removeIf(book -> book.getIsbn() == isbn);
    }

    public void showBooksCatalog(){
        if(booksCatalog.isEmpty()){
            System.out.println("El catálogo está vacío.");
            return;
        }
        int counter = 1;
        System.out.println("*********Books' Catalog*********");
        for (Book book : booksCatalog) {
            System.out.println(counter++ + ") "+ book.toString());
        }
    }

}
