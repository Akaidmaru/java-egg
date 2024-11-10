import java.util.Scanner;

public class FiguraGeometrica {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa 1) Para Círculo, 2) para un Cuadrado o 3) para un triángulo: ");
            int seleccion = input.nextInt();

        double total = switch (seleccion){
            case 1 -> {
                System.out.println("Ingresa el radio: ");
                double radio = input.nextDouble();
                yield Math.PI*(Math.pow(radio, 2));
            }
            case 2 -> {
                System.out.println("Ingresa un lado: ");
                double lado = input.nextDouble();
                yield Math.pow(lado, 2);
            }
            case 3 -> {
                System.out.println("Ingresa la base: ");
                double base = input.nextDouble();
                System.out.println("Ingresa la altura: ");
                double altura = input.nextDouble();
                yield (base * altura)/2;
            }
            default -> -1;
        };

        if (seleccion >= 1 && seleccion <= 3){
            System.out.println("El valor del área de la figura seleccionada es: " + total);
        }else{
            System.out.println("Ingresa una opción correcta.");
        }
        input.close();
    }
}
