package Entities;

import DataTypes.Address;
import DataTypes.Person;

public class Customer extends Person {


    private boolean isDelivery;
    private Address address;

    public Customer(String name, String phone, boolean isDelivery, Address address) {
        super(name, phone);
        this.isDelivery = isDelivery;
        this.address = address;
    }

    public boolean isDelivery() {
        return isDelivery;
    }
    public Address getAddress() {
        return address;
    }
}
