package Menu;

import java.util.ArrayList;

public class Menu {

    private int menuID;
    private String title;
    private String description;
    private ArrayList<MenuSection> menuSections;

    public Menu (int menuID, String title, String description, ArrayList<MenuSection> menuSections) {
        this.menuID = menuID;
        this.title = title;
        this.description = description;
        this.menuSections = menuSections;
    }

    public int getMenuID() {
        return menuID;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<MenuSection> getMenuSections() {
        return menuSections;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setMenuSections(ArrayList<MenuSection> menuSections) {
        this.menuSections = menuSections;
    }


}