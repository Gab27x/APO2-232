package model;

import java.util.ArrayList;

public class Sorting {

    private ArrayList<Person> listToSort;

    public Sorting(ArrayList<Person> listToSort){
        this.listToSort = listToSort;
    }

    public ArrayList<Person> selectionSort(){
        int n = listToSort.size();
        for (int i = 0; i < n - 1 ; i++) {
            for (int j = i+1; j < n; j++) {
               if(listToSort.get(i).compareTo(listToSort.get(j)) > 0){
                   Person prev = listToSort.get(i);
                   Person current = listToSort.get(j);
                   listToSort.set(i , current);
                   listToSort.set(j, prev);
               }
            }
        }
        return listToSort;
    }
}
