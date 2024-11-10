import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        float[] array = new float[4];

        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el elemento número 1: ");
        array[0] = input.nextFloat();
        input.nextLine();
        System.out.println("Ingresa el elemento número 2: ");
        array[1] = input.nextFloat();
        input.nextLine();
        System.out.println("Ingresa el elemento número 3: ");
        array[2] = input.nextFloat();
        input.nextLine();
        System.out.println("Ingresa el elemento número 4: ");
        array[3] = input.nextFloat();
        input.nextLine();
        input.close();

        System.out.println("Array.length: " + array.length);
        float result = (array[0] + array[1] + array[2] + array[3])/array.length;

        System.out.println("El promedio de los elementos es: " + result);

        float max = array[0];
        float min = array[0];
        // Calcular max
        if (array[1]>max) {
            max = array[1];
        }
        if (array[2]>max){
            max = array[2];
        }
        if (array[3]>max) {
            max = array[3];
        }
        // Calcular min
        if (array[1]<min) {
            min = array[1];
        }
        if (array[2]<min){
            min = array[2];
        }
        if (array[3]<min) {
            min = array[3];
        }

        System.out.println("El máximo es: " + max);
        System.out.println("El mínimo es: " + min);


    }
}
