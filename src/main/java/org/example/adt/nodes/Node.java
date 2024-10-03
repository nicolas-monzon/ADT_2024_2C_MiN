package org.example.adt.nodes;

public class Node {

    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() { // C
        return value; // C
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() { // C
        return next; // C
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
