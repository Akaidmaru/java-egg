import java.util.HashSet;
import java.util.Iterator;

public class GuestsRegister {
    HashSet<String> guestList;

    public GuestsRegister() {
        this.guestList = new HashSet<>();
    }

    public void addGuest(String name){
        String normalizedName = normalizeName(name);
        if(guestList.contains(normalizedName)){
            System.out.println("El nombre ya está en la lista.");
        } else {
            System.out.println("El invitado " + name + " ha sido agregado a la lista.");
            guestList.add(normalizedName);
        }
    }

    public void deleteGuest(String name){
        String normalizedName = normalizeName(name);
        if (!guestList.contains(normalizedName)){
            System.out.println("El invitado " + name + " no existe en la lista.");
        } else {
            System.out.println("El invitado " + name + " ha sido removido de la lista.");
            guestList.remove(normalizedName);
        }
    }

    public void showGuests(){
        if(guestList.isEmpty()){
            System.out.println("La lista está vacía");
        } else{
        Iterator<String> iterator = guestList.iterator();
        int counter = 1;
        System.out.println("*********LISTA DE INVITADOS*********");
        while (iterator.hasNext()){
            System.out.println(counter++ + ")" + iterator.next());
        }
    }
    }

    public String normalizeName(String name){
        return name.strip().toLowerCase();
    }
}
