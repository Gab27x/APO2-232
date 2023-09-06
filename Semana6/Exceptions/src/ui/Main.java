package ui;

import java.lang.management.ManagementFactory;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private Scanner sc;

    public Main(){
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.div2();
        System.out.println("program finish ");
    }


    public void readLine(){
        System.out.println("type a number ");
        try{
            sc.nextInt();
        }catch (InputMismatchException ime){
            System.out.println("El valor ingresado no es un valor numerico");
        }
    }

    public void div(){
        try {
            System.out.println("type first number ");
            int a = sc.nextInt();
            System.out.println("type second number ");
            int b = sc.nextInt();

            double c = a/b;
            System.out.println(c);
        }catch (InputMismatchException ime){
            System.out.println("El valor ingresado no es numerico");
            ime.printStackTrace();
        }catch (ArithmeticException ae){
            System.out.println("el segundo valor debe ser diferente de 0");
        }
    }



    public void div2(){
        int a = 1;
        int b = 1;
        int c = 0;
        try {
            System.out.println("type first number ");
            a = sc.nextInt();
            System.out.println("type second number ");
            b = sc.nextInt();
            c = a/b;
            System.out.println(c);
        }catch (InputMismatchException | ArithmeticException ex) {
            if (ex instanceof InputMismatchException){
                System.out.println("Input ex");
                System.out.println("El valor ingresado no es numerico");

                System.out.println("type second number ");
            }
            else {
                System.out.println("ArithmeticException");
                System.out.println("el segundo valor debe ser diferente de 0");
            }
            ex.printStackTrace();
        }
    }


}
