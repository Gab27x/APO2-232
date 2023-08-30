package ui;

import model.BST;

public class Main {

    private BST tree;

    public Main(){
        tree = new BST();
    }

    public static void main(String[] args) {
        Main m = new Main();

        m.tree.add("50");
        m.tree.add("30");
        m.tree.add("70");
        m.tree.add("60");
        m.tree.add("80");
        m.tree.add("20");
        m.tree.add("40");

        System.out.println(m.tree.inOrder());
        System.out.println(m.tree.getMin());
    }
}
