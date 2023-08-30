package model;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    public void addNode(Node node){

        // list is empty
        if(this.head == null){
            this.head = node;
            this.tail = node;
            // Caso de la lista circular
            this.head.setPrevious(tail);
            this.tail.setNext(head);
        }
        // added to first position
        else {
            // connect node
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            // update
            this.tail = node;

            // Caso de la lista circular
            this.head.setPrevious(tail);
            this.tail.setNext(head);
        }
    }

    public String delete(String goal){
        return delete(goal, this.head);
    }

    // método recursivo
    private String delete(String goal, Node current){
        String str;

        // Caso base: La lista esta vacia
        if(head == null){
            str = "lis is empty";
        }
        // Caso Base: El elemento no existe
        else if(current == null){
            str = "This element does not exist";
        }
        // Caso base: estamos en el nodo a eliminar
        else if(current.getKey().equals(goal)){
            // sub Caso Base (Caso borde)
            if(current == this.head){
                this.head = current.getNext(); // Actualizar el estado de la lista

                // desconección del elemento
                current.setNext(null);
                this.head.setPrevious(null);
            }
            // sub Caso Base (Caso borde)
            else if(current == tail){
                this.tail = current.getPrevious(); // Actualizar el estado de la lista
                // desconección del elemento
                current.setPrevious(null);
                tail.setNext(null);
            }
            // sub caso
            else {
                // Actualizar el estado de la lista
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
                // desconección del elemento
                current.setNext(null);
                current.setPrevious(null);
            }
            str = "The user has been deleted";
        }
        // Caso recursivo
        else {
            str = delete(goal,current.getNext());
        }
        return str;
    }
}
