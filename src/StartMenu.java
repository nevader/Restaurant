import Units.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StartMenu {

    public static Menu menu;
    private int wybor = 0;
    Scanner in = new Scanner(System.in);

    public StartMenu() {
        menu = new Menu();
    }

    public static Menu getMenu() {
        return menu;
    }

    private int userInput (String msg) {
        boolean isValidOption = false;

        do {
            System.out.println(msg + "\n>> ");
            try{
                wybor = in.nextInt();
                isValidOption = true;
            }catch(InputMismatchException e){
                in.next(); //need to consume the invalid token to avoid an infinite loop
                System.out.println("\n#!# Podaj właściwą liczbe #!#");
            }
        } while (!isValidOption);
        return wybor;
    }

    private void exit() {
        System.exit(0);
    }

    public void ekranPowitalny() {

        System.out.println("" +
                "\n\n###############################\n" +
                "### Witamy w Cluckin' Bell! ###\n" +
                "###############################\n");

            System.out.println("" +
                    " 1. Jestem klientem.\n" +
                    " 2. Zarządzam restauracją.\n" +
                    " 3. Wyjśćie.\n");

            do {
                wybor = userInput("Aby wybrac pozycje podaj odpowiadającą jej cyfre");
                switch (wybor) {
                    case 1:
                        jestemKlientem();
                        break;
                    case 2:
                        zarzadzamRestauracja();
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
                "1. Zarezerwuj stolik.\n" +
                "2. Zamow z dostawą do domu.\n" +
                "3. Pokaż menu.\n" +
                "4. Cofnij.\n");

        do {
            wybor = userInput("Aby wybrac pozycje podaj odpowiadającą jej cyfre");
            switch (wybor) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    menu.printMenu();
                    do {
                        wybor = userInput("1. Cofnij");

                    } while (wybor != 1);
                    jestemKlientem();
                case 4:
                    ekranPowitalny();
                    break;
                default:
                    System.out.println("\nWybierz poprawną");
                    break;

            }
        } while (wybor != 0);



    }

    private void zarzadzamRestauracja() {
        System.out.println("1\n2\n3\n4");
    }
}
