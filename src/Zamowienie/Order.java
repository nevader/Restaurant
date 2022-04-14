package Zamowienie;

import Enums.OrderStatus;
import Meal.Meal;
import Personel.Chef;

public abstract class Order {

    private int OrderID;
    private OrderStatus status;
   // private Date creationTime;

    private Meal[] meals;
   // private Check check;
    private Chef chef;

    public Order(int orderID, OrderStatus status, Meal[] meals, Chef chef) {
        OrderID = orderID;
        this.status = status;
        this.meals = meals;
        this.chef = chef;
    }

    public abstract boolean addMeal(Meal meal);
    public abstract boolean removeMeal(Meal meal);
    public abstract OrderStatus getStatus();
    public abstract boolean setStatus(OrderStatus status);

}
