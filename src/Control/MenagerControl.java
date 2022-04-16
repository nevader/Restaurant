package Control;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenagerControl {

    public void spacing() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void menager() {
        spacing();
        System.out.println(
                "███╗░░░███╗███████╗███╗░░██╗░█████╗░░██████╗░███████╗██████╗░\n" +
                        "████╗░████║██╔════╝████╗░██║██╔══██╗██╔════╝░██╔════╝██╔══██╗\n" +
                        "██╔████╔██║█████╗░░██╔██╗██║███████║██║░░██╗░█████╗░░██████╔╝\n" +
                        "██║╚██╔╝██║██╔══╝░░██║╚████║██╔══██║██║░░╚██╗██╔══╝░░██╔══██╗\n" +
                        "██║░╚═╝░██║███████╗██║░╚███║██║░░██║╚██████╔╝███████╗██║░░██║\n" +
                        "╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝╚═╝░░╚═╝░╚═════╝░╚══════╝╚═╝░░╚═╝");
    }

    public void menu() {
        spacing();
        System.out.println(
                "███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗\n" +
                        "████╗░████║██╔════╝████╗░██║██║░░░██║\n" +
                        "██╔████╔██║█████╗░░██╔██╗██║██║░░░██║\n" +
                        "██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║\n" +
                        "██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝\n" +
                        "╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░");
    }

    public void dania() {
        spacing();
        System.out.println(
                "██████╗░░█████╗░███╗░░██╗██╗░█████╗░\n" +
                        "██╔══██╗██╔══██╗████╗░██║██║██╔══██╗\n" +
                        "██║░░██║███████║██╔██╗██║██║███████║\n" +
                        "██║░░██║██╔══██║██║╚████║██║██╔══██║\n" +
                        "██████╔╝██║░░██║██║░╚███║██║██║░░██║\n" +
                        "╚═════╝░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝╚═╝░░╚═╝");
    }

    public void noweDanie() {
        spacing();
        System.out.println(
                "███╗░░██╗░█████╗░░██╗░░░░░░░██╗███████╗  ██████╗░░█████╗░███╗░░██╗██╗███████╗\n" +
                        "████╗░██║██╔══██╗░██║░░██╗░░██║██╔════╝  ██╔══██╗██╔══██╗████╗░██║██║██╔════╝\n" +
                        "██╔██╗██║██║░░██║░╚██╗████╗██╔╝█████╗░░  ██║░░██║███████║██╔██╗██║██║█████╗░░\n" +
                        "██║╚████║██║░░██║░░████╔═████║░██╔══╝░░  ██║░░██║██╔══██║██║╚████║██║██╔══╝░░\n" +
                        "██║░╚███║╚█████╔╝░░╚██╔╝░╚██╔╝░███████╗  ██████╔╝██║░░██║██║░╚███║██║███████╗\n" +
                        "╚═╝░░╚══╝░╚════╝░░░░╚═╝░░░╚═╝░░╚══════╝  ╚═════╝░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝╚══════╝");
    }

    public void nowakategoria() {
        spacing();
        System.out.println(
                "███╗░░██╗░█████╗░░██╗░░░░░░░██╗░█████╗░  ██╗░░██╗░█████╗░████████╗███████╗░██████╗░░█████╗░██████╗░██╗░█████╗░\n" +
                        "████╗░██║██╔══██╗░██║░░██╗░░██║██╔══██╗  ██║░██╔╝██╔══██╗╚══██╔══╝██╔════╝██╔════╝░██╔══██╗██╔══██╗██║██╔══██╗\n" +
                        "██╔██╗██║██║░░██║░╚██╗████╗██╔╝███████║  █████═╝░███████║░░░██║░░░█████╗░░██║░░██╗░██║░░██║██████╔╝██║███████║\n" +
                        "██║╚████║██║░░██║░░████╔═████║░██╔══██║  ██╔═██╗░██╔══██║░░░██║░░░██╔══╝░░██║░░╚██╗██║░░██║██╔══██╗██║██╔══██║\n" +
                        "██║░╚███║╚█████╔╝░░╚██╔╝░╚██╔╝░██║░░██║  ██║░╚██╗██║░░██║░░░██║░░░███████╗╚██████╔╝╚█████╔╝██║░░██║██║██║░░██║\n" +
                        "╚═╝░░╚══╝░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝░░╚═╝  ╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝░╚═════╝░░╚════╝░╚═╝░░╚═╝╚═╝╚═╝░░╚═╝");
    }

    public void addItem() {

        Scanner in = new Scanner(System.in);

        noweDanie();
        System.out.println(
                ".---------------------------.\n" +
                        "| Wpisz nazwę nowego dania: |\n" +
                        "'---------------------------'");

        String name = in.nextLine();

        noweDanie();
        System.out.println("\n" +
                ".-------------------.\n" +
                "| Wpisz opis dania: |\n" +
                "'-------------------'");

        String desc = in.nextLine();


        boolean isValidOption = false;
        double cena = 0;

        do {
            noweDanie();
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

        noweDanie();
        System.out.println();

        Control.menu.printCategories();


        noweDanie();
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
        Control.menu.printCategories();
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

            nowakategoria();

            System.out.println("\n" +
                    ".------------------------------.\n" +
                    "| Wpisz nazwe nowej kategorii: |\n" +
                    "'------------------------------'");
            in.nextLine();

            newKategory = in.nextLine();

            Control.menu.addCategory(newKategory);


        } else {
            boolean flag = false;

            do {
                if (kategoriaInt > Control.menu.getCategoryList().size() + 1 ||
                        kategoriaInt < 1) {
                    System.out.println("Wybierz poprawna kategorie");
                } else {
                    newKategory = Control.menu.getCategoryIndex(kategoriaInt);
                    flag = true;
                }
            } while (!flag);
        }

        Control.menu.addItem(name, desc, newKategory, cena);
        noweDanie();
        System.out.println("\n" +
                ".------------------------------------.\n" +
                "| Nowe danie zostało dodane do menu: |\n" +
                "'------------------------------------'");
        System.out.println(newKategory + " - " + name + ", $" + cena + "\n" + desc + "\n");

        System.out.println("\n" +
                ".---------------------.\n" +
                "| 1. Dodaj nowe danie |\n"  +
                "| 0. Wróc             |\n" +
                "'---------------------'\n");

        do {
            Control.userInput("");
            switch (Control.wybor) {
                case 1:
                    addItem();
                    Control.setWyborToZero();
                    break;
                case 0:
                    Control.setWyborToZero();
                    break;
                default:
                    Control.wybierzPoprawna();
                    break;
            }
        } while (Control.wybor != 0);

    }
}