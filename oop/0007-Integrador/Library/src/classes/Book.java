package classes;

import Interface.Classifiable;

public class Book extends LibraryItem implements Classifiable {
    private String title;
    private String author;
    private int pagesNumber;

    public Book() {
    }

    public Book(String title, String author, int pagesNumber) {
        this.title = title;
        this.author = author;
        this.pagesNumber = pagesNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    @Override
    public String lendItem() {
        return "";
    }

    @Override
    public String returnItem() {
        return "";
    }

    @Override
    public String fineCalculation() {
        return "";
    }


    public String showInformation(){
        return String.format("""
                --------Book information--------
                Title: %s
                Author: %s
                Number of pages: %d
                --------------------------------
                """,this.getTitle(), this.getAuthor(), this.getPagesNumber());
    }

    @Override
    public String getInformation() {
        return "";
    }
}
