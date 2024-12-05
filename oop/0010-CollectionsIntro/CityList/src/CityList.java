import java.util.ArrayList;
import java.util.Scanner;

public class CityList {
    static ArrayList<String> cityList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static boolean flag = true;

    public static void main(String[] args) {
        do {
            System.out.println("""
                    *********MENU********* 
                    1) Ingresa una ciudad.
                    2) Ver lista de ciudades.
                    3) Salir.
                    """);
            int userOption = Integer.parseInt(input.nextLine());

            switch(userOption){
                case 1 ->{
                    System.out.println("Ingresa una ciudad: ");
                    String userCity = input.nextLine();
                    cityList.add(userCity);
                }
                case 2 -> {
                    for (String s : cityList) {
                        System.out.println(s);
                    }
                }
                case 3 -> {
                    flag = false;
                }
                default ->{
                    System.out.println("Ingresa una opción válida.");
                }
            }

        } while(flag);
    }
}
