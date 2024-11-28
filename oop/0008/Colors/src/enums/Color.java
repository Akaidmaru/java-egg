package enums;

public enum Color {
    RED("ROJO","#FF0000"),
    YELLOW("YELLOW","#FFFF00"),
    BLUE("BLUE", "#0000FF");

    private String name;
    private String hexValue;

    Color(String name, String hexValue) {
        this.name = name;
        this.hexValue = hexValue;
    }

    public String getName() {
        return name;
    }

    public String getHexValue() {
        return hexValue;
    }


}
