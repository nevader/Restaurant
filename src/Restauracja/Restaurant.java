package Restauracja;

import java.util.ArrayList;

public class Restaurant {

    final String name;
    private ArrayList<Branch> branches;

    public Restaurant(ArrayList<Branch> branches) {
        this.name = "Cluckin' Bell";
        this.branches = branches;
    }
}