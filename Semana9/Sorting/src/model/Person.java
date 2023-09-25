package model;

import java.util.Calendar;

public class Person implements Comparable<Person> {

    private String name;
    private int years;
    private Calendar date;

    public Person(int years) {
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", years=" + years +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        // 10 - 20 = -10
        return this.years - person.getYears();
    }
}
