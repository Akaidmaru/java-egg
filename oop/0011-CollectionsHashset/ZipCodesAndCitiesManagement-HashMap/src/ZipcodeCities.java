import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ZipcodeCities {
    HashMap<Integer, String> zipcodesCities;

    public ZipcodeCities() {
        zipcodesCities = new HashMap<>();
    }

    public void showItems() {
        if (zipcodesCities.isEmpty()) {
            System.out.println("La lista está vacía, no hay nada que mostrar");
            return;
        }
        System.out.println("*********Lista de Zipcodes y Ciudades*********");
        for (Integer element : zipcodesCities.keySet()) {
            System.out.println("Zipcode: " + element + ", Ciudad: " + zipcodesCities.get(element));
        }
    }

    public String normalizeName(String name) {
        return Arrays.stream(name.strip().toLowerCase().split(" ")).map(word -> word.substring(0, 1).toUpperCase()
                + word.substring(1)).collect(Collectors.joining(" "));
    }

    public void addCity(int zipcode, String cityName) {
        if(zipcodesCities.containsKey(zipcode)){
            printError("El código postal ya está registrado con la ciudad: " + zipcodesCities.get(zipcode));
            return;
        }
        cityName = normalizeName(cityName);
        zipcodesCities.put(zipcode, cityName);
        System.out.println("Ciudad agregada: " + cityName + ", con código postal: " + zipcode);
    }

    public void getCityName(int zipcode) {
        if (!zipcodesCities.containsKey(zipcode)) {
            System.out.println("El código postal " + zipcode + " no existe.");
            return;
        }
        String result = zipcodesCities.get(zipcode);
        System.out.println("La ciudad con el código postal " + zipcode + " es: " + result);
    }

    public void removeCity(int zipcode) {
        if (!zipcodesCities.containsKey(zipcode)) {
            System.out.println("El código postal " + zipcode + " no existe.");
            return;
        }
        String result = zipcodesCities.get(zipcode);
        zipcodesCities.remove(zipcode);
        System.out.println(result + " ha sido eliminada.");
    }

    public void updateCity(int zipcode, String newCityName) {
        try {
            if (!zipcodesCities.containsKey(zipcode)) {
                System.out.println("El código postal " + zipcode + " no existe.");
                return;
            }
            String oldCityName = zipcodesCities.get(zipcode);
            newCityName = normalizeName(newCityName);
            zipcodesCities.replace(zipcode, newCityName);
            System.out.println(oldCityName + " ha cambiado a: " + newCityName);
        } catch (NumberFormatException error) {
            System.out.println("El código postal debe contener solamente números: " + error.getMessage());
        }
    }

    public boolean isValidZipcode(int zipcode){
        return zipcode >= 1000 && zipcode <= 99999;
    }

    public void printError(String message){
        System.out.println("[ERROR]: " + message);
    }

    public int readValidZipCode(Scanner input){
        try {
            System.out.println("Ingresa el código postal: ");
            int zipcode = Integer.parseInt(input.nextLine());
            if(isValidZipcode(zipcode)) {
                return zipcode;
            } else {
                printError("Ingresa un código postal entre el rango de 1000 a 99999");
            }
        } catch (NumberFormatException error) {
            printError("El código postal debe contener solamente números.");
        }
        return -1;
    }

    public String readValidCityName(Scanner input){
        System.out.println("Ingresa el Nombre de la ciudad: ");
        String cityName = input.nextLine();
        if (cityName.isBlank() || cityName.isEmpty()) {
            printError("Ingresa un nombre de ciudad válido. No puede estar en blanco ni ser nulo.");
            return null;
        } else {
            return normalizeName(cityName);
        }
    }
}
