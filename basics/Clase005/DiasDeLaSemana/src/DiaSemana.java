import java.util.Scanner;

public class DiaSemana {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa un número: ");
        int diaUsuario = input.nextInt();

        switch(diaUsuario){
            case 1 ->System.out.println("Lunes");
            case 2 ->System.out.println("Martes");
            case 3 ->System.out.println("Miércoles");
            case 4 ->System.out.println("Jueves");
            case 5 ->System.out.println("Viernes");
            case 6 ->System.out.println("Sábado");
            case 7 ->System.out.println("Domingo");
            default -> System.out.println("Ingresaste un número que no pertenece a un día de la semana.");
        }
    input.close();
    }
}
