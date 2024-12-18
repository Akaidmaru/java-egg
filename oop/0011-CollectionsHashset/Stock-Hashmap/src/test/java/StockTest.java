import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {
    Stock test1 = new Stock();

    @Test
    void addItem() {
        String result1 = "Robot was added. Stock is: 10 item(s).";
        String result2 = "Stock must be a positive integer.";
        assertEquals(result1, test1.addItem("roBot", 10));
        assertEquals(result2, test1.addItem("Jelly", -1));
    }

    @Test
    void updateItem() {
        String result1 = "Robot was updated. Stock is: 5 item(s).";
        String result2 = "Stock must be a positive integer.";
        String result3 = "Gundam is not in inventory. Try adding it first.";
        test1.addItem("roBot", 10);
        assertEquals(result1, test1.updateItem("roBot", 5));
        assertEquals(result2, test1.updateItem("Jelly", -1));
        assertEquals(result3, test1.updateItem("Gundam", 10));

    }

    @Test
    void updateStock() {
        String result1 = "Robot was updated. Stock is: 10 item(s).";
        String result2 = "Stock must be a positive integer.";
        String result3 = "Gundam is not in inventory. Try adding it first.";
        test1.updateStock("roBot", 10);
        assertEquals(result1, test1.updateItem("roBot", 5));
        assertEquals(result2, test1.updateItem("Jelly", -1));
        assertEquals(result3, test1.updateItem("Gundam", 10));

    }

    @Test
    void getItemStock() {
    }

    @Test
    void getAllItems() {
    }

    @Test
    void normalizeName() {
    }
}