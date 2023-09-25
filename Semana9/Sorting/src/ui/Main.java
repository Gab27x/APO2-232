package ui;

import model.Person;
import model.Sorting;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<Person>();

        list.add(new Person(50));
        list.add(new Person(40));
        list.add(new Person(30));
        list.add(new Person(20));
        list.add(new Person(10));

        Sorting sorting = new Sorting(list);

        ArrayList<Person> sortedList = sorting.selectionSort();
        System.out.println(sortedList);


    }
}
