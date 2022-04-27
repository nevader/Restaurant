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

        System.out.println("Kucharze: ");
        for (int i = 0; i < listaKucharzy.size(); i++) {
            System.out.println(listaKucharzy.get(i).getName());
        }

        System.out.println("Dostawcy: ");
        for (int i = 0; i < listaDostawcow.size(); i++) {
            System.out.println("imie:" + listaDostawcow.get(i).getName());
            System.out.println("ilosc dostarcznonych zamowien: #" +listaDostawcow.get(i).getDeliveredCount());
            System.out.println("łączne napiwki: " + listaDostawcow.get(i).getTips());
        }
    }



    // generic type? lista wszystkich pracownikow
}
