package Personel;

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


    @Override
    public void setName(String name) {
        super.setName(name);
    }
    @Override
    public void setPhone(String phone) {
        super.setPhone(phone);
    }
    public void setDelivery(boolean delivery) {
        isDelivery = delivery;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public Address getAddress() {
        return address;
    }
}
