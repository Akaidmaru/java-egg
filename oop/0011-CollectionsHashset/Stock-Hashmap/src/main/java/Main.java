public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();

        stock.addItem("Nintendo Switch", 10);
        stock.addItem("PS5", 5);
        stock.addItem("GBA ", 3);
        stock.addItem("Fridge", 25);
        stock.addItem("Laptop", 4);
        stock.addItem("Cream", 9);

        stock.getItemStock("Celeste");
        stock.getItemStock("GBA");

        stock.getAllItems();

        stock.updateItem("SwiTCH", 11);
        stock.updateItem("Nintendo Switch", 25);

        stock.getItemStock("Nintendo SwiTch");

    }
}
