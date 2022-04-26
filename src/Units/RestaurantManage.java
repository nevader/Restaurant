package Units;

import Enums.Status;
import UI.UserInterface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaurantManage extends UserInterface {

    private final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public void addItem() {

        Scanner in = new Scanner(System.in);
        boolean isValidOption = false;

        _noweDanie();
        System.out.println("\n" +
                ".---------------------------.\n" +
                "| Wpisz nazwę nowego dania: |\n" +
                "'---------------------------'\n");
        System.out.print("#");
        String name = in.nextLine();


        _noweDanie();
        System.out.println("\nNazwa dania: " + name + "\n\n" +
                ".-------------------.\n" +
                "| Wpisz opis dania: |\n" +
                "'-------------------'\n");

        System.out.print("#");
        String desc = in.nextLine();


        double cena = 0;

        do {
            _noweDanie();
            System.out.println("\nNazwa dania: " + name + "\n" +
                    "Opis dania: " + desc + "\n" +
                    "\n" +
                    ".----------------------------------------.\n" +
                    "| Podaj cene w formacie 'xx,xx' np. 1,42 |\n" +
                    "'----------------------------------------'\n");
            System.out.print("#");
            try {
                cena = in.nextDouble();
                isValidOption = true;
            } catch (InputMismatchException e) {
                in.next(); //need to consume the invalid token to avoid an infinite loop
            }
        } while (!isValidOption);


        _noweDanie();
        System.out.print("\nNazwa dania: " + name + "\n" +
                "Opis dania: " + desc + "\n" + "Cena dania: $" + cena + "\n\n" +
                ".------------------------------------------------.\n" +
                "| Przypisz danie do jednej z podanych kategorii, |\n" +
                "|            lub utworz nowa kategorie.          |\n" +
                "'------------------------------------------------'\n");
        menuManage.printCategories();
        System.out.println("\n#0. DODAJ NOWĄ\n");
        System.out.print("#");

        isValidOption = false;
        int kategoriaInt = 0;

        do {
            try {
                kategoriaInt = in.nextInt();
                isValidOption = true;
            } catch (InputMismatchException e) {
                in.next(); //need to consume the invalid token to avoid an infinite loop
            }
        } while (!isValidOption);

        String newKategory = "";

        if (kategoriaInt == 0) {

            _nowakategoria();

            System.out.println("\n" +
                    ".------------------------------.\n" +
                    "| Wpisz nazwe nowej kategorii: |\n" +
                    "'------------------------------'\n");
            System.out.print("#");
            in.nextLine();

            newKategory = in.nextLine();

            menuManage.addCategory(newKategory);


        } else {
            flag = false;

            do {
                if (kategoriaInt > menuManage.getCategoryList().size() + 1 ||
                        kategoriaInt < 1) {
                    System.out.println("Wybierz poprawna kategorie");
                } else {
                    newKategory = menuManage.getCategoryIndex(kategoriaInt);
                    flag = true;
                }
            } while (!flag);
        }

        menuManage.addItem(name, desc, newKategory, cena);
        _noweDanie();
        System.out.print("\n" +
                ".------------------------------------.\n" +
                "| Nowe danie zostało dodane do menu: |\n" +
                "'------------------------------------'\n");

        System.out.println("\nNazwa dania: " + name + "\n" +
                "Opis dania: " + desc + "\n" + "Cena dania: $" + cena + "\n" +
                "Kategoria dania: " + newKategory + "\n");

        System.out.println(
                ".---------------------.\n" +
                        "| #1 Dodaj nowe danie |\n" +
                        "| #0 Wróc             |\n" +
                        "'---------------------'\n");


        do {
            flag = false;
            userChoice = userInputNextInt("Wybierz opcje: \n#");
            switch (userChoice) {
                case 1:
                    addItem();
                    flag = true;
                    break;
                case 0:
                    flag = true;
                    break;
                default:
                    wybierzPoprawna();
                    break;
            }
        } while (!flag);

    }

    public void removeItem() {

        _usunDanie();

        System.out.print("\n" +
                ".--------------------------------------------.\n" +
                "|      Wybierz danie ktore chcesz usunąć.    |\n" +
                "| Wpisz liczbę która jest do niego przypisan |\n" +
                "'--------------------------------------------'");
        menuManage.printMenuItems();
        System.out.print("#0 Cofnij\n");

        userChoice = userInputNextInt("\nWybierz opcje: \n#");

        if (userChoice == 0) {
            return;
        }

        boolean removed = menuManage.removeItem(userChoice);

        if (removed) {
            System.out.println(
                    ".-----------------------.\n" +
                            "| #1 Usun kolejne danie |\n" +
                            "| #0 Cofnij             |\n" +
                            "'-----------------------'\n");

            do {
                userChoice = userInputNextInt("Wybierz opcje: \n#");
                switch (userChoice) {
                    case 1:
                        flag = true;
                        removeItem();
                        break;
                    case 0:
                        flag = true;
                        return;
                    default:
                        wybierzPoprawna();
                        break;
                }
            } while (!flag);
        }

    }

    public void printOrders() {

        _zamowienia();

        System.out.println("Current time: " + dateFormat.format(new Date().getTime()));
        for (int i = 0; i < OrdersManage.currentOrders.size(); i++) {
            int id = OrdersManage.currentOrders.get(i).getId();
            String isDelivery = OrdersManage.currentOrders.get(i).isDelivery() ? "przez portal" : "w restauracji";
            long orderedtime = OrdersManage.currentOrders.get(i).getDaty().get(Status.ORDERDATE.toString()).getTime();
            long startedCooking = OrdersManage.currentOrders.get(i).getDaty().get(Status.STARTEDCOOKING.toString())
                    == null ? 0 : OrdersManage.currentOrders.get(i).getDaty().get(Status.STARTEDCOOKING.toString())
                    .getTime();
            long finishedCooking = OrdersManage.currentOrders.get(i).getDaty().get(Status.FINISHEDCOOKING.toString())
                    == null ? 0 : OrdersManage.currentOrders.get(i).getDaty().get(Status.FINISHEDCOOKING.toString())
                    .getTime();
            long startedDelivery = OrdersManage.currentOrders.get(i).getDaty().get(Status.STARTEDDELIVERING.toString())
                    == null ? 0 : OrdersManage.currentOrders.get(i).getDaty().get(Status.STARTEDDELIVERING.toString())
                    .getTime();
            long finishedDelivery = OrdersManage.currentOrders.get(i).getDaty().get(Status.DELIVEREDDATE.toString())
                    == null ? 0 : OrdersManage.currentOrders.get(i).getDaty().get(Status.DELIVEREDDATE.toString())
                    .getTime();


            System.out.println("\n#########################\n" +
                    "ID #" + id + " |" + isDelivery + "|\n" +
                    "Godzine złożenia zamowienia: " + dateFormat.format(orderedtime) + "\n" +
                    "Godzina zaczecia przyzadzania dania: " + dateFormat.format(startedCooking) + "\n" +
                    "Godzina ukonczenia przyzadzania dania: " + dateFormat.format(finishedCooking) + "\n" +
                    "Godzina rozpoczecia dostawy: "  + dateFormat.format(startedDelivery) + "\n" +
                    "Godzina dostarczenia zamowienia: " + dateFormat.format(finishedDelivery));
        }
        System.out.println("#########################\n");
        System.out.println("table cook" + OrdersManage.tableOrderstoCook);
        System.out.println("delivery cook" +OrdersManage.deliveryOrderstoCook);
        System.out.println("table place" +OrdersManage.tableOrderstoPlace);
        System.out.println("delivery place" +OrdersManage.deliveryOrderstoPlace);
        }





    /*Personel*/
    public void addNewEmploy() {
        _nowyPracownik();
        Scanner in = new Scanner(System.in);
        System.out.println(
                "\n.-------------------------------.\n" +
                "| Podaj imię nowego pracownika: |\n" +
                "'-------------------------------'\n");
        System.out.println("Wpisz:");
        System.out.print("#");
        String imie = in.nextLine();

        _nowyPracownik();
        System.out.println(
                      "\n.-----------------------------------------.\n" +
                        "| Podaj numer telefonu nowego pracownika: |\n" +
                        "'-----------------------------------------'\n");
        System.out.println("Wpisz:");
        System.out.print("#");
        String telefon = in.nextLine();


        _nowyPracownik();
        System.out.println("\nRola nowego pracownika:\n" +
                ".-------------.\n" +
                "| #1 Kucharz  |\n" +
                "| #2 Dostawca |\n" +
                "'-------------'\n");
        do {
            flag = false;
            userChoice = userInputNextInt("Wybierz opcje: \n#");
            switch (userChoice) {
                case 1:
                    personelManage.addChef(imie, telefon);
                    _nowyPracownik();
                    System.out.println("\nWitaj na pokładzie " + imie + "!");
                    pressAnyKeyToContinue();
                    flag = true;
                    break;
                case 2:
                    personelManage.addDeliveryMan(imie, telefon);
                    _nowyPracownik();
                    System.out.println("\nWitaj na pokładzie " + imie + "!");
                    pressAnyKeyToContinue();
                    flag = true;
                    return;
                default:
                    _nowyPracownik();
                    System.out.println("\nRola nowego pracownika:\n" +
                            ".-------------.\n" +
                            "| #1 Kucharz  |\n" +
                            "| #2 Dostawca |\n" +
                            "'-------------'");
                    System.out.println("\nWYBIERZ POPRAWNĄ OPCJĘ!");
                    break;
            }
        } while (!flag);


    }

}