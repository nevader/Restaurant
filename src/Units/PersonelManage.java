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
        for (Chef chef : listaKucharzy) {
            System.out.println(chef.getName());
        }

        System.out.println("Dostawcy: ");
        for (DeliveryMan deliveryMan : listaDostawcow) {
            System.out.println("imie:" + deliveryMan.getName());
            System.out.println("ilosc dostarcznonych zamowien: #" + deliveryMan.getDeliveredCount());
            System.out.println("łączne napiwki: " + deliveryMan.getTips());
        }
    }



    // generic type? lista wszystkich pracownikow
}
