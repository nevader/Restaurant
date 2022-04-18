package Costumer;


import Units.MenuItem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class PlaceOrder {

    static AtomicInteger orderID = new AtomicInteger();
    private int id;
    private String date;
    private Customer customer;
    private boolean isDelivery;
    private String status;
    private ArrayList <MenuItem> orderedItems;

    public PlaceOrder(boolean isDelivery, String status, Customer customer) {
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        id = orderID.incrementAndGet();
       this.customer = customer;
        this.isDelivery = isDelivery;
        this.status = status;
        this.orderedItems = new ArrayList<>();
       // this.table = table;
    }

    public int getOrderID() {
        return id;
    }
    public String getDate() {
        return date;
    }
    public boolean isDelivery() {
        return isDelivery;
    }
    public String getStatus() {
        return status;
    }
}
