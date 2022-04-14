package Menu;

import java.util.ArrayList;

public class MenuSection {

    private String title;
    private String description;

    public MenuSection
            (String title, String description, ArrayList<MenuItem> menuItems) {
        this.title = title;
        this.description = description;
    }


    static MenuSection newMenuSection (String title, String description, ArrayList<MenuItem> menuItems) {
        return new MenuSection(title, description, menuItems);
    }
    static MenuSection defaultMenuSection (String title, String description, ArrayList<MenuItem> menuItems) {

        return newMenuSection("Zestawy", "Costam", MenuItem.defaultItems());

    }





}