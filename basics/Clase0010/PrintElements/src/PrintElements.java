public class PrintElements {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        for (int i = 0; i < array.length; i++) {
            System.out.println("Elementos primer for: " + array[i]);
        }

        for (int j :array) {
            System.out.println("Elementos segundo for: " + j);
        }

    }
}
