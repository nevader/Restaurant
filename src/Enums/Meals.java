package Enums;

public enum Meals {

    MALY("Gdaczący mały zestaw", "Zestaw dla dzieci, frytki, Sprunk i zabawkowy Cluck Norris", 2),
    SREDNI("Gdaczący duży zestaw", "Frytki, Fillet Burger/Fowl Wrap/Large Wing Pieces i Sprunk", 5),
    DUZY("Gdaczący ogromny zestaw", "Duży kubełek, podwójny Fillet Burger, Fowl Wrap, frytki i Sprunk", 10);



    public final String name;
    public final String description;
    public final double price;

    Meals(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

}