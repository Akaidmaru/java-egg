package Classes;
import Interface.Classifiable;

public class Magazine extends LibraryItem implements Classifiable {
    private int editionNumber;
    private int issuesQuantity;
    private String magazineName;

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

    @Override
    public String lendItem() {
        if (issuesQuantity == 0){
            return "We cannot lend you the magazine, there are no more issues.";
        } else {
            issuesQuantity--;
            return "Here, you can have this issue. There are: " + issuesQuantity + " issues left.";
        }

    }

    @Override
    public String returnItem() {
        issuesQuantity++;
        return "Thank you for returning " + magazineName + ". Now there are: " + issuesQuantity + " issues in stock.";
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
