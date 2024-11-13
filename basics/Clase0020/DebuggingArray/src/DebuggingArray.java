public class DebuggingArray {
    public static void main(String[] args) {

        int[]  numbersArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int total = 0;

        for (int i = 0; i < numbersArray.length ; i++) {
            total += numbersArray[i];
        }
    }
}
