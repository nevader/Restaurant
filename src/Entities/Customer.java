package Entities;

import DataTypes.Address;
import DataTypes.Person;

public class Customer extends Person {


    private boolean isDelivery;
    private Address address;
    private int table;

    public Customer(String name, String phone, boolean isDelivery, Address address, int table) {
        super(name, phone);
        this.isDelivery = isDelivery;
        this.address = address;
        this.table = table;
    }

    public int getTable() {
        return table;
    }

    public boolean isDelivery() {
        return isDelivery;
    }
    public Address getAddress() {
        return address;
    }
}
