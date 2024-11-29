package service;

import enums.OrderState;
import model.Order;

import java.util.Arrays;
import java.util.Scanner;

public class OrderService {
    private Order[] orderList = new Order[5];
    private int size = 0;

    Scanner input = new Scanner(System.in);

    public Order newOrder() {
        int itemsCounter = 0;
        System.out.println("Ingresa tu nombre: ");
        String clientName = input.nextLine();

        System.out.println("¿Cuantos productos deseas agregar al carrito?");
        int arraySize = Integer.parseInt(input.nextLine()) - 1; // -1 because we need items from 0 to input-1
        String[] itemsList = new String[arraySize];

        do {
            System.out.println("Ingresa el nombre del producto " + (itemsCounter + 1) + ": ");
            String userItem = input.nextLine();
            itemsList[itemsCounter] = userItem;
            itemsCounter++;

        } while (arraySize != itemsCounter);


        Order newOrder = new Order(clientName, itemsList, OrderState.PENDING);
        System.out.println("¡El pedido ha sido creado éxitosamente!");

        orderList = increaseListSize(orderList, orderList.length);
        orderList[size] = newOrder;
        size++;
        return newOrder;
    }

    public String stateUpdate(Order order, OrderState orderState) {
        order.setOrderState(orderState);
        return "El estado de la órden" + order.getOrderNumber() +
                "ha sido actualizado a: " + orderState.name();
    }

    private Order[] increaseListSize(Order[] listToIncrease, int size) {
        if (size >= listToIncrease.length) {
            int newSize = size + 1;
            Order[] auxArray = Arrays.copyOf(listToIncrease, newSize);
            listToIncrease = auxArray;
            return listToIncrease;
        }
        return listToIncrease;
    }

    public Order[] searchOrderByState(Order[] orderList, OrderState searchState) {
        Order[] searchResult = new Order[5];
        int countResults = 0;

        for (Order order : orderList) {
            if (order.getOrderState() == searchState) {
                searchResult[countResults] = order;
                searchResult = increaseListSize(orderList, countResults);
                countResults++;
            }
        }
        return searchResult;
    }


    public void printOrderList(Order[] orderList) {
        System.out.println("------------------------Lista de pedidos------------------------");
        for (Order order : orderList) {
            System.out.println("------------------Número de pedido: " + order.getOrderNumber() + "------------------");
            System.out.println("Nombre del cliente: " + order.getClient());
            System.out.println("Lista de productos: " + Arrays.toString(order.getProductsList()));
            System.out.println("Estado de la orden: " + order.getOrderState());
        }
    }
}
