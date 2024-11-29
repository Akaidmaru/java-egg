package service;

import java.util.Scanner;

public class MenuService {

    Scanner input = new Scanner(System.in);
    OrderService orderService = new OrderService();

    public void Menu(){
        int userOption;
        do {
        System.out.println("""
            ----------------Menu----------------
            1) Crear nuevo pedido.
            2) Actualizar estado de un pedido.
            3) Buscar pedidos por estado.
            4) Mostar lista de pedidos
            5) Salir de la aplicación
        """);
        userOption = Integer.parseInt(input.nextLine());

        switch(userOption){
            case 1 -> orderService.newOrder() ;
            case 2 -> {
                System.out.println("Ingresa el número de órden que quieres actualizar: ");
                
                orderService.stateUpdate();
            }
            case 3 -> ;
            case 4 -> ;
            case 5 -> System.out.println("Saliendo...¡Hasta luego!");;
            default -> System.out.println("Ingresa una opción válida.");;
        }
        }while (userOption != 5);
    }
}
