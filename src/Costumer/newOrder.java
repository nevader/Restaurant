package Costumer;


import Personel.Customer;
import Units.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


public class newOrder {

    static AtomicInteger orderID = new AtomicInteger();
    private int id;
    private Date time;
    private Customer customer;
    private boolean isDelivery;
    private String status;
    private ArrayList <MenuItem> orderedItems;

    public newOrder(boolean isDelivery, String status, Customer customer) {
        this.time = new Date();
        id = orderID.incrementAndGet();
        this.customer = customer;
        this.isDelivery = isDelivery;
        this.status = status;
        this.orderedItems = new ArrayList<>();
    }



    public int getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isDelivery() {
        return isDelivery;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<MenuItem> getOrderedItems() {
        return orderedItems;
    }
}
