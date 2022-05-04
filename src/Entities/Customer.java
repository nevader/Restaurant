package Entities;

import DataTypes.Address;
import DataTypes.Person;

public class Customer extends Person {


    private final Address address;
    private final int table;

    public Customer(String name, String phone, Address address, int table) {
        super(name, phone);
        this.address = address;
        this.table = table;
    }

    public int getTable() {
        return table;
    }

    public Address getAddress() {
        return address;
    }
}
