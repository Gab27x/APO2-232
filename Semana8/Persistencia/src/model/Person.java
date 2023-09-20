package model;

public class Person {
    private String name;
    private String id;
    private int years;

    public Person(String name, String id, int years) {
        this.name = name;
        this.id = id;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String toString(){
        return "Name: " + this.name + " id: " + this.id + " years: " + this.years;
    }
}
