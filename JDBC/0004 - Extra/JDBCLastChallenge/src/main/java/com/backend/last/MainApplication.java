package main.java.com.backend.last;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int option;
        Scanner userInput = new Scanner(System.in);
        System.out.println("******Menu******");
        System.out.println("1. Registrar un nuevo propietario.");
        System.out.println("2. Registrar un nuevo auto.");
        System.out.println("3. Realizar una transaccion (compra/venta).");
        System.out.println("4. Consultar los autos de un propietario.");
        System.out.println("5. Ver el historial de transacciones de un auto.");
        System.out.println("6. Consultar autos por marca.");
        System.out.println("7. Salir.");


        do {
            option = Integer.parseInt(userInput.nextLine());
            switch (option) {
                case 1 -> {
                    System.out.println("Registrar un nuevo propietario.");
                }
                case 2 -> {
                    System.out.println("Registrar un nuevo auto.");
                }
                case 3 -> {
                    System.out.println("Realizar una transaccion (compra/venta).");
                }
                case 4 -> {
                    System.out.println("Consultar los autos de un propietario.");
                }
                case 5 -> {
                    System.out.println("Ver el historial de transacciones de un auto.");
                }
                case 6 -> {
                    System.out.println("Consultar autos por marca.");
                }
                case 7 -> {
                    System.out.println("Salir.");
                }
                default -> {
                    System.out.println("Opcion no valida.");
                }
            }
        }  while(option != 7);
    }



}


