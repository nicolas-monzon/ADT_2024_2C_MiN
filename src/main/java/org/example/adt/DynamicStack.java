package org.example.adt;

import org.example.adt.nodes.Node;

public class DynamicStack implements Stack {

    private Node first;

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        return this.first.getValue();
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        this.first = this.first.getNext();
    }

    @Override
    public void add(int value) {
        this.first = new Node(value, this.first);
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
