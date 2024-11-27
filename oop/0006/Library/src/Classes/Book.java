package Classes;

import Interface.Classifiable;

public class Book extends LibraryItem implements Classifiable {
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

    @Override
    public String getInformation() {
        return "";
    }
}
