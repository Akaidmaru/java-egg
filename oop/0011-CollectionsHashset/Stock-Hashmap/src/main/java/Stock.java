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

    public String getAllItems() {
        StringBuilder stringBuilder = new StringBuilder();
        if (inventory.isEmpty()) {
            return "Inventory is empty!";
        }
        stringBuilder.append("*********Inventory*********\n");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            stringBuilder.append(entry.getKey() + " " + entry.getValue() + "\n");
        }
        return stringBuilder.toString();
    }


    public String normalizeName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        name = name.trim();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();

    }

}