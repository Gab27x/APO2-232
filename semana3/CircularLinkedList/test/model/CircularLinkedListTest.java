package model;

import exception.IsEmptyCircularLinkedListException;
import exception.NodeNotFoundException;
import exception.NodeWithSameKeyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularLinkedListTest {

    private CircularLinkedList list;

    public void setUp1(){
        // list is empty
        list = new CircularLinkedList();
    }

    public void setUp2(){
        list = new CircularLinkedList();
        list.addNode(new Node("0"));
        list.addNode(new Node("1"));
        list.addNode(new Node("2"));
        list.addNode(new Node("3"));
        list.addNode(new Node("4"));
        list.addNode(new Node("5"));

    }


    @Test
    public void addNodeToEmptyListTest(){
        // setup
        setUp1();
        Node node = new Node("0");

        // act
        list.addNode(node);

        // assert
        assertEquals(list.getHead(), node);
        assertEquals(list.getTail(), node);
    }

    @Test
    public void addNodeToListTest(){
        // setup
        setUp2();
        Node node = new Node("6");

        // act
        list.addNode(node);

        // assert
        assertEquals(list.getTail(), node);
        assertEquals(list.getHead(), list.getTail().getNext());
    }

    @Test
    public void addExistNodeTest(){
        // setup
        setUp2();
        Node node = new Node("3");
        boolean isExceptionThrow = false;

        // act
        try {
            list.addNode(node);
        }catch (NodeWithSameKeyException e){
            isExceptionThrow = true;
        }
        // assert
        assertTrue(isExceptionThrow);
    }


    @Test
    public void addExistNodeTestV2(){
        // setup
        setUp2();
        Node node = new Node("5");

        // act &&  assert
        assertThrows(NodeWithSameKeyException.class, () -> { list.addNode(node); });
    }

    // test case del eliminar
    @Test
    public void deleteInEmptyList(){
        // setUp
        setUp1();
        boolean isExceptionThrow = false;

        // act
        try {
            list.delete("0", null);

        }catch (IsEmptyCircularLinkedListException e){

            isExceptionThrow = true;
        } catch (NodeNotFoundException e) {

            //
        }
        // assert
        assertTrue(isExceptionThrow);

    }

    @Test
    public void deleteTest(){

       setUp1();

       assertThrows(IsEmptyCircularLinkedListException.class, ()-> {list.delete("0"); });
    }


}
