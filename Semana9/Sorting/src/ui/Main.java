package ui;

import model.ComparatorDate;
import model.Person;
import model.Sorting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<Person>();

        Calendar cal = Calendar.getInstance();

        list.add(new Person("e",50, cal));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        list.add(new Person("d",40, cal ));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        list.add(new Person("c",30, cal));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        list.add(new Person("b",20, cal));
        cal.add(Calendar.DAY_OF_MONTH, 1);
        list.add(new Person("a",10, cal));

        Sorting sorting = new Sorting();

        ArrayList<Person> sortedList = sorting.selectionSort(list);
        System.out.println(sortedList);

        ComparatorDate comparatorDate = new ComparatorDate();

        Collections.sort(list, comparatorDate);

        System.out.println("**************");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("**************");

        Comparator<Person> comparatorName = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Collections.sort(list, comparatorName);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
