import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
//        Actividad:  Serie Fibonacci mejorada
//        En esta actividad, te propongo un desafío adicional relacionado con la serie de Fibonacci.
//        La tarea consiste en crear un programa que te permita ingresar la posición de un número en
//        la serie de Fibonacci y, a continuación, mostrar el valor correspondiente a esa posición.
//        Tu objetivo es desarrollar un programa que sea capaz de calcular y
//        mostrar el valor de la serie de Fibonacci para cualquier posición
//        ingresada por el usuario. Este ejercicio te ayudará a consolidar tu
//        comprensión sobre cómo generar y trabajar con la serie de Fibonacci.
//    Anímate a enfrentar este reto y sigue profundizando en tus habilidades de programación!

        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa la posición número para calcular el número Fibonacci: ");
        int userNumber = input.nextInt();
        input.close();
        int result = 0;

        if (userNumber < 0){
            System.out.println("No pueden haber posiciones negativas");
        } else {
            switch(userNumber) {
                case 0 -> System.out.println("El valor de la posición 1 es: 0");
                case 1 -> System.out.println("El valor de la posición 2 es: 1");
                default -> {
                    int previousNumber = 0;
                    int currentNumber = 1;

                    for (int i = 2; i < userNumber; i++) {
                        result = previousNumber + currentNumber;
                        previousNumber = currentNumber;
                        currentNumber = result;
                    }
                    System.out.println("El número Fibonacci en la posición " + userNumber + " es: " + result);
                }
            }
        }
    }
//    import java.util.Scanner;

//    public class Fibonacci {
//        public static void main(String[] args) {
//
//            Scanner input = new Scanner(System.in);
//            System.out.println("Please type n member fibonacci serie:");
//            int num = input.nextInt();
//            input.close();
//
//            for (int it = 0; it < num; it++)
//                System.out.print(fbn(it)+" ");
//        }
//        public static int fbn(int n ){
//            if(n<=1)
//                return n;
//            else
//                return fbn(n-1) + fbn(n-2);
//        }
//    }
}
