package model;

public class UserController {

    private User head;

    private User tail;

    public UserController(){}

    public User getHead() {
        return head;
    }

    public User getTail() {
        return tail;
    }

    public void addFirstUser(User user){

        // list is empty
        if(this.head == null){
            this.head = user;
            this.tail = user;
        }
        // added to first position
        else {
            // connect users
            user.setNext(this.head);
            // update head
            this.head = user;
        }

    }

    public void addLastUser(User user){

        // list is empty
        if(this.head == null){
            this.head = user;
            this.tail = user;
        }
        // added to first position
        else {
            // connect users
            this.tail.setNext(user);
            // update head
            this.tail = user;
        }
    }

    // Función de activación del metodo recursivo
   public String print(){
       /* En el primer llamado recursivo
        * el 'current' es igual a la cabeza de la lista
        *
        * head
        * |
        * 2 -> 1 -> 0
        * |         |
        * current   tail
        * */
        return print(this.head);
   }

    private String print(User current){
        String str = "";
        // Caso base, la lista esta completamente vacia
        if(head == null){
           str = "The list is empty";
        }
        // segundo caso base, la lista no esta vacia, see llega al final de la lista
        else if(current.getNext() == null){
            str += "" + current.getId();
        }
        // caso recursivo, se salta al siguiente elemento de la lista

        /*
        * Primer llamado recursivo current = 2
        *
        * head
        * |
        * 2 -> 1 -> 0 -> null
        * |         |
        * current   tail
        * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        *
        * Segundo llamado recursivo: current = 1
        * head
        * |
        * 2 -> 1 -> 0 -> null
        *      |    |
        * current   tail
        *
        * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
        * Tercer llamado recursivo: current = 0
        * Se llega al segundo caso base
        * head      current
        * |         |
        * 2 -> 1 -> 0 -> null
        *           |
        *           tail
        * */
        else {
            str += current.getId() + " "+ print(current.getNext());
        }
        return str;
    }
}
