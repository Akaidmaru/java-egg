import enums.Color;

public class ColorConverter {

    public static Color hexConverter(String hexValue) {
        String returnString = null;

        for (Color color : Color.values()) {
            if (hexValue.equals(color.getHexValue())) {
                return color;
            }
        }
        return null;


    }
}
