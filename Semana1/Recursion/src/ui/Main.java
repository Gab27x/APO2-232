package ui;

import model.Recursion;

public class Main {
    public static void main(String[] args) {
        Recursion r = new Recursion();

        System.out.println("Ejemplo Factorial");
        System.out.println(r.factorial(1));
        System.out.println(r.factorial(2));
        System.out.println(r.factorial(3));
        System.out.println(r.factorial(4));
        System.out.println(r.factorial(5));

        System.out.println("Ejemplo Factorial DP");
        System.out.println(r.factorialDP(1));
        System.out.println(r.factorialDP(2));
        System.out.println(r.factorialDP(3));
        System.out.println(r.factorialDP(4));
        System.out.println(r.factorialDP(5));

        System.out.println("Ejemplo Suma de elementos de un Array");
        int[] arr = {12, -1, 15, 2, 4 , 14};
        System.out.println(r.sum(arr));


        System.out.println("Ejemplo Fibonacci");
        System.out.println(r.fibonnaci(4));
    }
}
