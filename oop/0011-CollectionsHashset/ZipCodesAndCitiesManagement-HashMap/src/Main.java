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
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número válido.");
                continue;
            }

            switch (userOption) {
                case 1 -> zipcodeCitiesHashMap.showItems();
                case 2 -> {
                    System.out.println("Ingresa el código postal de la ciudad: ");
                    int zipcode = Integer.parseInt(input.nextLine());
                    System.out.println("Ingresa el Nombre de la ciudad: ");
                    String cityName = input.nextLine();
                    zipcodeCitiesHashMap.addCity(zipcode, cityName);
                }
                case 3 -> {
                    System.out.println("Ingresa el código postal de la ciudad: ");
                    int zipcode = Integer.parseInt(input.nextLine());
                    zipcodeCitiesHashMap.getCityName(zipcode);
                }
                case 4 -> {
                    System.out.println("Ingresa el código postal de la ciudad que deseas eliminar: ");
                    int zipcode = Integer.parseInt(input.nextLine());
                    zipcodeCitiesHashMap.removeCity(zipcode);
                }
                case 5 -> {
                    System.out.println("Ingresa el código postal de la ciudad que deseas actualizar: ");
                    int zipcode = Integer.parseInt(input.nextLine());
                    String result = zipcodeCitiesHashMap.zipcodesCities.get(zipcode);

                    if(zipcodeCitiesHashMap.zipcodesCities.containsKey(zipcode)) {
                        System.out.println(result + " es la ciudad actual. Ingresa el nuevo nombre para actualizarlo: ");
                        String newCityName = zipcodeCitiesHashMap.normalizeName(input.nextLine());
                        zipcodeCitiesHashMap.zipcodesCities.replace(zipcode, newCityName);
                        System.out.println(result + " ha sido cambiada a: " + newCityName);
                    } else {
                        System.out.println("El código postal " + zipcode + " no existe.");
                    }
                }
                case 6 -> System.out.println("Saliendo del programa");
                default -> System.out.println("Ingresa una opción válida.");
            }

        } while (userOption != 6);
        input.close();
    }
}

