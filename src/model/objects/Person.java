package model.objects;

public class Person {
    private String name;
    private int position;
    private int office;

    public Person(String name, int position, int office) {
        this.name = name;
        this.position = position;
        this.office = office;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getOffice() {
        return office;
    }
}
