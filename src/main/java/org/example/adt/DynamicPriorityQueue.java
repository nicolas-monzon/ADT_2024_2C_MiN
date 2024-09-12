package org.example.adt;

import org.example.adt.nodes.PriorityNode;

public class DynamicPriorityQueue implements PriorityQueue {

    private PriorityNode node;

    @Override
    public int getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return this.node.getValue();
    }

    @Override
    public int getPriority() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad del primero de una cola vacia");
        }
        return this.node.getPriority();
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede remover el primero de una cola vacia");
        }
        this.node = this.node.getNext();
    }

    @Override
    public void add(int value, int priority) {
        if (this.isEmpty()) {
            this.node = new PriorityNode(value, priority, null);
            return;
        }

        if (this.node.getPriority() > priority) {
            this.node = new PriorityNode(value, priority, this.node);
            return;
        }

        PriorityNode candidate = this.node;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        if(candidate.getPriority() <= priority) {
            candidate.setNext(new PriorityNode(value, priority, null));
            return;
        }

        PriorityNode previous = this.node;
        PriorityNode current = this.node.getNext();

        // [2, 3]
        while(current != null) {
            if(previous.getPriority() <= priority && current.getPriority() > priority) {
                previous.setNext(new PriorityNode(value, priority, current));
            }
            previous = current;
            current = current.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }
}
