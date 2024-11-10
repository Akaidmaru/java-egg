import java.util.Arrays;
import java.util.Scanner;

public class CopyingElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        int[] newArray = new int[5];

        Scanner input = new Scanner(System.in);

        System.out.println("Ingresa un elemento para añadirlo al array: ");
        int number1 = input.nextInt();
        System.out.println("Ingresa otro elemento para añadirlo al array: ");
        int number2 = input.nextInt();

        newArray[0] = array[0];
        newArray[1] = array[1];
        newArray[2] = array[2];
        newArray[3] = number1;
        newArray[4] = number2;

        System.out.println("Array final: " + Arrays.toString(newArray));

    }
}
