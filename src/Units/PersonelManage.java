package Units;

import Entities.Chef;
import Entities.DeliveryMan;
import Entities.Waiter;

import java.util.ArrayList;

public class PersonelManage {
    public static ArrayList <Chef> listaKucharzy;
    public static ArrayList <DeliveryMan> listaDostawcow;
    public static ArrayList <Waiter> listaKelnerow;

    public PersonelManage() {
        listaDostawcow = new ArrayList<>();
        listaKucharzy = new ArrayList<>();
        listaKelnerow = new ArrayList<>();
    }


    public void addChef(String name, String telefon) {
        listaKucharzy.add(new Chef(name, telefon));
    }
    public void addDeliveryMan(String name, String telefon) {
        listaDostawcow.add(new DeliveryMan(name, telefon));
    }
    public void addWaiter(String name, String telefon) {
        listaKelnerow.add(new Waiter(name, telefon));
    }
    public void addDefaultPracownicy() {
        addChef("Maciek", "1234123-124124");
        addDeliveryMan("Seba", "123312-123");
        addWaiter("Krystyna", "123123-123123");
    }
    public void printListaPracownikow() {

        System.out.println("######| KUCHARZE |######");
        for (int i = 0; i < listaKucharzy.size(); i++) {
            System.out.println("ID #" + listaKucharzy.get(i).getId() + "\n"+
                    "Imię: " + listaKucharzy.get(i).getName() + "\n" +
                    "Telefon: " + listaKucharzy.get(i).getPhone() + "\n" +
                    "------------------------");
        }
        System.out.println("\n######| DOSTAWCY |######");
        for (int i = 0; i < listaDostawcow.size(); i++) {
            System.out.println("ID #" + listaDostawcow.get(i).getId() + "\n" +
                    "Imię: " + listaDostawcow.get(i).getName() + "\n" +
                    "Telefon: " + listaDostawcow.get(i).getPhone() + "\n" +
                    "Liczba dostarczonych zamowien: " + listaDostawcow.get(i).getDeliveredCount());
            System.out.printf("Napiwki: %,.2f \n", listaDostawcow.get(i).getTips());
            System.out.println("------------------------");
        }

        System.out.println("\n######| KELNERZY |######");
        for (int i = 0; i < listaKelnerow.size(); i++) {
            System.out.println("ID #" + listaKelnerow.get(i).getId() + "\n"+
                    "Imię: " + listaKelnerow.get(i).getName() + "\n"+
                    "Telefon: " + listaKelnerow.get(i).getPhone() + "\n"+
                    "Liczba dostarczonych zamowien: " + listaKelnerow.get(i).getDeliveredCount());
            System.out.printf("Napiwki: %,.2f \n", listaKelnerow.get(i).getTips());
            System.out.println("------------------------");
        }
    }

}
