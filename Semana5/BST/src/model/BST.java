package model;

import java.util.LinkedList;
import java.util.Queue;

// Binary Search Tree
public class BST {

    private Node root;

    public Node getRoot() {
        return root;
    }

    // trigger
    public void add(Integer key){
        Node node = new Node(key);
        if(root == null){
            root = node;
        }
        else {
            add(node, root);
        }
    }

    private void add(Node node, Node current){
       if(node.getKey().compareTo(current.getKey()) < 0){
           if(current.getLeft() == null){
               current.setLeft(node);
           }
           else {
               add(node, current.getLeft());
           }
       } else if (node.getKey().compareTo(current.getKey()) > 0) {
          if(current.getRight() == null){
              current.setRight(node);
          }
          else {
              add(node, current.getRight());
          }
       }
       else {
           // los nodos son iguales
       }
    }

    public String inOrder(){
        if (root == null){
            return "is empty tree";
        }
        else {
            return inOrder(this.root);
        }
    }

    private String inOrder(Node current){
        if(current == null){
            return "";
        }
        else {
            // llamdo por la izquierda
            // agregar a la lista
            // llamado por la derecha
            // return array
           return  inOrder(current.getLeft()) + " " + current.getKey() + " " + inOrder(current.getRight());
        }
    }

    public Node getMin(){
        return getMin(root);
    }

    private Node getMin(Node current){
        if(current.getLeft() == null){
            return current;
        }
        else {
            return getMin(current.getLeft());
        }
    }

    public void delete(Integer goal){
        delete(null, root, goal);
    }

    private void delete(Node parent, Node current, Integer goal){
        if(current == null){
            // el nodo no esta en el árbol
        }
        // Cuando encontramos el nodo
        if(goal.equals(current.getKey())){
            // El nodo es una hoja del árbol
            if(current.getLeft() == null && current.getRight() == null){
                if(current == this.root){
                    this.root = null;
                }
                // evaluar si el nodo es hijo izquierdo
                else if(parent.getLeft() == current){
                    parent.setLeft(null);
                }
                // evaluar si el nodo es hijo derecho
                else {
                    parent.setRight(null);
                }
            }
            // el nodo a eliminar tiene unicamente un hijo izquierdo
            else if (current.getLeft() != null && current.getRight() == null) {
                if(parent.getLeft() == current){
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            }
            // el nodo a eliminar tiene unicamente un hijo derecho
            else if (current.getLeft() == null && current.getRight() != null) {
                // el nodo es un hijo izquierdo
                if(parent.getLeft() == current){
                    parent.setLeft(current.getRight());
                }
                // el nodo es un hijo derecho
                else {
                    parent.setRight(current.getRight());
                }
            } else if (current.getLeft() != null && current.getRight() != null ) {
                // obtener el successor del nodo --> el menor nodo de los mayores
                Node successor = getMin(current.getRight());

                // un remplazo de los atributos
                current.setKey(successor.getKey());
                // current.setValue(successor.getValue());

                // eliminar el successor --> actualizar las conexiones
                delete(current, current.getRight(), successor.getKey());
            }
        }
        // cuando no lo encuentro
        else if (goal.compareTo(current.getKey()) < 0) {
           delete(current, current.getLeft(), goal);
        }
        else if(goal.compareTo(current.getKey()) > 0){
            delete(current, current.getRight(), goal);
        }
    }

    public void addInGroup(Integer[] arr){
        int start = 0;
        int end = arr.length-1;
        addInGroup(arr, start, end);
    }

    private void addInGroup(Integer[] arr, int start, int end){
        if(start <= end){
            int mid = (start + end)/2;

            add(arr[mid]);
            // left
            addInGroup(arr, start, mid-1);
            // right
            addInGroup(arr, mid+1, end);
        }
    }

}
