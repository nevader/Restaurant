import Menu.Menu;
import Menu.MenuSection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Konsola{

    Scanner in = new Scanner(System.in);

    private int wybor = 0;

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
                wybor = userInput("⬤ Aby wybrac pozycje podaj odpowiadającą jej cyfre ⬤");
                switch (wybor) {
                    case 1:
                        jestemKlientem();
                        exit();
                        break;
                    case 2:
                        zarzadzamRestauracja();
                        exit();
                        break;
                    case 3:
                        System.out.println("Dziekujemy i zapraszamy ponownie!");
                        exit();
                        break;
                    default:
                        System.out.println("\nWybierz poprawną");
                        break;

                }
            } while (wybor != 0);







    }

    private void exit() {
        wybor = 0;
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

    private void jestemKlientem() {

    }

    private void zarzadzamRestauracja() {
        System.out.println("1\n2\n3\n4");
    }
}
