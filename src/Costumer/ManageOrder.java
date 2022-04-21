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
    private ArrayList <MenuItem> koszyk = new ArrayList<>();

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

    public void clearKoszyk() {
        koszyk.clear();
    }
    public ArrayList<MenuItem> addItemsDoKosztka () {

        ArrayList <MenuItem> koszyk = new ArrayList<>();
        ArrayList <MenuItem> listaDan = menu.getItemList();

        _koszyk();
        menu.printMenu();


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
    public void showKoszyk (ArrayList <MenuItem> koszyk) {

        double totalprice = 0;

        System.out.println("");
        for (int i = 0; i < koszyk.size(); i++) {
            System.out.print("#" + (i+1) + " " + koszyk.get(i).getName() +
                    " |" + koszyk.get(i).getPrice() + "|\n");

            totalprice += koszyk.get(i).getPrice();
        }
        System.out.println("Total price: $" + totalprice);


    }
    public void placeDeliveryOrder() {

        do {
            flag = true;
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
    public Customer daneDoDostawy() {
        Scanner in = new Scanner(System.in);
        ArrayList<MenuItem> koszyk = new ArrayList<>();

        String street;
        String city;
        String zipcode;

        String imie;
        String telefon;

        _dostawa();
        System.out.println("\nWypelnij formularz dotyczacy dostawy.");
        System.out.println(
                ".-------------------.\n" +
                        "| Jak masz na imie? |\n" +
                        "'-------------------'\n");
        System.out.println("Wpisz imie: ");
        System.out.print("#");
        imie = in.nextLine();

        _dostawa();
        System.out.println("\nWitaj, " + imie + "!\n" +
                "Wypelnij formularz dotyczacy dostawy.\n" +
                ".----------------------------.\n" +
                "| Podaj swoj numer telefonu: |\n" +
                "'----------------------------'\n");
        System.out.println("Wpisz swój numer telefonu: ");
        System.out.print("#");
        telefon = in.nextLine();

        _dostawa();
        System.out.println("\nWitaj, " + imie + "!\n" +
                "Wypelnij formularz dotyczacy dostawy.\n" +
                ".-------------------------------------------.\n" +
                "| Na jaki adres mamy dostarczyc zamowienie? |\n" +
                "'-------------------------------------------'\n");
        System.out.println("Wpisz swoje miasto: ");
        System.out.print("#");
        city = in.nextLine();

        _dostawa();
        System.out.println("\nWitaj, " + imie + "!\n" +
                "Wypelnij formularz dotyczacy dostawy.\n" +
                ".-------------------------------------------.\n" +
                "| Na jaki adres mamy dostarczyc zamowienie? |\n" +
                "'-------------------------------------------'\n");
        System.out.println("Wpisz swoj kod pocztowy: ");
        System.out.print("#");
        zipcode = in.nextLine();

        _dostawa();
        System.out.println("\nWitaj, " + imie + "!\n" +
                "Wypelnij formularz dotyczacy dostawy.\n" +
                ".-------------------------------------------.\n" +
                "| Na jaki adres mamy dostarczyc zamowienie? |\n" +
                "'-------------------------------------------'\n");
        System.out.println("Wpisz swoją ulice: ");
        System.out.print("#");
        street = in.nextLine();


        Address address = new Address(street, city, zipcode);
        Customer customer = new Customer(imie, telefon, true, address);

        return customer;

    }
    public void edytujDane() {}
    }



