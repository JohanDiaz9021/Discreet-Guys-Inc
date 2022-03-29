package model.objects;

import model.data_structures.HashTable;
import java.util.ArrayList;

public class Building {
    private char name;
    private int floors;
    private int num_offices;
    private HashTable<Integer, Person> offices;

    public Building(char name, int floors, int num_offices) {
        this.name = name;
        this.floors = floors;
        offices = new HashTable<>(floors * num_offices);
    }

    public char getName() {
        return name;
    }

    public int getFloors() {
        return floors;
    }

    public HashTable<Integer, Person> getOffices() {
        return offices;
    }
}
