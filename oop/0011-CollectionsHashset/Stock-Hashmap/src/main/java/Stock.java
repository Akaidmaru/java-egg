import java.util.HashMap;
import java.util.Map;


public class Stock {
    private HashMap<String, Integer> inventory;

    public Stock() {
        inventory = new HashMap<>();
    }

    public String addItem(String name, Integer stock) {
        if (stock == null || stock < 0) {
            return "Stock must be a positive integer.";
        }
        name = normalizeName(name);
        inventory.put(name, stock);
        return name + " was added. Stock is: " + stock + " item(s).";
    }

    public String updateItem(String name, Integer stock) {
        if (stock == null || stock < 0) {
            return "Stock must be a positive integer.";
        }
        name = normalizeName(name);
        if (!inventory.containsKey(name)) {
            return name + " is not in inventory. Try adding it first.";

        }
        inventory.replace(name, stock);
        return name + " was updated. Stock is: " + stock + " item(s).";
    }


    public String updateStock(String name, Integer stock) {
        if (stock == null || stock < 0) {
            return "Stock must be a positive integer.";
        }
        name = normalizeName(name);
        if (!inventory.containsKey(name)) {
            return name + " is not in inventory. Try adding it first.";
        }
        inventory.put(name, inventory.get(name) + stock);
        return name + " stock incremented: " + stock + ". Total: " + inventory.get(name);
    }

    public String getItemStock(String name) {
        if (inventory.isEmpty()) {
            return "Inventory is empty!";
        }
        name = normalizeName(name);
        if (!inventory.containsKey(name)) {
            return name + " is not in inventory. Try adding it first.";
        }
        Integer result = inventory.get(name);
        return name + " has " + result + " item(s) in stock.";
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