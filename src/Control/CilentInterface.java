package Control;

import Costumer.ManageOrder;

public class CilentInterface extends UserInterface{

    private ManageOrder manageOrder;

    public CilentInterface() {
        this.manageOrder = new ManageOrder();
    }

    public void jestemKlientem() {

        System.out.println(
                "\n1. Zarezerwuj stolik.\n" +
                        "2. Zamow z dostawą do domu.\n" +
                        "3. Pokaż menu.\n" +
                        "4. Cofnij.\n");

        do {
            flag = false;
            userChoice = userInputNextInt("Aby wybrac pozycje podaj odpowiadającą jej cyfre");

            switch (userChoice) {
                case 1:
                    break;

                case 2:
                    manageOrder.placeDeliveryOrder();
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:
                    System.out.println("\nWybierz poprawną");
                    break;

            }
        } while (!flag);



    }


}
