package model;

public class Recursion {

    public Recursion() {
    }

    public long factorial(long n) {
        long result;

        // Caso base
        if (n == 0) {
            result = 1;
        }

        // caso recursivo
        else {
            result = n * factorial(n - 1);
        }
        return result;
    }


    public long fibonnaci(long n) {
        long result;

        // Caso base
        if (n == 0 || n == 1) {
            result = n;
        }

        // caso recursivo
        else {
            result = fibonnaci(n-1) + fibonnaci(n-2);
        }
        return result;
    }


}
