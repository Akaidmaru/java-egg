package classes;

import java.util.Arrays;

public class Library {
    private int bookCounter = 0;

    Book[] booksArray = new Book[5];

    public void addBook(Book book) {
        if (booksArray.length <= bookCounter) {
            int newSize = booksArray.length * 2;
            booksArray = Arrays.copyOf(booksArray, newSize);
        }
        booksArray[bookCounter] = book;
        bookCounter++;
    }

    public void showAllBooksInfo(){
        for(Book book: booksArray){
            book.showInformation();
        }
    }
}

