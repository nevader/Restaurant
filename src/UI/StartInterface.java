package UI;

import Restauracja.Tables;
import Units.PersonelManage;
import Units.MenuManage;

public class StartInterface extends UserInterface{

    public final static MenuManage MANAGE_MENU = new MenuManage();
    public final static PersonelManage MANAGE_PERSONEL = new PersonelManage();
    public final static Tables tables = new Tables();
    private final CilentInterface cilentInterface;
    private final MenagerInterface menagerInterface;


    public StartInterface() {
        this.cilentInterface = new CilentInterface();
        this.menagerInterface = new MenagerInterface();
    }

    public void ekranPowitalny() throws InterruptedException {

        _logo();
        System.out.println("\nWitamy w Cluckin' Bell!\n" +
                ".--------------------------.\n" +
                "| #1 Jestem klientem       |\n" +
                "| #2 Zarzadzam restauracja |\n" +
                "| #0 Wyjście               |\n" +
                "'--------------------------'\n");

        do {

            flag = false;
            userChoice = userInputNextInt("Wybierz opcje: \n#");

            switch (userChoice) {
                case 1:
                    cilentInterface.jestemKlientem();
                    spacing();
                    ekranPowitalny();
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
