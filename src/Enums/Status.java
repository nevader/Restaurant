package Enums;

public enum Status {
    REALIZACJA (1),
    GOTOWE(3),
    DOSTARCZONE(4),

    ORDERDATE(5),
    PREPARINGDATE(6),
    COOKDATE(7),
    DELIVERYDATE(8);


    public final int status;

    Status(int status) {
        this.status = status;
    }
}
