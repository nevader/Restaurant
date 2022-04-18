package Units;

import Enums.Categories;
import Enums.Meals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    /*Zwraca kategorie pod podanym indexem*/
    public String getCategoryIndex (int index) {
        String error = "Podaj poprawna liczbe!";

        for (int i = 0; i < categoryList.size(); i++) {
            if (i == index-1)
                return categoryList.get(i);
        }
        return error;
    }

    /*Dodaje nowa kategorie do listy*/
    public void addCategory(String name) {
        categoryList.add(name.toUpperCase());
    }

    /*Wyswietla na ekranie wszystkie dostepne kategorie*/
    public void printCategories() {
        for (int i = 0; i < categoryList.size(); i++) {
            if (i%2 == 0)
                System.out.println("");

            System.out.print("#" + (i + 1) + ". " + categoryList.get(i) + "\t\t");
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
    public boolean removeItem (int id) {

        String itemName = "";

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getMenuItemID() == id) {
                itemName = itemList.get(i).getName();
            }
        }

        if (itemList.removeIf(menuItem -> menuItem.getMenuItemID() == id)) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("\n" +
                    "██╗░░░██╗░██████╗██╗░░░██╗███╗░░██╗  ██████╗░░█████╗░███╗░░██╗██╗███████╗\n" +
                    "██║░░░██║██╔════╝██║░░░██║████╗░██║  ██╔══██╗██╔══██╗████╗░██║██║██╔════╝\n" +
                    "██║░░░██║╚█████╗░██║░░░██║██╔██╗██║  ██║░░██║███████║██╔██╗██║██║█████╗░░\n" +
                    "██║░░░██║░╚═══██╗██║░░░██║██║╚████║  ██║░░██║██╔══██║██║╚████║██║██╔══╝░░\n" +
                    "╚██████╔╝██████╔╝╚██████╔╝██║░╚███║  ██████╔╝██║░░██║██║░╚███║██║███████╗\n" +
                    "░╚═════╝░╚═════╝░░╚═════╝░╚═╝░░╚══╝  ╚═════╝░╚═╝░░╚═╝╚═╝░░╚══╝╚═╝╚══════╝");
            System.out.println("\nUsunałes:\n" + "#" + id + " | " + itemName + "\n");

            MenuItem.menuItemID.set(0);
            for (int i = 0; i < itemList.size(); i++) {
                itemList.get(i).setId();

            }
            return true;
        } else {
            return false;
        }
    }




                       /*MENU*/

    /*Wyswietla na ekranie wszystkie dostepne dania*/
    public void saveMenuItemsToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("menu.txt"));
            for (int i = 0; i < itemList.size(); i++) {
                writer.write(
                        "•" + itemList.get(i).getName() + "\n" +
                        "¬" + itemList.get(i).getDescription() + "\n" +
                        "ƒ" + itemList.get(i).getCategory() + "\n" +
                        "‰" + itemList.get(i).getPrice() + "\n" +
                        "next\n");
            }
            writer.close();
        } catch (Exception e) {
            return;
        }
        System.out.println("Zapisano menu");
    }
    public void loadMenuItemsFromFile() {
        itemList.clear();
        MenuItem.menuItemID.set(0);
        String s = "";
        String name = "";
        String desc = "";
        String cate = "";
        String price = "";

        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("menu.txt"));

            while ((s = reader.readLine()) != null) {
                if (s.startsWith("•")) {
                    name = s.substring(1);
                } else if (s.startsWith("¬")) {
                    desc = s.substring(1);
                } else if (s.startsWith("ƒ")) {
                    cate = s.substring(1);
                } else if (s.startsWith("‰")) {
                    price = s.substring(1);
                } else if (s.equalsIgnoreCase("next")) {
                    addItem(name, desc, cate, Double.parseDouble(price));
                }
            }

        }catch(Exception ignored) {

        }

        System.out.println("Wczytano menu");
        printMenuItems();



    }
    public void printMenuItems() {
        System.out.println("\n"+
                ".----------------------------------.\n" +
                "| Wszystkie dostępne dania w menu: |\n" +
                "'----------------------------------'");

        for (int i = 0; i < itemList.size(); i++) {
            System.out.println("#" + itemList.get(i).getMenuItemID() + " | " + itemList.get(i).getName() +
                    " | $" + itemList.get(i).getPrice());
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

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(
                "███╗░░░███╗███████╗███╗░░██╗██╗░░░██╗\n" +
                        "████╗░████║██╔════╝████╗░██║██║░░░██║\n" +
                        "██╔████╔██║█████╗░░██╔██╗██║██║░░░██║\n" +
                        "██║╚██╔╝██║██╔══╝░░██║╚████║██║░░░██║\n" +
                        "██║░╚═╝░██║███████╗██║░╚███║╚██████╔╝\n" +
                        "╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚══╝░╚═════╝░\n");

        for (int i = 0; i < categoryList.size(); i++) {

                System.out.print("#########|" + categoryList.get(i)+ "|#########");


            for (int j = 0; j < itemList.size(); j++) {
                if (itemList.get(j).getCategory().equals(categoryList.get(i))) {
                    System.out.print("\n|" +itemList.get(j).getName() + "|  $" +
                            itemList.get(j).getPrice() + "\n" +
                            itemList.get(j).getDescription());
                }
                System.out.println();
            }
        }

        }

}


