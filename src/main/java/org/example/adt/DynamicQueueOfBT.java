package org.example.adt;

import org.example.adt.nodes.NodeOfBT;

public class DynamicQueueOfBT implements QueueOfBT {

    private NodeOfBT first;

    @Override
    public BinaryTree getFirst() {
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
    public void add(BinaryTree value) {
        if(this.isEmpty()) {
            this.first = new NodeOfBT(value, null);
            return;
        }
        NodeOfBT candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new NodeOfBT(value, null));
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
