public class Book {
    private String title;
    private String author;
    private int isbn;

    public Book() {
    }

    public Book(int ISBN, String author, String title) {
        this.isbn = ISBN;
        this.author = normalizeName(author);
        this.title = normalizeName(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = normalizeName(title);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = normalizeName(author);
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        try {
            this.isbn = isbn;
        } catch (IllegalArgumentException error){
            System.out.println("Ingresa un ISBN correcto. " + error.getMessage());
        }

    }

    @Override
    public int hashCode() {
        return Integer.hashCode(isbn);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return isbn == book.isbn;
    }

    @Override
    public String toString() {
        return "Título: " + title + ", Autor: " + author + ", ISBN=" + isbn;
    }

    public String normalizeName(String name) {
        return name.strip().toLowerCase();
    }
}
