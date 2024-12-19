public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();

        System.out.println(stock.addItem("Nintendo Switch", 10));
        System.out.println(stock.addItem("PS5", 5));
        System.out.println(stock.addItem("GBA ", 3));
        System.out.println(stock.addItem("Fridge", 25));
        System.out.println(stock.addItem("Laptop", 4));
        System.out.println(stock.addItem("Cream", 9));

        System.out.println(stock.getItemStock("Celeste"));
        System.out.println(stock.getItemStock("GBA"));

        System.out.println(stock.getAllItems());

        System.out.println(stock.updateItem("SwiTCH", 11));
        System.out.println(stock.updateItem("Nintendo Switch", 25));

        System.out.println(stock.getItemStock("Nintendo SwiTch"));

    }
}
