import java.util.Scanner;

public class Calificacion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa una puntuación: ");
        int puntuacion = input.nextInt();

        if(puntuacion > 100 || puntuacion < 0){
            System.out.println("Tu puntuación está fuera del rango, ingresa un rango válido.");
        }else if (puntuacion >= 90 && puntuacion <= 100){
            System.out.println("Tu puntuación es A.");
        } else if (puntuacion >= 80 && puntuacion <= 89) {
            System.out.println("Tu puntuación es B.");
        } else if (puntuacion >= 70 && puntuacion <= 79) {
            System.out.println("Tu puntuación es C.");
        } else if (puntuacion >= 60 && puntuacion <= 69){
            System.out.println("Tu puntuación es D.");
        } else {
            System.out.println("Tu puntuación es F.");
        }

        input.close();
    }
}
