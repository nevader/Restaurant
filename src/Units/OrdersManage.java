package Units;

import UI.UserInterface;
import DataTypes.Address;
import Entities.Customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class OrdersManage extends UserInterface {

    public static ArrayList <Order> listofallorders;
    private ArrayList <Customer> customersList;
    private ArrayList <MenuManage.MenuItem> koszyk = new ArrayList<>();

    public OrdersManage() {
        listofallorders = new ArrayList<>();
    }





    /*Delivery*/
    public void placeDeliveryOrder() {

        do {
            flag = false;
            _dostawa();
            System.out.println("\n" +
                    ".------------------------.\n" +
                    "| #1 Dodaj do koszyka    |\n" +
                    "| #2 Pokaz koszyk        |\n" +
                    "| #3 Realizuj zamowienie |\n" +
                    "| #0 Wyjdz               |\n" +
                    "'------------------------'\n");
            userChoice = userInputNextInt("Wybierz:\n#");

            switch (userChoice) {
                case 1:
                    koszyk.addAll(addItemsDoKosztka());
                    placeDeliveryOrder();
                    break;
                case 2:
                    _koszyk();
                    showKoszyk(koszyk);
                    pressAnyKeyToContinue();
                    placeDeliveryOrder();
                case 3:
                    flag = true;
                    podsumowanieDelivery();
                    pressAnyKeyToContinue();
                    break;
                case 0:
                    flag = true;
                    break;
                default:
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
    public Customer daneDoDostawy(){
        Scanner in = new Scanner(System.in);

        String street;
        String city;
        String zipcode;

        String imie;
        String telefon;

        _dostawa();
        System.out.println(
                "\n.---------------------------------------.\n" +
                        "| Wypelnij formularz dotyczacy dostawy. |\n" +
                        "'---------------------------------------'\n");
        System.out.println("Podaj swoje imie: ");
        System.out.print("#");
        imie = in.nextLine();

        _dostawa();
        System.out.println("\nWitaj, " + imie);
        System.out.println(
                ".---------------------------------------.\n" +
                        "| Wypelnij formularz dotyczacy dostawy. |\n" +
                        "'---------------------------------------'\n");
        System.out.println("Podaj swoj numer telefonu: ");
        System.out.print("#");

        telefon = in.nextLine();

        _dostawa();
        System.out.println("\nWitaj, " + imie);
        System.out.println(
                ".---------------------------------------.\n" +
                        "| Wypelnij formularz dotyczacy dostawy. |\n" +
                        "'---------------------------------------'\n");
        System.out.println("Podaj swoje miasto: ");
        System.out.print("#");

        city = in.nextLine();

        _dostawa();
        System.out.println("\nWitaj, " + imie);
        System.out.println(
                ".---------------------------------------.\n" +
                        "| Wypelnij formularz dotyczacy dostawy. |\n" +
                        "'---------------------------------------'\n");
        System.out.println("Podaj swój kod pocztowy: ");
        System.out.print("#");

        zipcode = in.nextLine();

        _dostawa();
        System.out.println("\nWitaj, " + imie);
        System.out.println(
                ".---------------------------------------.\n" +
                        "| Wypelnij formularz dotyczacy dostawy. |\n" +
                        "'---------------------------------------'\n");
        System.out.println("Podaj swoja ulice: ");
        System.out.print("#");

        street = in.nextLine();


        Address address = new Address(street, city, zipcode);
        Customer customer = new Customer(imie, telefon, true, address);

        return customer;

    }
    public void podsumowanieDelivery() {
        Customer customer = daneDoDostawy();

        _podsumowanie();

        System.out.print("\n" +
                ".-------------------.\n" +
                "| Twoje zamowienie: |\n" +
                "'-------------------'");
        showKoszyk(koszyk);


        System.out.println("\n" +
                ".-------------.\n" +
                "| Twoje dane: |\n" +
                "'-------------'");

        System.out.println("Imie: " + customer.getName());
        System.out.println("Telefon: " + customer.getPhone());
        System.out.println("Ulica: " + customer.getAddress().getStreetAddress());
        System.out.println("Kod pocztowy: " + customer.getAddress().getZipCode());
        System.out.println("Miasto: " + customer.getAddress().getCity());


        newOrder(customer, koszyk);

    }

    /*Rozne*/
    public void newOrder(Customer customer, ArrayList<MenuManage.MenuItem> orderedItems) {
        Order Order = new Order(true, "W przygotowywaniu", customer, orderedItems);
        listofallorders.add(Order);
    }
    public ArrayList<MenuManage.MenuItem> addItemsDoKosztka () {

        ArrayList <MenuManage.MenuItem> koszyk = new ArrayList<>();
        ArrayList <MenuManage.MenuItem> listaDan = menuManage.getItemList();

        _koszyk();
        menuManage.printMenu();


        do {
            flag = false;
            userChoice = userInputNextInt("Podaj ID");

            if (userChoice < 1 || userChoice > listaDan.size()) {
                System.out.println("Podaj poprawny ID");

            } else {
                for (int i = 0; i < listaDan.size() || !flag; i++) {
                    if (listaDan.get(i).getMenuItemID() == userChoice) {
                        int ilosc = userInputNextInt("Podaj ilosc: ");
                        for (int j = 0; j < ilosc; j++) {
                            koszyk.add(listaDan.get(i));
                            flag = true;
                        }

                    }
                }
            }
        } while (!flag);

        return koszyk;

    }
    public void showKoszyk (ArrayList <MenuManage.MenuItem> koszyk) {

        double totalprice = 0;

        System.out.println("");
        for (int i = 0; i < koszyk.size(); i++) {
            System.out.print("#" + (i+1) + " " + koszyk.get(i).getName() +
                    " |" + koszyk.get(i).getPrice() + "|\n");

            totalprice += koszyk.get(i).getPrice();
        }
        System.out.println("Total price: $" + totalprice);


    }
    public void clearKoszyk() {
        koszyk.clear();
    }

    /*Stacjonarne*/
    public void placeStacjonarne() {
        int stolik;

        stolik = rezerwujStolik();

    }


    public int rezerwujStolik() {
        do {
            flag = false;
            _rezerwuj();
            System.out.println();
            tables.printTables();
            System.out.println();

            if (userChoice == -1) {
                System.out.println("Podaj poprawny numer stolika!");
            } else if (userChoice == -2) {
                System.out.println("Twoj stolik jest zajęty! Wybierz inny: ");
            } else if (userChoice == -3) {
                System.out.println("Wybierz poprawny");
            }

            userChoice = userInputNextInt("Podaj numer stolika:\n#");

            if (userChoice < 1 || userChoice > 4) {
                userChoice = -1;
                continue;
            }

            switch (userChoice) {

                case 1:
                    if (!tables.getTable1().isAvalible()) {
                        userChoice = -2;
                        break;
                    } else {
                        tables.setTableNOt(1);
                        flag = true;
                        return userChoice;
                    }

                case 2:
                    if (!tables.getTable2().isAvalible()) {
                        userChoice = -2;
                        break;
                    } else {
                        tables.setTableNOt(2);
                        flag = true;
                        return userChoice;
                    }

                case 3:
                    if (!tables.getTable3().isAvalible()) {
                        userChoice = -2;
                        break;
                    } else {
                        tables.setTableNOt(3);
                        flag = true;
                        return userChoice;
                    }

                case 4:
                    if (!tables.getTable4().isAvalible()) {
                        userChoice = -2;
                        break;
                    } else {
                        tables.setTableNOt(4);
                        flag = true;
                        return userChoice;
                    }

                default:
                    userChoice = -3;
            }

        } while (!flag);

        return userChoice;
    }










    public static class Order {

        static AtomicInteger orderID = new AtomicInteger();
        private int id;
        private Calendar calendar = Calendar.getInstance();
        private Date date;
        private Customer customer;
        private boolean isDelivery;
        private String status;
        private ArrayList <MenuManage.MenuItem> orderedItems;

        public Order(boolean isDelivery, String status, Customer customer, ArrayList<MenuManage.MenuItem> orderedItems) {
            this.date = calendar.getTime();
            id = orderID.incrementAndGet();
            this.customer = customer;
            this.isDelivery = isDelivery;
            this.status = status;
            this.orderedItems = orderedItems;
        }



        public int getId() {
            return id;
        }
        public Date getDate() {
            return date;
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
        public ArrayList<MenuManage.MenuItem> getOrderedItems() {
            return orderedItems;
        }
    }
}





