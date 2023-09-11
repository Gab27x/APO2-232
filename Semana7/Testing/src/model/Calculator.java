package model;

public class Calculator {

    public int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }
}
