package Units;


import Enums.Categories;
import Enums.Meals;

import java.util.ArrayList;

public class Menu {

    private ArrayList<MenuItem> itemList;
    private ArrayList<String> categoryList;

    /*
    * Domyslny konstruktor klasy Menu,
    * inicjalizuje liste:
    * <MenuItem> itemList
    *
    * inicjalizuje i wypelnia domyslnymi wartosciami z Enum:
    * <String> categoryList
    *
    * */
    public Menu() {
        itemList = new ArrayList<>();
        categoryList = new ArrayList<>();

        categoryList.add(Categories.ZESTAW.toString());
        categoryList.add(Categories.NAPOJ.toString());
        categoryList.add(Categories.DODATKI.toString());
        categoryList.add(Categories.DESERY.toString());
    }



                 /*KATEGORIE*/

    /*Zwraca liste kategorii*/
    public ArrayList<String> getCategoryList() {
        return categoryList;
    }

    /*Dodaje nowa kategorie do listy*/
    public void addCategory(String name) {
        categoryList.add(name.toUpperCase());
    }

    /*Wyswietla na ekranie wszystkie dostepne kategorie*/
    public void printCategories() {
        System.out.println("Kategorie do wyboru: ");
        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println((i + 1) + "." + categoryList.get(i));
        }
    }



                      /*DANIA*/

    /*Zwraca liste dań*/
    public ArrayList<MenuItem> getItemList() {
        return itemList;
    }

    /*Przypisuje nowa liste dan*/
    public void setItemList(ArrayList<MenuItem> itemList) {
        this.itemList = itemList;
    }

    /*Zwraca danie z listy pod podanym indexem*/
    public MenuItem getMenuItem (int index) {
        return itemList.get(index);
    }

    /*Dodaje nowe danie do listy*/
    public void addItem(String name, String description, String category, double price) {
        MenuItem menuItem = new MenuItem(name, description, category, price);
        itemList.add(menuItem);
    }

    /*Edytuje pola danego dania*/
    public void editItem() {}

    /*Usuwa wybrane danie z listy po podaniu jego ID*/
    public void removeItem (int id) {
            itemList.removeIf(n -> (n.getMenuItemID() == id));
    }




                       /*MENU*/

    /*Wyswietla na ekranie wszystkie dostepne dania*/
    public void printMenuItems() {
        System.out.println("Wszystkie pozycje w menu:");

        for (int i = 0; i < itemList.size(); i++) {
            System.out.println("ID: #" + itemList.get(i).getMenuItemID() + " -- " +
                    itemList.get(i).getName());
        }

    }

    /*Dodaje domyślne danie do listy*/
    public void addDefaultItems() {
        addItem(Meals.DUZY.name, Meals.DUZY.description, Categories.ZESTAW.toString(), Meals.DUZY.price);
        addItem(Meals.SREDNI.name, Meals.SREDNI.description, Categories.ZESTAW.toString(), Meals.SREDNI.price);
        addItem(Meals.MALY.name, Meals.MALY.description, Categories.ZESTAW.toString(), Meals.MALY.price);

    }

    /*Wyswietla całe menu, sortuje dania po kategoriach*/
    public void printMenu() {

        for (int i = 0; i < categoryList.size(); i++) {
            System.out.println(categoryList.get(i));

            for (int j = 0; j < itemList.size(); j++) {
                if (itemList.get(j).getCategory().equals(categoryList.get(i))) {
                    System.out.println(itemList.get(j).getName() + "  $" +
                            itemList.get(j).getPrice() + "\n" +
                            itemList.get(j).getDescription() + "\n");
                }
            }
        }

        }

    public static class a{
        public static void main(String[] args) {
            Menu menu = new Menu();
            menu.printMenuItems();
        }
    }

}


