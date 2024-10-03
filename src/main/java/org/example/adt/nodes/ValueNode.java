package org.example.adt.nodes;

public class ValueNode {

    private int value;
    private ValueNode next;

    public ValueNode(int value, ValueNode next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ValueNode getNext() {
        return next;
    }

    public void setNext(ValueNode next) {
        this.next = next;
    }
}
