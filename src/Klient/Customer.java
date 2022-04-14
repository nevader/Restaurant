package Klient;

import DataTypes.Person;

public class Customer extends Person {

    public Customer(String name, String email, String phone) {
        super(name, phone);
    }

    public void selectDish() {}
    public void callWaiter() {}
    public void placeOrder() {}
    public void requestForBill() {}
    public void makePayment() {}

}
