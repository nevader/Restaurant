package Units;

import Entities.Chef;
import Entities.DeliveryMan;

import java.util.ArrayList;

public class PersonelManage {
    public static ArrayList <Chef> listaKucharzy;
    public static ArrayList <DeliveryMan> listaDostawcow;

    public PersonelManage() {
        listaDostawcow = new ArrayList<>();
        listaKucharzy = new ArrayList<>();
    }


    public void addChef(String name, String telefon) {
        listaKucharzy.add(new Chef(name, telefon));
    }
    public void addDeliveryMan(String name, String telefon) {
        listaDostawcow.add(new DeliveryMan(name, telefon));
    }
    public void addDefaultPracownicy() {
        addChef("Maciek", "1234123-124124");
        addDeliveryMan("Seba", "123312-123");
    }
    public void printListaPracownikow() {

        System.out.println("Kucharze: ");
        for (int i = 0; i < listaKucharzy.size(); i++) {
            System.out.println(listaKucharzy.get(i).getName());
        }

        System.out.println("Dostawcy: ");
        for (int i = 0; i < listaDostawcow.size(); i++) {
            System.out.println(listaDostawcow.get(i).getName());
        }
    }



    // generic type? lista wszystkich pracownikow
}
