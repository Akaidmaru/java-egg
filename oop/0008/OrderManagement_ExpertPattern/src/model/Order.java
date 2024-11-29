package model;

import enums.OrderState;

public class Order {
    private int orderNumber = 0;
    private String client;
    private String[] productsList;
    private OrderState orderState;

    public Order() {
    }

    public Order(String client, String[] productsList, OrderState orderState) {
        this.orderNumber++;
        this.client = client;
        this.productsList = productsList;
        this.orderState = orderState;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String[] getProductsList() {
        return productsList;
    }

    public void setProductsList(String[] productsList) {
        this.productsList = productsList;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
