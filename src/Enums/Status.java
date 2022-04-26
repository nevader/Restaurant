package Enums;

public enum Status {
    REALIZACJA (1),
    GOTOWE(3),
    DOSTARCZONE(4),

    ORDERDATE(5),
    STARTEDCOOKING(6),
    FINISHEDCOOKING(7),
    STARTEDDELIVERING(8),
    DELIVEREDDATE(9);


    public final int status;

    Status(int status) {
        this.status = status;
    }
}
