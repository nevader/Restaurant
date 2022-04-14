package DataTypes;

import DataTypes.Person;

import java.util.Date;

public abstract class Employee extends Person {

    private int employeeID;
    private Date dateJoined;

    public Employee(String name, String phone, int employeeID, Date dateJoined) {
        super(name, phone);
        this.employeeID = employeeID;
        this.dateJoined = dateJoined;
    }
}