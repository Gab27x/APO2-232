package model;

import java.util.Comparator;

public class ComparatorDate implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getDate().compareTo(p2.getDate());
    }
}
