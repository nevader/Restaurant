package Entities;

import DataTypes.Person;

public class Chef extends Person.Employee {
    private final long oneDishCookingTime = 30_000;

    public Chef(String name, String phone) {
        super(name, phone);
    }



}