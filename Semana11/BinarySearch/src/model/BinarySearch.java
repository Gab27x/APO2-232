package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {


    public int binarySearch(ArrayList<Integer> array, int goal){
        int left = 0; // obtenemos una referencia al puntero inicial
        int right = array.size() - 1;  // obtenemos una referencia al puntero final
        int mid = (left + right)/2;

        while (left <= right){

            if(array.get(mid) == goal){
                return mid;
            }
            else if (array.get(mid) > goal) {
                left = left;
                right = mid - 1;
            }
            else if (array.get(mid) < goal){
                left = mid + 1;
                right = right;
            }
            mid = (left + right)/2;

        }
        return -1;
    }

    // siempre retorna 0
    public int binaryRecursion(List<Integer> array, int goal){
        int left = 0;
        int right = array.size() - 1;
        int mid = (left + right)/2;

        if (left > right) {
            return -1;
        }
        else if (array.get(mid) > goal) {
            return binaryRecursion( array.subList(left, mid-1), goal);
        }
        else if (array.get(mid) < goal){
            return binaryRecursion( array.subList(mid+1, array.size()), goal);
        }
        return mid;
    }


   public int binarySearchRecursiveV2(ArrayList<Integer> array, int goal){
       return binarySearchRecursiveV2(array, goal, 0, array.size()-1);
   }

   private int binarySearchRecursiveV2(ArrayList<Integer> array, int goal, int left, int right){
       int mid = (left + right)/2;

       // caso iterativo, los elementos estan en el rango del arreglo
       if (left <= right){

           // Caso base --> el valor es encontrado
           if(array.get(mid) == goal){
               return mid;
           }
           // caso recursivo --> busqueda por izq
           else if (array.get(mid) > goal) {
               return binarySearchRecursiveV2(array, goal, left, mid-1);
           }
           // caso recursivo --> busqueda por der
           else if (array.get(mid) < goal){
               return binarySearchRecursiveV2(array, goal, mid + 1, right);
           }
       }
       // caso base --> no se encuentra el valor
       return -1;
   }

}
