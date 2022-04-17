package Personel;

import Control.MenagerInterface;
import Control.UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Manager extends UserInterface {


    public void addItem() {

        Scanner in = new Scanner(System.in);
        boolean isValidOption = false;

        _noweDanie();
        System.out.println(
                ".---------------------------.\n" +
                        "| Wpisz nazwę nowego dania: |\n" +
                        "'---------------------------'\n");
        System.out.print("#");
        String name = in.nextLine();


        _noweDanie();
        System.out.println("\n" +
                ".-------------------.\n" +
                "| Wpisz opis dania: |\n" +
                "'-------------------'");

        String desc = in.nextLine();



        double cena = 0;

        do {
            _noweDanie();
            System.out.println(
                    "\n" +
                            ".-------------------.\n" +
                            "| Wpisz cene dania: |\n" +
                            "'-------------------'");
            System.out.println("Podaj cene w formacie 'xx,xx' np. 1,42");
            try {
                cena = in.nextDouble();
                isValidOption = true;
            } catch (InputMismatchException e) {
                in.next(); //need to consume the invalid token to avoid an infinite loop
            }
        } while (!isValidOption);

        _noweDanie();
        System.out.println();



        _noweDanie();
        System.out.println("\n" +
                ".------------------------------------------------.\n" +
                "| Przypisz danie do jednej z podanych kategorii, |\n" +
                "|            lub utworz nowa kategorie.          |\n" +
                "'------------------------------------------------'");
        System.out.println(
                ".-----------------------------------------------.\n" +
                        "| Wpisz numer odpowiadajacy wybranej kategorii. |\n" +
                        "|       Jezeli chcesz dodac nowa wpisz '0'      |\n" +
                        "'-----------------------------------------------'");
        menu.printCategories();
        System.out.println("\n\n#0. DODAJ NOWĄ");

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
                    "'------------------------------'");
            in.nextLine();

            newKategory = in.nextLine();

            menu.addCategory(newKategory);


        } else {
            flag = false;

            do {
                if (kategoriaInt > menu.getCategoryList().size() + 1 ||
                        kategoriaInt < 1) {
                    System.out.println("Wybierz poprawna kategorie");
                } else {
                    newKategory = menu.getCategoryIndex(kategoriaInt);
                    flag = true;
                }
            } while (!flag);
        }

        menu.addItem(name, desc, newKategory, cena);
        _noweDanie();
        System.out.println("\n" +
                ".------------------------------------.\n" +
                "| Nowe danie zostało dodane do menu: |\n" +
                "'------------------------------------'");
        System.out.println(newKategory + " - " + name + ", $" + cena + "\n" + desc + "\n");

        System.out.println("\n" +
                ".---------------------.\n" +
                "| #1 Dodaj nowe danie |\n"  +
                "| #0 Wróc             |\n" +
                "'---------------------'\n");


        do {
            flag = false;
            userChoice = userInput("Wybierz opcje: \n#");
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

        System.out.print(
                ".--------------------------------------------.\n" +
                "|      Wybierz danie ktore chcesz usunąć.    |\n" +
                "| Wpisz liczbę która jest do niego przypisan |\n" +
                "'--------------------------------------------'");
        menu.printMenuItems();
        System.out.print("#0 Cofnij");

        userChoice = userInput("\n#");

        if (userChoice == 0) {
            return;
        }

        boolean removed = menu.removeItem(userChoice);

        if (removed) {
            System.out.println(
                    ".-----------------------.\n" +
                    "| #1 Usun kolejne danie |\n" +
                    "| #0 Cofnij             |\n" +
                    "'-----------------------'");

            do {
                userChoice = userInput("#");
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

    }

