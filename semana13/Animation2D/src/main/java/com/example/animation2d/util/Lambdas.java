package com.example.animation2d.util;

public class Lambdas {

    // (<Params>) -> {<Executed code>};
   Sum add = (int x, int y) ->{
        System.out.printf("suma");
        return x+y;
    };

   public void executeSum(int x, int y){
       System.out.printf("\nresultado: " + add.sum(x, y));
   }
}

