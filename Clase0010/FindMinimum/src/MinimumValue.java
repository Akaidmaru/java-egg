public class MinimumValue {
    public static void main(String[] args) {
        int[] array = {7, 1, 5, 15, 30, 10};
        int min=array[0];
        int min2=array[0];

        // For i
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min ){
                min = array[i];
            }
        }
        System.out.println("El valor mínimo en el array es: " + min);

        // For Each
        for(int j: array){
            if(min2 < j ){
                min2 = j;}
        }
        System.out.println("El valor mínimo2 es: " + min2);
    }
}
