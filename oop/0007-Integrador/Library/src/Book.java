public class Book extends LibraryItem implements Classifiable {
    private String title;
    private String author;
    private int numberOfPage;



    @Override
    public String lendBook() {
        return "";
    }

    @Override
    public String returnBook() {
        return "";
    }

    @Override
    public String fineCalculation() {
        return "";
    }

    @Override
    public String getInformation() {
        return "";
    }
}
