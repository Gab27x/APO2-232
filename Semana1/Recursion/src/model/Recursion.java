package model;

import java.util.ArrayList;

public class Recursion {

    private ArrayList<Integer> dp;

    public Recursion() {
        dp = new ArrayList<>(100);
        for(int i = 0; i< 100; i++){
            dp.add(null);
        }
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


    public int factorialDP(int n) {
        int result;

        if(dp.get(n) == null){
            // Caso base
            if (n == 0) {
                result = 1;
            }

            // caso recursivo
            else {
                result = n * factorialDP(n - 1);
                dp.set(n, result);
            }
        }else {
            result = dp.get(n);
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


    // Método recursivo en dos partes
    // Método fachada
    public int sum(int[] arr){
        return sum( arr, 1, arr[0]);
    }

    // Método que hace la recursión
    // Método recursivo Iterativo: porque en cada "iteración" se modifican los parámetros dentro del método
    private int sum(int[] arr, int index, int result){
        // Caso base
        if(index == arr.length){
            return result;
        }
        // Caso recursivo
        else {
            result += arr[index];
            return sum(arr, ++index , result);
        }
    }

    

    private int sum2(int[] arr, int index, int result){
        return (index < arr.length) ? sum2(arr, index + 1, result+arr[index]) : result;
    }

    public ArrayList<Integer> getDp() {
        return dp;
    }
}
