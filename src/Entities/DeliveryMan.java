package Entities;

import DataTypes.Person;
import Units.OrdersManage;

import java.util.ArrayList;

public class DeliveryMan extends Person.Employee {

    private double tips = 0;
    private boolean isAvalible;
    private int deliveredCount = 0;
    public ArrayList <OrdersManage.Order> ordersToDelivery;

    public DeliveryMan(String name, String phone) {
        super(name, phone);
        this.ordersToDelivery = new ArrayList<>();

    }


    public int getOrdersToDeliverySize() {
      return ordersToDelivery.size();
    }

    public void setTips(double tips) {
        this.tips += tips;
    }

    public double getTips() {
        return tips;
    }

    public int getDeliveredCount() {
        return deliveredCount;
    }

    public void deliveredCountIncrease() {
        this.deliveredCount += 1;
    }
}
