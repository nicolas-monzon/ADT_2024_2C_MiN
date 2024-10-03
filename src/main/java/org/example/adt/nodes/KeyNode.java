package org.example.adt.nodes;

public class KeyNode {

    private int key;
    private ValueNode valueNode;
    private KeyNode next;

    public KeyNode(int key, ValueNode valueNode, KeyNode next) {
        this.key = key;
        this.valueNode = valueNode;
        this.next = next;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public ValueNode getValueNode() {
        return valueNode;
    }

    public void setValueNode(ValueNode valueNode) {
        this.valueNode = valueNode;
    }

    public KeyNode getNext() {
        return next;
    }

    public void setNext(KeyNode next) {
        this.next = next;
    }
}
