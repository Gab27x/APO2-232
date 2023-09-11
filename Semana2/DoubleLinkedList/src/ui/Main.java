package ui;

import model.DoubleLinkedList;
import model.Node;

public class Main {

    private DoubleLinkedList<Integer> listOfIntegers;
    private DoubleLinkedList<String> listOfStrings;
    private DoubleLinkedList<User> listOfUser;
    public Main(){
        listOfIntegers = new DoubleLinkedList<>();
        listOfStrings = new DoubleLinkedList<>();
        listOfUser = new DoubleLinkedList<>();

    }

    public static void main(String[] args) {
        Main m = new Main();

        m.listOfIntegers.addLastUser(new Node<Integer>(0));
        m.listOfIntegers.addLastUser(new Node<Integer>(1));
        m.listOfIntegers.addLastUser(new Node<Integer>(2));
        m.listOfIntegers.addLastUser(new Node<Integer>(3));
        m.listOfIntegers.addLastUser(new Node<Integer>(4));

        m.listOfStrings.addLastUser(new Node<>("0"));
        m.listOfStrings.addLastUser(new Node<>("1"));
        m.listOfStrings.addLastUser(new Node<>("2"));
        m.listOfStrings.addLastUser(new Node<>("3"));
        m.listOfStrings.addLastUser(new Node<>("4"));
        m.listOfStrings.addLastUser(new Node<>("5"));

        m.listOfUser.addLastUser(new Node<User>(new User(0)));
        m.listOfUser.addLastUser(new Node<User>(new User(1)));
        m.listOfUser.addLastUser(new Node<User>(new User(2)));
        m.listOfUser.addLastUser(new Node<User>(new User(3)));
        m.listOfUser.addLastUser(new Node<User>(new User(4)));
        m.listOfUser.addLastUser(new Node<User>(new User(5)));

    }



}

// clase anonimizada
class User implements Comparable<User> {

    private int year;

    public User(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(User o) {
        return this.year - o.getYear();
    }
}
