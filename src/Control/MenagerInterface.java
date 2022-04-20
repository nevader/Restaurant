package Control;

import Personel.Manager;

public class MenagerInterface extends UserInterface{

    private final Manager manager;

    public MenagerInterface() {
        this.manager = new Manager();
    }

    public void manageRestaurant() {

        _manager();;
        System.out.println("\nCzym chcesz zarządzać?\n" +
                ".---------------.\n" +
                "| #1 Menu       |\n" +
                "| #2 Zamowienia |\n" +
                "| #3 Personel   |\n" +
                "| #4 Finanse    |\n" +
                "| #0 Cofnij     |\n" +
                "'---------------'\n");


        do {
            flag = false;
            userChoice = userInputNextInt("Wybierz opcje: \n#");

            switch (userChoice) {
                case 1:
                    flag = true;
                    zarzadzajMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    flag = true;
                    break;
                default:
                    wybierzPoprawna();
                    break;
            }
        } while (!flag);
    }
    public void zarzadzajMenu() {

        _menu();
        System.out.println("\n"+
                ".--------------------------.\n" +
                "| #1 Zarzadzaj daniami     |\n" +
                "| #2 Zarzadzaj kategoriami |\n" +
                "| #3 Wyswietl menu         |\n" +
                "| #0 Cofnij                |\n" +
                "'--------------------------'\n");

        do {
            userChoice = userInputNextInt("Wybierz opcje: \n#");
            flag = false;
            switch (userChoice) {
                case 1:
                    flag = true;
                    zarzadzajDaniami();
                    break;
                case 2:
                    break;
                case 3:
                    menu.printMenu();
                    pressAnyKeyToContinue();
                    zarzadzajMenu();
                    break;
                case 0:
                    flag = true;
                    manageRestaurant();
                    break;
                default:
                    wybierzPoprawna();
            }
        } while (!flag);

    }
    public void zarzadzajDaniami() {

        _dania();
        System.out.println("\n"+
                ".----------------------------------.\n" +
                "| #1 Dodaj nowe danie              |\n" +
                "| #2 Usun danie                    |\n" +
                "| #3 Zapisz menu w pliku           |\n" +
                "| #4 Wczytaj menu z pliku          |\n" +
                "| #5 Wyswietl liste wszystkich dań |\n" +
                "| #0 Cofnij                        |\n" +
                "'----------------------------------'\n");

        do {
            userChoice = userInputNextInt("Wybierz opcje: \n#");
            flag = false;

            switch (userChoice) {
                case 1:
                    manager.addItem();
                    zarzadzajDaniami();
                    break;
                case 2:
                    manager.removeItem();
                    zarzadzajDaniami();
                    break;
                case 3:
                    menu.saveMenuItemsToFile();
                    zarzadzajDaniami();
                    break;
                case 4:
                    menu.loadMenuItemsFromFile();
                    break;
                case 5:
                    _dania();
                    menu.printMenuItems();
                    pressAnyKeyToContinue();
                    zarzadzajDaniami();
                case 0:
                    flag = true;
                    zarzadzajMenu();
                    break;
                default:
                    wybierzPoprawna();

            }
        } while (!flag);

    }
}