package Units;

import Enums.Status;
import UI.UserInterface;
import DataTypes.Address;
import Entities.Customer;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrdersManage extends UserInterface {

    public static ArrayList <Order> currentOrders;

    public static ArrayList <Order> deliveryOrderstoCook;
    public static ArrayList <Order> tableOrderstoCook;

    public static ArrayList <Order> deliveryOrderstoPlace;
    public static ArrayList <Order> tableOrderstoPlace;

    public static ArrayList <Order> completedOrders;

    private final ArrayList <MenuManage.MenuItem> koszyk = new ArrayList<>();

    public OrdersManage() {
        currentOrders = new ArrayList<>();
        deliveryOrderstoCook = new ArrayList<>();
        tableOrderstoCook = new ArrayList<>();
        completedOrders = new ArrayList<>();
        deliveryOrderstoPlace = new ArrayList<>();
        tableOrderstoPlace = new ArrayList<>();
    }





    /*Delivery*/
    public void deliveryMenu() {

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
                    deliveryMenu();
                    break;
                case 2:
                    _koszyk();
                    showKoszyk(koszyk);
                    pressAnyKeyToContinue();
                    deliveryMenu();
                    break;
                case 3:
                    deliveryFinish();
                    flag = true;
                    break;
                case 0:
                    flag = true;
                    break;
            }


        } while (!flag);

    }
    public Customer deliveryInfo() {
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

        return new Customer(imie, telefon, true, address, 0);

    }
    public void deliveryFinish() {
        Customer customer = deliveryInfo();

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


        newOrderDelivery(customer, koszyk);
        pressAnyKeyToContinue();

    }

    /*Rozne*/
    public void newOrderDelivery(Customer customer, ArrayList<MenuManage.MenuItem> orderedItems) {
        Order Order = new Order(true, Status.REALIZACJA.toString(), customer, orderedItems);
        currentOrders.add(Order);
    }
    public void newOrderRestaurant(Customer customer, ArrayList<MenuManage.MenuItem> orderedItems) {
        Order Order = new Order(false, Status.REALIZACJA.toString(), customer, orderedItems);
        currentOrders.add(Order);
    }
    public ArrayList<MenuManage.MenuItem> addItemsDoKosztka () {

        ArrayList <MenuManage.MenuItem> koszyk = new ArrayList<>();
        ArrayList <MenuManage.MenuItem> listaDan = menuManage.getItemList();

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


        Scanner in = new Scanner(System.in);
        int stolik = rezerwujStolik();
        String imie;


        _kelner();

        System.out.println("\n" +
                ".---------------------------------------------.\n" +
                "|         Jezeli bedziesz juz gotowy,         |\n" +
                "| nacisnij Enter aby poprosic kelnera o menu. |\n" +
                "'---------------------------------------------'");

        pressAnyKeyToContinue();

        koszyk.addAll(addItemsDoKosztka());
        koszykstacjonar();

        _zamow();
        System.out.println("\n" +
                ".-------------------.\n" +
                "| Podaj swoje imie. |\n" +
                "'-------------------'\n");

        System.out.print("Wpisz:\n#");
        imie = in.nextLine();


        _koszyk();
        showKoszyk(koszyk);
        System.out.println("Dziekujemy!");
        Address address = new Address("", "", "");
        Customer customer = new Customer(imie, "", false, address, stolik);
        newOrderRestaurant(customer, koszyk);
        pressAnyKeyToContinue();















    }
    public void koszykstacjonar() {

        do {
            flag = false;
            _menu();
            System.out.println("\n" +
                    ".---------------------------------------.\n" +
                    "| #1 Dodaj nastepne danie do zamowienia |\n" +
                    "| #2 Pokaz aktualnie zamowione dania    |\n" +
                    "| #3 Złóz zamowienie                    |\n" +
                    "'---------------------------------------'\n");
            userChoice = userInputNextInt("Wybierz:\n#");

            switch (userChoice) {
                case 1:
                    koszyk.addAll(addItemsDoKosztka());
                    koszykstacjonar();
                    break;
                case 2:
                    _koszyk();
                    showKoszyk(koszyk);
                    pressAnyKeyToContinue();
                    koszykstacjonar();
                case 3:
                    flag = true;
                    break;
                default:
                    break;
            }


        } while (!flag);
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

    public static void sort() {

        tableOrderstoCook = (ArrayList<Order>) currentOrders.stream()
                .filter(order -> order.getStatus().equals(Status.REALIZACJA.toString()) &&
                        !order.isDelivery).collect(Collectors.toList());

        deliveryOrderstoCook = (ArrayList<Order>) currentOrders.stream()
                .filter(order -> order.getStatus().equals(Status.REALIZACJA.toString()) &&
                        order.isDelivery).collect(Collectors.toList());

        tableOrderstoCook = (ArrayList<Order>) tableOrderstoCook.stream()
                .sorted(Comparator.comparing(Order::getId)).collect(Collectors.toList());

        deliveryOrderstoCook = (ArrayList<Order>) deliveryOrderstoCook.stream()
                .sorted(Comparator.comparing(Order::getId)).collect(Collectors.toList());





    }



    public static class Order {

        static AtomicInteger orderID = new AtomicInteger();
        private final int id;

        private final Date orderDate;

        private HashMap <String, Date> daty;
        private final Customer customer;
        private final boolean isDelivery;
        private String status;
        private ArrayList <MenuManage.MenuItem> orderedItems;
        private int table;

        public Order(boolean isDelivery, String status, Customer customer, ArrayList<MenuManage.MenuItem> orderedItems) {

            id = orderID.incrementAndGet();
            this.customer = customer;
            this.isDelivery = isDelivery;
            this.status = status;
            this.orderedItems = orderedItems;
            this.orderDate = new Date();
            this.daty = new HashMap<>();
            daty.put(Status.ORDERDATE.toString(), orderDate);
            daty.put(Status.PREPARINGDATE.toString(), orderDate);
        }


        public HashMap<String, Date> getDaty() {
            return daty;
        }

        public int getId() {
            return id;
        }

        public void setCookedDate(Date date) {
            daty.put(Status.COOKDATE.toString(), date);
        }

        public void setPreparingDate(Date date) {
            daty.put(Status.PREPARINGDATE.toString(), date);
        }
        public void setDeliveredDate(Date date) {
            daty.put(Status.DELIVERYDATE.toString(), date);
        }


        public void setStatus(String status) {
            this.status = status;
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
        public void setTable(int table) {
            this.table = table;
        }
    }
}





