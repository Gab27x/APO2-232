package model;

public class Node {

    private Node right;
    private Node left;

    private Integer key;

    public Node(Integer key) {
        this.key = key;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String toString(){
        return key+"";
    }
}
