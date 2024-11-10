import java.util.Scanner;
public class ReplaceChars {

    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = miScanner.nextLine();
        System.out.println("Digite el caracter a reemplazar: ");
        String car1 = miScanner.next();
        System.out.println("Digite el nuevo caracter: ");
        String car2 = miScanner.next();
        String result = frase.replace(car1,car2);
        System.out.println("Result:"+result);
        miScanner.close();
    }
}