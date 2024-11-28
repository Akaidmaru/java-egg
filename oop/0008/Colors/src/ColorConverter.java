import enums.Color;

public class ColorConverter {

    public static String hexConverter(String hexValue) {
        String returnString = null;

        for (Color color : Color.values()) {
            if (hexValue.equals(color.getHexValue())) {
                returnString = color.getName();
                break;
            }
        }
        return returnString;


    }
}
