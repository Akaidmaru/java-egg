import java.util.Arrays;

public class InverseOrder {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] inverseArray = new int[array.length];
        int indice = 0;

        for (int i = array.length-1 ; i>=0 ; i--) {
            System.out.println("Invirtiendo orden: " + array[i]);
            inverseArray[indice] = array[i];
            indice++;
        }

        System.out.println("Array original: " + Arrays.toString(array));
        System.out.println("Array inverso: " + Arrays.toString(inverseArray));
    }
}
