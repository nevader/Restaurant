package UI;

import Units.OrdersManage;

public class CilentInterface extends UserInterface{

    private final OrdersManage ordersManage;

    public CilentInterface() {
        this.ordersManage = new OrdersManage();
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
                    ordersManage.clearKoszyk();
                    ordersManage.placeStacjonarne();
                    jestemKlientem();
                    break;

                case 2:
                    ordersManage.clearKoszyk();
                    ordersManage.deliveryMenu();
                    jestemKlientem();
                    break;

                case 3:
                    menuManage.printMenu();
                    pressAnyKeyToContinue();
                    jestemKlientem();
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
