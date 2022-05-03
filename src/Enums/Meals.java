package Enums;

public enum Meals {

    MALY("Gdaczący mały zestaw", "Zestaw dla dzieci, frytki, Sprunk i zabawkowy Cluck Norris", 2.50),
    SREDNI("Gdaczący duży zestaw", "Fowl Wrap, frytki i Sprunk", 5.20),
    DUZY("Gdaczący ogromny zestaw", "Duży kubełek, Fowl Wrap, frytki i Sprunk", 10.10);



    public final String name;
    public final String description;
    public final double price;

    Meals(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

}