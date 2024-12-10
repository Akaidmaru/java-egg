import java.util.HashMap;

public class ZipcodeCities {
    HashMap<Integer, String> zipcodesCities;

    public ZipcodeCities() {
        zipcodesCities = new HashMap<>();
    }

    public void showItems(){
        System.out.println("*********Lista de Zipcodes y Ciudades*********");
        for (Integer element : zipcodesCities.keySet()) {
            System.out.println("Zipcode: " + element + ", Ciudad: " + zipcodesCities.get(element));
        }
    }

    public String normalizeName(String name){
        return name.strip().toLowerCase();
    }

    public void addCity(int zipcode, String cityName){
        System.out.println("Ingresa el Nombre de la ciudad: ");
        cityName = normalizeName(cityName);
        zipcodesCities.put(zipcode, cityName);
    }

    public void getCityName(int zipcode){
        String result = zipcodesCities.get(zipcode);
        System.out.println("La ciudad con el código postal " + zipcode + " es: " + result);
    }

    public void removeCity(int zipcode){
        if(zipcodesCities.containsKey(zipcode)){
            String result = zipcodesCities.get(zipcode);
            zipcodesCities.remove(zipcode);
            System.out.println(result + " ha sido eliminada.");
        } else {
            System.out.println("El código postal " + zipcode + " no existe.");
        }
    }

    public void updateCity(int zipcode){
        String result = zipcodesCities.get(zipcode);
        if(zipcodesCities.containsKey(zipcode)) {
            System.out.println(result + " es la ciudad actual. Ingresa el nuevo nombre para actualizarlo: ");
            String newCityName = normalizeName(result);
            zipcodeCitiesHashMap.zipcodesCities.replace(zipcode, newCityName);
            System.out.println(result + " ha sido cambiada a: " + newCityName);
        } else {
            System.out.println("El código postal " + zipcode + " no existe.");
        }
    }
}
