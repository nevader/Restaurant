package RezerwacjaDostawa;

import Enums.OrderStatus;
import Meal.Meal;
import Zamowienie.Order;
import Personel.Chef;
import Personel.Waiter;

public class placeOrder extends Order {

    private Waiter waiter;
    private Table table;

    public placeOrder(int orderID, OrderStatus status, Meal[] meals, Chef chef, Waiter waiter, Table table) {
        super(orderID, status, meals, chef);
        this.waiter = waiter;
        this.table = table;
    }

    @Override
    public boolean addMeal(Meal meal) {
        return false;
    }

    @Override
    public OrderStatus getStatus() {
        return null;
    }

    @Override
    public boolean setStatus(OrderStatus status) {
        return false;
    }

    @Override
    public boolean removeMeal(Meal meal) {
        return false;
    }
}
