import UI.StartInterface;

import static UI.StartInterface.MANAGE_MENU;
import static UI.StartInterface.MANAGE_PERSONEL;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        StartInterface startInterface = new StartInterface();
        MANAGE_MENU.addDefaultItems();
        MANAGE_PERSONEL.addDefaultPracownicy();


        startInterface.ekranPowitalny();



    }

}
