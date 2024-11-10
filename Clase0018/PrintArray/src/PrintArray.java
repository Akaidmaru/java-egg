public class PrintArray {
    public static void printArray(int[] array){
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printArray(String[] array){
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printArray(int[][] array){
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void printArray(String[][] array){
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        printArray(numeros);

        String[] palabras = {"Hola", "tengo", "hambre"};
        printArray(palabras);

        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printArray(matriz);
        

        String[][] matrizPalabras = {{"Hola", "como", "estan"}, {"todos", "tenemos", "hambre"}, {"Aca", "estamos", "todos"}};
        printArray(matrizPalabras);

    }
}
