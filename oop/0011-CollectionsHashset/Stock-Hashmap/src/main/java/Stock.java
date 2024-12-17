import java.util.HashMap;
import java.util.Map;


public class Stock {
    private HashMap<String, Integer> inventory;

    public Stock() {
        inventory = new HashMap<>();
    }

    public void addItem(String name, Integer stock) {
        if (stock == null || stock < 0) {
            System.out.println("Stock must be a positive integer.");
            return;
        }
        name = normalizeName(name);
        inventory.put(name, stock);
        System.out.println(name + " was added. Stock is: " + stock + " item(s).");
    }

    public void updateItem(String name, Integer stock) {
        if (stock == null || stock < 0) {
            System.out.println("Stock must be a positive integer.");
            return;
        }
        name = normalizeName(name);
        if (!inventory.containsKey(name)) {
            System.out.println(name + " is not in inventory. Try adding it first.");
            return;
        }
        inventory.replace(name, stock);
        System.out.println(name + " was updated. Stock is: " + stock + " item(s).");
    }


    public void updateStock(String name, Integer stock) {
        if (stock == null || stock < 0) {
            System.out.println("Stock must be a positive integer.");
            return;
        }
        name = normalizeName(name);
        if (!inventory.containsKey(name)) {
            System.out.println(name + " is not in inventory. Try adding it first.");
            return;
        }
        inventory.put(name, inventory.get(name) + stock);
        System.out.println(name + " stock incremented: " + stock + ". Total: " + inventory.get(name));
    }

    public void getItemStock(String name) {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }
        name = normalizeName(name);
        if (!inventory.containsKey(name)) {
            System.out.println(name + " is not in inventory. Try adding it first.");
            return;
        }
        Integer result = inventory.get(name);
        System.out.println(name + " has " + result + " item(s) in stock.");
    }

    public void getAllItems() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty!");
        } else {
            System.out.println("""
                    *********Inventory*********
                    Item Name--------Stock
                    """);
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    public String normalizeName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        return name.trim().substring(0, 1).toUpperCase() +
                name.trim().substring(1).toLowerCase();

    }

}