import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6, 7, 8, 9, 10};

        Scanner input = new Scanner(System.in);

        System.out.println("Ingresa un valor a buscar el array: ");
        int userInput = input.nextInt();

        int result = Arrays.binarySearch(array, userInput);

        if(result < 0){
            System.out.println("El número " + userInput + " no está en el array.");
        } else {
            System.out.println("El número " + userInput + " está en la posición: " + result);
        }
    }
}
