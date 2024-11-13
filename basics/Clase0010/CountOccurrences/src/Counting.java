import java.util.Arrays;
import java.util.Scanner;

public class Counting {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur tincidunt.";
        char[] array =  new char[50];
        int counter = 0;

        for (int i = 0; i < text.length(); i++) {
            array[i] = text.toLowerCase().charAt(i);
        }

        System.out.println("Array: " + Arrays.toString(array));

        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un carácter a buscar en el array: ");
        char userChar = input.nextLine().toLowerCase().charAt(0);

        for (char letter : array) {
            if (letter == userChar){
                counter++;
            }
        }

        if (counter > 0){
            System.out.println("El carácter " + userChar + " aparece: " + counter + " veces.");
        } else{
            System.out.println("El carácter " + userChar + " no aparece en la frase.");
        }
    }
}
