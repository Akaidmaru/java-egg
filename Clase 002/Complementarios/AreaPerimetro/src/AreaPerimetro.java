import java.util.Scanner;

public class AreaPerimetro {
    public static void main(String[] args) {
        Scanner inputBase = new Scanner(System.in);
        Scanner inputAltura = new Scanner(System.in);

        System.out.println("Ingresa un valor como base: ");
        float base = inputBase.nextFloat();

        System.out.println("Ingresa un valor como altura: ");
        float altura = inputBase.nextFloat();

        float perimetro =  (2 * base) + (2 * altura);
        float area = base * altura;

        System.out.println("El perímetro es: " + perimetro);
        System.out.println("La area es: " + area);

        inputBase.close();
        inputAltura.close();
    }
}
