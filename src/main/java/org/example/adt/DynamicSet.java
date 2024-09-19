package org.example.adt;

import org.example.adt.nodes.Node;

import java.util.Random;

public class DynamicSet implements Set {

    private Node first;
    private final Random random;
    private int size;

    public DynamicSet() {
        this.first = null;
        this.random = new Random();
        this.size = 0;
    }

    @Override
    public void add(int a) {
        if(this.isEmpty()) {
            this.first = new Node(a, null);
            this.size++;
            return;
        }

        Node current = this.first;
        while(current.getNext() != null) {
            if(current.getValue() == a) {
                return;
            }
            current = current.getNext();
        }

        if(current.getValue() == a) {
            return;
        }

        current.setNext(new Node(a, null));
        this.size++;
    }

    @Override
    public int choose() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        int i = random.nextInt(size);
        int count = 0;
        Node current = this.first;
        while(current != null) {
            if(count == i) {
                return current.getValue();
            }
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public void remove(int a) {
        if(this.isEmpty()) {
            return;
        }
        if(this.first.getNext() == null) {
            if(this.first.getValue() == a) {
                this.first = null;
                this.size--;
            }
            return;
        }

        if(this.first.getValue() == a) {
            this.first = this.first.getNext();
            this.size--;
            return;
        }

        Node current = this.first.getNext();
        Node previous = this.first;
        while(current.getNext() != null) {
            if(current.getValue() == a) {
                // A, B, C
                // A -> B
                // B -> C

                // Quiero borrar B, entonces quiero que A -> C
                // A es previous
                // B es current
                // C es current.getNext()
                previous.setNext(current.getNext());
                this.size--;
                return;
            }
            previous = current;
            current = current.getNext();
        }

        if(current.getValue() == a) {
            previous.setNext(current.getNext());
            this.size--;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
