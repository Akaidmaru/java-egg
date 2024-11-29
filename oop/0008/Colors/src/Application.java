import enums.Color;

public class Application {

    public static void main(String[] args) {

        String[] colorsArray = {
                "#FFFF00",
                "verde",
                "#0000FF",
                "#FF0000",
                "naranja"
        };


        for(String hexValue : colorsArray){
            Color color = ColorConverter.hexConverter(hexValue);
            if(color != null){
                System.out.println(color.getName() + " es un color primario.");
            } else {
                System.out.println(hexValue + " no es un color primario");
            }
        }
    }
}
