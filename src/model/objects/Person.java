package model.objects;

public class Person {
    private String name;
    private int office;

    public Person(String name, int office) {
        this.name = name;
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public int getOffice() {
        return office;
    }
}
