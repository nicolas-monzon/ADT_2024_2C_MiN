package org.example.adt.nodes;

public class PriorityNode {

    private int value;
    private int priority;
    private PriorityNode next;

    public PriorityNode(int value, int priority, PriorityNode next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PriorityNode getNext() {
        return next;
    }

    public void setNext(PriorityNode next) {
        this.next = next;
    }
}
