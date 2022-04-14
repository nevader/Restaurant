package RezerwacjaDostawa;

import Enums.ReservationStatus;
import Klient.Customer;

import java.util.Date;

public class Reservation {

    private int reservationID;
    private Date timeOfReservation;
    private int peopleCount;
    private ReservationStatus status;
    private String notes;
    private Date checkinTime;
    private Customer customer;

    //private Table[] tables;
    //private List<Notification> notifications;


  //  public boolean updatePeopleCount(int count);
}