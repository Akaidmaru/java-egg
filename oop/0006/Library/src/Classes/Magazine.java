package Classes;
import Interface.Classifiable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Magazine extends LibraryItem implements Classifiable {
    private int editionNumber;
    private int issuesQuantity;
    private String magazineName;
    private LocalDate lendingDate;
    private LocalDate returnDate;

    public Magazine() {
    }

    public Magazine(int editionNumber, int issuesQuantity, String magazineName) {
        this.editionNumber = editionNumber;
        this.issuesQuantity = issuesQuantity;
        this.magazineName = magazineName;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public int getIssuesQuantity() {
        return issuesQuantity;
    }

    public void setIssuesQuantity(int issuesQuantity) {
        this.issuesQuantity = issuesQuantity;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(LocalDate lendingDate) {
        this.lendingDate = lendingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String lendItem() {
        if (issuesQuantity == 0){
            return "We cannot lend you the magazine, there are no more issues.";
        } else {
            issuesQuantity--;
            this.lendingDate = LocalDate.now();
            return "Here, you can have this issue. There are: " + issuesQuantity + " issues left.";
        }
    }

    @Override
    public String returnItem() {
        issuesQuantity++;
        this.returnDate = LocalDate.now();
        return "Thank you for returning " + magazineName + ". Now there are: " + issuesQuantity + " issues in stock.";
    }

    @Override
    public String fineCalculation() {
        if (lendingDate == null || returnDate == null) {
            return "We can't calculate the fine. We are missing either the lent date or the return date";
        }

        long deltaDays = ChronoUnit.DAYS.between(lendingDate, returnDate);

        if (deltaDays <= 7) {
            return "You are within the return date range, so, no fine for you.";
        } else {
            long daysLate = deltaDays - 7;
            double fine = daysLate * 1.0; // $1 per day late
            return String.format("The fine for being late: $%.2f (%d late days)", fine, daysLate);
        }
    }

    @Override
    public String getInformation() {
        return "Magazine{" +
                "magazineName='" + magazineName + '\'' +
                ", issuesQuantity=" + issuesQuantity +
                ", editionNumber=" + editionNumber +
                '}';
    }

}
