import java.util.Random;

public class RandomNumber {

    public static void main(String[] args) {


        double auxiliar;
        Random randomNumber= new Random();

        for(int i=0;i<100;i++){

            int variable2= randomNumber.nextInt(1,355);
            auxiliar= Math.floor(Math.random()*(355-1+1)+1);
            int number1= (int)((auxiliar));
            System.out.println("el número random es:"+auxiliar);
            System.out.println("el número generado es:"+number1);
            System.out.println("el número generado con clase Random es:"+variable2);
        }



    }

}