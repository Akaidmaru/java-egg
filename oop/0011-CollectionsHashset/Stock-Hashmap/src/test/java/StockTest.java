import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StockTest {
    Stock test1 = new Stock();

    @Test
    void addItem() {
        String expected1 = "Robot was added. Stock is: 10 item(s).";
        String expected2 = "Stock must be a positive integer.";
        test1.addItem("roBot", 10);
        assertEquals(expected1, test1.addItem("roBot", 10));
        assertEquals(expected2, test1.addItem("Jelly", -1));
    }

    @RepeatedTest(5)
    void repeatedAddItemTest() {
        String name = "Item" + Math.random();
        int stock = (int) (Math.random() * 100) + 1;
        String expected = name + " was added. Stock is: " + stock + " item(s).";
        assertEquals(expected, test1.addItem(name, stock));
    }

    @Test
    void updateItem() {
        String expected1 = "Robot was updated. Stock is: 5 item(s).";
        String expected2 = "Stock must be a positive integer.";
        String expected3 = "Gundam is not in inventory. Try adding it first.";
        test1.addItem("roBot", 10);
        assertEquals(expected1, test1.updateItem("roBot", 5));
        assertEquals(expected2, test1.updateItem("Jelly", -1));
        assertEquals(expected3, test1.updateItem("Gundam", 10));

    }

    @Test
    void updateStock() {
        String expected1 = "Robot was updated. Stock is: 10 item(s).";
        String expected2 = "Stock must be a positive integer.";
        String expected3 = "Gundam is not in inventory. Try adding it first.";
        test1.addItem("roBot", 10);
        assertEquals(expected1, test1.updateStock("roBot", 10));
        assertEquals(expected2, test1.updateStock("Jelly", -1));
        assertEquals(expected3, test1.updateStock("Gundam", 10));

    }

    @Test
    void getItemStock() {
        String expected1 = "Inventory is empty!";
        String expected2 = "Gundam is not in inventory. Try adding it first.";
        String expected3 = "Robot has 10 item(s) in stock.";
        assertEquals(expected1, test1.getItemStock("Gundam"));
        test1.addItem("roBot", 10);
        assertEquals(expected2, test1.getItemStock("Gundam"));
        assertEquals(expected3, test1.getItemStock("RoBot"));
    }

    @Test
    void normalizeName() {
        String expected2 = "Robot";
        assertThrows(IllegalArgumentException.class, () -> test1.normalizeName(" "));
        assertEquals(expected2, test1.normalizeName("roBoT"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"roBot", "ROBOt", "rOBOT", "RobOT"})
    void parameterizedNormalizeName(String input){
        assertEquals("Robot", test1.normalizeName(input));
    }

    @Test
    void getAllItems() {
        String expected1 = "Inventory is empty!";
        String expected2 = "*********Inventory*********\nRobot 10\n";
        assertEquals(expected1, test1.getAllItems());
        test1.addItem("roBot", 10);
        assertEquals(expected2, test1.getAllItems());

    }
}