package ui;

import model.CircularLinkedList;
import model.Node;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList circular = new CircularLinkedList();

        circular.addNode(new Node("0"));
        circular.addNode(new Node("1"));
        circular.addNode(new Node("2"));
        circular.addNode(new Node("3"));
        circular.addNode(new Node("4"));
        circular.addNode(new Node("5"));

        circular.delete("10");

        System.out.println("this line has been executed after the exception");
    }
}
