package org.example.adt;

import org.example.adt.nodes.Node;

public class DynamicStack implements Stack {

    private Node first;

    @Override
    public int getTop() { // C + C = C
        if(this.isEmpty()) { // C
            throw new RuntimeException("No se puede desapilar una pila vacia"); // C
        } else {
            return this.first.getValue(); // N
        }
    }

    // C, LOG(N), N, N LOG(N), N^2, N^3, ...., N^M, 2^N, 3^N, ..., P^N, N!

    @Override
    public void remove() { // C + C = C
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia"); // C
        } else {
            this.first = this.first.getNext(); // C
        }
    }

    @Override
    public void add(int value) { // C
        this.first = new Node(value, this.first); // C
    }

    @Override
    public boolean isEmpty() { // C
        return this.first == null; // C
    }
}
