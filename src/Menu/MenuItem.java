package Menu;

import java.util.ArrayList;

public class MenuItem {

    static int menuItemID = 1;
    private String title;
    private String description;
    private double price;

    public MenuItem(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
        menuItemID++;
    }

    static MenuItem newItem (String title, String description, double price) {
        return new MenuItem(title, description, price);

    }

    static ArrayList<MenuItem> defaultItems () {

        ArrayList<MenuItem> items = new ArrayList<>();

        items.add(newItem("Gdaczący mały zestaw", "Zestaw dla dzieci, frytki, Sprunk i zabawkowy Bobby Broiler", 2));
        items.add(newItem("Gdaczący duży zestaw", "Frytki, Fillet Burger/Fowl Wrap/Large Wing Pieces i Sprunk", 5));
        items.add(newItem("Gdaczący ogromny zestaw", "Duży kubełek, podwójny Fillet Burger, Fowl Wrap, frytki i Sprunk", 10));
        items.add(newItem("Sałatka", "Sałatka i Sprunk", 20));
        items.add(newItem("Gowno", "Zdupy", 100));

        return items;

    }
}