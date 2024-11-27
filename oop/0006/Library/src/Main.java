import Classes.Magazine;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Magazine[] magazinesArray = {
                new Magazine(2, 5, "Popular Mechanics"),
                new Magazine(7, 1, "VCG"),
                new Magazine(2, 3, "People"),
                new Magazine(40, 1, "Nintendo Magazine")
        };


        System.out.println(magazinesArray[0].lendItem());
        System.out.println(magazinesArray[1].lendItem());
        System.out.println(magazinesArray[2].lendItem());
        System.out.println(magazinesArray[3].lendItem());
        System.out.println(magazinesArray[3].getLendingDate());
        magazinesArray[3].setReturnDate(LocalDate.of(2024, 12, 10));
        System.out.println(magazinesArray[3].fineCalculation());
        System.out.println(magazinesArray[3].getInformation());


    }
}
