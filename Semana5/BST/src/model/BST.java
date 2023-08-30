package model;

// Binary Search Tree
public class BST {

    private Node root;

    // trigger
    public void add(String key){
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
            return " null ";
        }
        else {
           return  inOrder(current.getLeft()) + " " + current.getKey() + " " + inOrder(current.getRight());
        }
    }

    public String getMin(){
        return getMin(root);
    }

    private String getMin(Node current){
        if(current.getLeft() == null){
            return current.getKey();
        }
        else {
            return getMin(current.getLeft());
        }
    }
}
