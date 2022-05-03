package Entities;

import DataTypes.Person;
import Units.OrdersManage;

import java.util.ArrayList;

public class Waiter extends Person.Employee {

    private double tips = 0;
    private boolean isAvalible;
    private int deliveredCount = 0;
    public ArrayList <OrdersManage.Order> ordersToPlace;

    public Waiter(String name, String phone) {
        super(name, phone);
        this.ordersToPlace = new ArrayList<>();

    }


    public ArrayList<OrdersManage.Order> getOrdersToPlace() {
        return ordersToPlace;
    }

    public double getTips() {
        return tips;
    }

    public int getDeliveredCount() {
        return deliveredCount;
    }

    public int getOrdersToPlaceSize() {
        return ordersToPlace.size();
    }

    public void setTips(double tips) {
        this.tips += tips;
    }

    public void deliveredCountIncrease() {
        this.deliveredCount += 1;
    }
}