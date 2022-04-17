package Control;

import Personel.Manager;
import Units.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StartInterface extends UserInterface{

    public final static Menu menu = new Menu();
    private CilentInterface cilentInterface;
    private MenagerInterface menagerInterface;

    public StartInterface() {
        this.cilentInterface = new CilentInterface();
        this.menagerInterface = new MenagerInterface();
    }

    public void ekranPowitalny() {

        _logo();
        System.out.println("\nWitamy w Cluckin' Bell!\n" +
                ".--------------------------.\n" +
                "| #1 Jestem klientem       |\n" +
                "| #2 Zarzadzam restauracja |\n" +
                "| #0 Wyjście               |\n" +
                "'--------------------------'\n");

        do {

            flag = false;
            userChoice = userInput("Wybierz opcje: \n#");

            switch (userChoice) {
                case 1:
                    break;

                case 2:
                    menagerInterface.manageRestaurant();
                    spacing();
                    ekranPowitalny();
                    break;

                case 0:
                    System.out.println("Dziekujemy i zapraszamy ponownie!");
                    exit();

                default:
                    wybierzPoprawna();
                    break;

            }
        } while (!flag);


    }



}
