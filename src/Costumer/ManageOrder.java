package Costumer;

import Control.UserInterface;
import DataTypes.Address;
import Personel.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageOrder extends UserInterface {

    private ArrayList <newOrder> listofallorders;
    private ArrayList <Customer> customersList;


    public ManageOrder() {
        this.listofallorders = new ArrayList<>();
    }

    public void newOrder(boolean isDelivery, String status, Customer customer) {
        newOrder newOrder = new newOrder(isDelivery, status, customer);
        listofallorders.add(newOrder);
    }

    public Customer newCustomerDelivry() {
        Scanner in = new Scanner(System.in);

        String miasto;
        String ulica;
        String zipcode;
        String imie;
        String telefon;
        System.out.println("Podaj swoje imie");
        imie = in.nextLine();
        System.out.println("Podaj swoj telefon");
        telefon = in.nextLine();

        System.out.println("Type your adress: ");
        ulica = in.nextLine();

        System.out.println("Miasto: ");
        miasto = in.nextLine();

        System.out.println("zipkode");
        zipcode = in.nextLine();

        Address address = new Address(ulica, miasto, zipcode);

        Customer customer = new Customer(imie, telefon, true, address);

        customersList.add(customer);

        return customer;




    }

    public void placeDeliveryOrder() {
        System.out.println("Co chcesz zamowic? ilosc itp.");

/*    TODO

        double tempprice;
        double totalpricel
        int ilosc;

        sout -> pokazuje menu
        sout -> wybierz id

        jakas metoda ktora zwraca cene przedmiotu o wskazanym ID.

        temprice = getprice

        sout --> wybierz ilosc

        ilosc = ilosc;
        total price += ilosc * tempprice;

        sout --> dodaj kolejny item albo kontynutuj

        if (dodaj kolejny loop) ? podzielic metode na czesci?

        else (kontynutuj)
        sout --> podsumowanie (Do zaplaty: totalprice + oczekiwany czas dostawy)

        oczekiwany czas dostawy?

        kuchnia {
        przyzadza jedno danie 30sekund -> wiecej kucharzy mniejszy czas przyzadzania
        status dania: wprzygotowywaniu.
        sortuje liste zamowien !isDelivery > isDelivery || getID < getID
        przyzadza najpierw zamowienia stacjonarne isDelivery

       Ustalic na podstawie Date (godziny) czy danie juz jest gotowe.

       current time x
       orderlist [] [] [] [] [] [] [] [] []
       mark zrobione as zrobione


        }

        kurier {
        dostarcza jedna paczke 2min
        lista kurierow, status wolny, zajety?

        }


        zmienic:
        listofallorders na --> listaZamowien

        //show przewidywany czas dostawy????
        //listofalloders wyjebac zamowienia ze statusem zrobione to
        //list
        //listofallorders -- ilosc kucharzy -- ilosc dostawcow? */
    }

}
