package Entities;

import DataTypes.Person;
import Units.OrdersManage;

import java.util.ArrayList;

public class DeliveryMan extends Person.Employee {

    private double tips;
    private boolean isAvalible;
    private int deliveredCount = 0;
    public ArrayList <OrdersManage.Order> ordersToDelivery;

    public DeliveryMan(String name, String phone) {
        super(name, phone);
        this.ordersToDelivery = new ArrayList<>();

    }

    public ArrayList<OrdersManage.Order> getOrdersToDelivery() {
        return ordersToDelivery;
    }

    public int getOrdersToDeliverySize() {
      return ordersToDelivery.size();
    }

    public void setTips(double tips) {
        this.tips = tips;
    }

    public void setAvalible(boolean avalible) {
        isAvalible = avalible;
    }

    public double getTips() {
        return tips;
    }

    public boolean isAvalible() {
        return isAvalible;
    }

    public int getDeliveredCount() {
        return deliveredCount;
    }

    public void deliveredCountIncrease() {
        this.deliveredCount += 1;
    }
}
