package ui;

import model.BinarySearch;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-2);
        arr.add(0);
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(7);
        arr.add(9);

        BinarySearch binary = new BinarySearch();

        System.out.println(binary.binarySearch(arr, 11));

        System.out.println("*************");
        System.out.println("recursivo");
        // siempre me da como resultado 0
        // System.out.println(binary.binaryRecursion(arr, 5));

        System.out.println(binary.binarySearchRecursiveV2(arr, 5));
    }
}
