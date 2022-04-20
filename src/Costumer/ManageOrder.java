package Costumer;

import Control.UserInterface;
import DataTypes.Address;
import Personel.Customer;
import Units.MenuItem;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageOrder extends UserInterface {

    private ArrayList <newOrder> listofallorders;
    private ArrayList <MenuItem> orderedItems;
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

    /*
    * Dodac sciezke gdzie jestesmy w menu typu Main > zarzadzam restauracaj > dodaj danie
    *  (jezeli jest za dlugie to wykropkowac )
    *
    * poprawic do while loopa w delivery zeby byla mozliwosc dodac cos do koszyka pare razy
    *
    * no i oczywiscie poprawic wyglad
    *
    * w total price poprawic formatowanie ceny
    * */
    public ArrayList<MenuItem> addItemsDoKosztka () {

        ArrayList <MenuItem> koszyk = new ArrayList<>();
        ArrayList <MenuItem> listaDan = menu.getItemList();

        menu.printMenu();

        int id;
        int ilosc;

        id = userInputNextInt("Podaj id:");
        ilosc = userInputNextInt("Podaj ilosc:");
        boolean found = false;

        for (int i = 0; i < listaDan.size() || !found; i++) {
            if (listaDan.get(i).getMenuItemID() == id) {
                found = true;
                for (int j = 0; j < ilosc; j++) {
                    koszyk.add(listaDan.get(i));
                }
            }
        }

        return koszyk;

    }
    public void showKoszyk (ArrayList <MenuItem> koszyk) {

        double totalprice = 0;

        for (int i = 0; i < koszyk.size(); i++) {
            System.out.print("#" + (i+1) + " " + koszyk.get(i).getName() +
                    " |" + koszyk.get(i).getPrice() + "|\n");

            totalprice += koszyk.get(i).getPrice();
        }
        System.out.println("Total price: $" + totalprice);


    }
    public void placeDeliveryOrder() {

        ArrayList <MenuItem> koszyk = new ArrayList<>();

        koszyk.addAll(addItemsDoKosztka());

        System.out.println("1. dodaj kolejne\n" +
                "2. pokaz koszyk.");

        do {
            userChoice = userInputNextInt("Wybierz:");
            switch (userChoice) {
                case 1:
                    koszyk.addAll(addItemsDoKosztka());
                    break;
                case 2:
                    showKoszyk(koszyk);
                default:
                    System.out.println("Poprawna");
                    break;
            }
        } while (!flag);


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
