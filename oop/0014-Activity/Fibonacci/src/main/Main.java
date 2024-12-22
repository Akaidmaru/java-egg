package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        System.out.println("Ingresa la posición de Fibonacci que deseas conocer: ");
        int userInput = Integer.parseInt(input.nextLine());

        fibonacciArray(userInput);
        int recursiveValue = fibonacciRecursive(userInput);
        System.out.println("El valor de fibonacci recursivo en la posición " + userInput + " es: " + recursiveValue);


    }

    public static void fibonacciArray(int fiboPosition) {
        ArrayList<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.add(0);
        fibonacciList.add(1);
        if (fiboPosition <= 1) {
            System.out.println(
                    "El valor de Fibonacci para la posición " + fiboPosition + " es: "
                            + fibonacciList.get(fiboPosition)
            );
        } else {
            for (int i = 2; i <= fiboPosition; i++) {
                fibonacciList.add(fibonacciList.get(i - 2) + fibonacciList.get(i - 1));
            }
            System.out.println(
                    "El valor de Fibonacci para la posición " + fiboPosition + " es: "
                            + fibonacciList.get(fiboPosition)
            );
        }
    }

    public static int fibonacciRecursive(int fiboPosition) {
        if (fiboPosition == 0) return 0;
        if (fiboPosition == 1) return 1;
        return fibonacciRecursive(fiboPosition- 2)  + fibonacciRecursive(fiboPosition-1);
    }
}
