import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        int numero1, numero2, opcion;
        float resultado = 0;

        Scanner inputUsuario = new Scanner(System.in);
        System.out.println("Ingresa un primer número: ");
        numero1 = inputUsuario.nextInt();

        System.out.println("Ingresa un segundo número: ");
        numero2 = inputUsuario.nextInt();

        System.out.println("¿Qué operación deseas realizar?(1)Suma, 2)Resta, 3)Multiplicación, 4)División)");
        opcion = inputUsuario.nextInt();

//        if (opcion == 1){
//            resultado = numero1 + numero2;
//            System.out.println("El resultado es: " + resultado);
//        }else if (opcion == 2){
//            resultado = numero1 - numero2;
//            System.out.println("El resultado es: " + resultado);
//        }else if (opcion == 3){
//            resultado = numero1 * numero2;
//            System.out.println("El resultado es: " + resultado);
//        } else if (opcion == 4){
//            if (numero2 == 0){
//                System.out.println("No se puede divivir por cero.");
//            } else{
//                resultado = (float) numero1 / numero2;
//                System.out.println("El resultado es: " + resultado);
//            }
//
//        } else{
//            System.out.println("Opción incorrecta.");
//        }
//        inputUsuario.close();

        switch(opcion){
            case 1 -> resultado = numero1 + numero2;
            case 2 -> resultado = numero1 - numero2;
            case 3 -> resultado = numero1 * numero2;
            case 4 -> resultado = (float) numero1 / numero2;
            default -> System.out.println("Opción incorrecta.");
        }

        System.out.println(resultado);
    }
}
