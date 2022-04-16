package Control;

import Units.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Control {

    static Menu menu;
    private MenagerControl menagerControl;
    private ClientControl clientControl;
    static int wybor;

    public Control() {
        menu = new Menu();
        this.menagerControl = new MenagerControl();
        this.clientControl = new ClientControl();
        wybor = 0;
    }


    static void userInput (String msg) {

        boolean isValidOption = false;
        Scanner in = new Scanner(System.in);

        do {
            System.out.println(msg);
            try{
                wybor = in.nextInt();
                isValidOption = true;
            }catch(InputMismatchException e){
                in.next(); //need to consume the invalid token to avoid an infinite loop
                System.out.println("Podaj właściwą liczbe");
            }
        } while (!isValidOption);
    }
    public void exit() {
        System.exit(0);
    }
    static void wybierzPoprawna() {
        System.out.println("\nWybierz poprawną");
    }
    static void setWyborToZero() {
        wybor = 0;
    }



    public void ekranPowitalny() {
        menu.addDefaultItems();

        System.out.println("\n\n"+"                                                                                \n" +
                "  ▄▄█▀▀▀█▄█  ██                      ██         ██           ██       ▀███▀▀▀██▄          ██    ██  \n" +
                "▄██▀     ▀█  ██                      ██                      ▀▀        ██    ██           ██    ██  \n" +
                "██▀       ▀  ██   ██    ██  ▄██▀██   ██  ▄██▀  ███   ███████▄          ██    ██  ▄▄█▀██   ██    ██  \n" +
                "██           ██   ██    ██ ██▀  ██   ██ ▄█      ██   ██    ██          ██▀▀▀█▄▄▄ █▀   ██  ██    ██  \n" +
                "██▄          ██   ██    ██ ██        ██▄██      ██   ██    ██          ██    ▀██ █▀▀▀▀▀▀  ██    ██  \n" +
                "▀██▄     ▄▀  ██   ██    ██ ██▄       ██  ▀██▄   ██   ██    ██          ██    ▄██ █▄    ▄  ██    ██  \n" +
                "  ▀▀█████▀ ▄████▄ ▀████▀██ ▄█████▀   ████▄  ██▄ ████ ███  ████▄      ▄██████████ ▀█████▀▄████▄▄████▄\n" +
                "                                                                                                 " +
                "                                                                                                 ");

        System.out.println("\nWitamy w Cluckin' Bell!\n" +
                ".--------------------------.\n" +
                "| 1. Jestem klientem       |\n" +
                "| 2. Zarzadzam restauracja |\n" +
                "| 3. Wyjście               |\n" +
                "'--------------------------'\n");

        do {

            userInput("Aby wybrac pozycje podaj odpowiadającą jej cyfre");

            switch (wybor) {
                case 1:
                    jestemKlientem();
                    setWyborToZero();
                    break;

                case 2:
                    zarzadzamRestauracja();
                    setWyborToZero();
                    break;

                case 3:
                    System.out.println("Dziekujemy i zapraszamy ponownie!");
                    exit();

                default:
                    System.out.println("\nWybierz poprawną");
                    break;

            }
        } while (wybor != 0);


    }
    private void jestemKlientem() {

        System.out.println(
                        "\n1. Zarezerwuj stolik.\n" +
                        "2. Zamow z dostawą do domu.\n" +
                        "3. Pokaż menu.\n" +
                        "4. Cofnij.\n");

        do {
            userInput("Aby wybrac pozycje podaj odpowiadającą jej cyfre");

            switch (wybor) {
                case 1:
                    setWyborToZero();
                    break;

                case 2:
                    setWyborToZero();
                    break;

                case 3:
                    menu.printMenu();

                case 4:
                    ekranPowitalny();
                    setWyborToZero();
                    break;

                default:
                    System.out.println("\nWybierz poprawną");
                    break;

            }
        } while (wybor != 0);



    }


    /*Zarzadzaj restauracja | głowne menu*/
    public void zarzadzamRestauracja() {

        menagerControl.menager();
        System.out.println("\nCzym chcesz zarządzać?\n" +
                ".---------------.\n" +
                "| 1. Menu       |\n" +
                "| 2. Zamowienia |\n" +
                "| 3. Personel   |\n" +
                "| 4. Finanse    |\n" +
                "| 5. Cofnij     |\n" +
                "'---------------'\n");


        do {
            userInput("Aby wybrac pozycje podaj odpowiadającą jej cyfre");

            switch (wybor) {
                case 1:
                    zarzadzajMenu();
                    setWyborToZero();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    ekranPowitalny();
                    setWyborToZero();
                    break;
                default:
                    wybierzPoprawna();
                    break;
            }
        } while (wybor != 0);
    }
    public void zarzadzajMenu() {

        menagerControl.menu();
        System.out.println(""+
                ".--------------------------.\n" +
                "| 1. Zarzadzaj daniami     |\n" +
                "| 2. Zarzadzaj kategoriami |\n" +
                "| 3. Cofnij                |\n" +
                "'--------------------------'\n");

        do {
            userInput("Aby wybrac pozycje podaj odpowiadającą jej cyfre");

            switch (wybor) {
                case 1:
                    zarzadzajDaniami();
                    setWyborToZero();
                    break;
                case 2:
                    break;
                case 3:
                    zarzadzamRestauracja();
                    setWyborToZero();
                    break;
                default:
                    wybierzPoprawna();
            }
        } while (wybor != 0);

    }
    public void zarzadzajDaniami() {

        menagerControl.dania();
        System.out.println("\n"+
                ".----------------------------------.\n" +
                "| 1. Dodaj nowe danie              |\n" +
                "| 2. Usun danie                    |\n" +
                "| 3. Wyswietl liste wszystkich dan |\n" +
                "| 4. Cofnij                        |\n" +
                "'----------------------------------'\n");

        do {
            userInput("Wybierz");

            switch (wybor) {
                case 1:
                    menagerControl.addItem();
                    zarzadzajDaniami();
                    setWyborToZero();
                    break;
                case 2:
                    setWyborToZero();
                    break;
                case 3:
                    menu.printMenuItems();
                    zarzadzajDaniami();
                    setWyborToZero();
                    break;
                case 4:
                    zarzadzajMenu();
                    setWyborToZero();
                    break;
                default:
                    wybierzPoprawna();

            }
        } while (wybor != 0);

    }


}
