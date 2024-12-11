import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ZipcodeCities zipcodeCitiesHashMap = new ZipcodeCities();

        String[][] data = {
                {"28001", "Madrid"},
                {"08001", "Barcelona"},
                {"41001", "Sevilla"},
                {"46001", "Valencia"},
                {"29001", "Málaga"},
                {"50001", "Zaragoza"},
                {"35001", "Las Palmas"},
                {"33001", "Oviedo"},
                {"24001", "León"},
                {"15001", "A Coruña"}
        };

        for (String[] datum : data) {
            zipcodeCitiesHashMap.zipcodesCities.put(Integer.parseInt(datum[0]), datum[1]);
        }

        int userOption = 0;
        do {
            System.out.println("""
                    *********MENU*********
                    1) Mostrar los datos existentes en el HashMap.
                    2) Ingresa una nueva ciudad al HashMap.
                    3) Mostrar ciudad por código postal.
                    4) Eliminar ciudad del HashMap.
                    5) Actualizar ciudad en el HashMap.
                    6) Salir
                    """);
            try {
                userOption = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException error) {
                System.out.println("Ingresa un número válido.");
                continue;
            }

            switch (userOption) {
                case 1 -> zipcodeCitiesHashMap.showItems();
                case 2 -> {
                    int zipcode = zipcodeCitiesHashMap.readValidZipCode(input);
                    if (zipcode != -1) {
                        String newCityName = zipcodeCitiesHashMap.readValidCityName(input);
                        if (newCityName != null) zipcodeCitiesHashMap.addCity(zipcode, newCityName);
                    }
                }
                case 3 -> {
                    int zipcode = zipcodeCitiesHashMap.readValidZipCode(input);
                    if (zipcode != -1) zipcodeCitiesHashMap.getCityName(zipcode);
                }
                case 4 -> {
                    int zipcode = zipcodeCitiesHashMap.readValidZipCode(input);
                    if (zipcode != -1) zipcodeCitiesHashMap.removeCity(zipcode);
                }
                case 5 -> {
                    int zipcode = zipcodeCitiesHashMap.readValidZipCode(input);
                    if (zipcode != -1) {
                        String newCityName = zipcodeCitiesHashMap.readValidCityName(input);
                        if (newCityName != null) zipcodeCitiesHashMap.updateCity(zipcode, newCityName);
                    } else {
                        System.out.println("El código postal no existe en la lista.");
                    }
                }
                case 6 -> System.out.println("Saliendo del programa");
                default -> System.out.println("Ingresa una opción válida.");
            }
        }
        while (userOption != 6);
        input.close();
    }
}

