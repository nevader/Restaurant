package Control;

import Costumer.ManageOrder;

public class CilentInterface extends UserInterface{

    private ManageOrder manageOrder;

    public CilentInterface() {
        this.manageOrder = new ManageOrder();
    }

    public void jestemKlientem() {

        _logo();
        System.out.println(
                ".----------------------------.\n" +
                "| #1 Zarezerwuj stolik       |\n" +
                "| #2 Zamow z dostawa do domu |\n" +
                "| #3 Pokaz menu              |\n" +
                "| #0 Cofnij                  |\n" +
                "'----------------------------'\n");

        do {
            flag = false;
            userChoice = userInputNextInt("Wybierz opcje: \n#");

            switch (userChoice) {
                case 1:
                    break;

                case 2:
                    manageOrder.clearKoszyk();
                    manageOrder.placeDeliveryOrder();
                    jestemKlientem();
                    break;

                case 3:
                    break;

                case 0:
                    flag = true;
                    spacing();
                    break;

                default:
                    System.out.println("\nWybierz poprawną");
                    break;

            }
        } while (!flag);



    }


}
