package Enums;

public enum Categories {

    ZESTAW ("ZESTAWY", 1),
    NAPOJ ("NAPOJE", 2),
    DODATKI ("DODATKI", 3),
    DESERY ("DESERY", 4);

    public final String name;
    public final int index;

    Categories(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
