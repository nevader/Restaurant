package Enums;

public enum Status {
    PRZYJETE(1),
    GOTOWE(2),
    DOSTARCZONE(3),
    PRZEDAWNIONE(4),
    ANULOWANE(5),
    WYJSCIE(6),

    /*godziny*/
    ORDERED_DATE(7),
    STARTED_COOKING_DATE(8),
    FINISHED_COOKING_DATE(9),
    STARTED_DELIVERY_DATE(10),
    FINISHED_DELIVERY_DATE(11);

    public final int status;

    Status(int status) {
        this.status = status;
    }
}
