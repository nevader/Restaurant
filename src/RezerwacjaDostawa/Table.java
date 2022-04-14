package RezerwacjaDostawa;

import Enums.TableStatus;

import java.util.List;

public class Table {
    private int tableID;
    private TableStatus status;
    private int maxCapacity;
    private int locationIdentifier;

    private List<TableSeat> seats;

    //public boolean isTableFree();
    //public boolean addReservation();
    //public static List<Table> search(int capacity, Date startTime) {
        // return all tables with the given capacity and availability
    }