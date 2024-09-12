package org.example.adt;

import org.example.adt.nodes.Node;

public class DynamicQueue implements Queue {

    private Node first;

    @Override
    public int getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        return this.first.getValue();
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }
        this.first = this.first.getNext();
    }

    @Override
    public void add(int value) {
        if(this.isEmpty()) {
            this.first = new Node(value, null);
            return;
        }
        Node candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new Node(value, null));
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
