package ui;

import model.Recursion;

public class Main {
    public static void main(String[] args) {
        Recursion r = new Recursion();

        System.out.println(r.factorial(5));
        System.out.println(r.fibonnaci(4));
    }
}
