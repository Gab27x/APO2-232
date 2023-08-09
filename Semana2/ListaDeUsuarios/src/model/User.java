package model;

public class User {

    private int id;
    private User next;

    public User(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getNext() {
        return next;
    }

    public void setNext(User next) {
        this.next = next;
    }

    @Override
    public String toString(){
       return "id: " + id;
    }
}
