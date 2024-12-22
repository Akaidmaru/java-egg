import java.util.Scanner;

public class GenerateNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("***Generando número aleatorio***");
        int randomNumber = randomNumber(13, 35);
        int userGuess;
        System.out.println("Tienes que adivinar cuál es el número generado, puede estar entre 13 y 35.");

        do {
            System.out.println("Ingresa tu número a elección: ");
            userGuess = Integer.parseInt(input.nextLine());
            if(userGuess > randomNumber){
                System.out.println("Estás por encima, intenta un poco más bajo.");
            } else if (userGuess < randomNumber) {
                System.out.println("Estás por debajo, intenta un poco más arriba.");
            } else{
                System.out.println("Perfecto, adivinaste el número. El número era: " + randomNumber);
            }

        }while(randomNumber != userGuess);
    }

    public static int randomNumber(int minNum, int maxNum){
        return (int) (Math.random() * ( maxNum - minNum + 1)) + minNum;
    }
}
