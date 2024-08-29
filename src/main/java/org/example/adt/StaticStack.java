package org.example.adt;

public class StaticStack implements Stack {

    private static final int MAX = 10000;

    private final int[] array;
    private int count;

    public StaticStack() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getTop() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope una pila vacia");
        }
        return array[this.count - 1];
    }

    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope una pila vacia");
        }
        count--;
    }

    @Override
    public void add(int value) {
        if(this.count == MAX) {
            throw new RuntimeException("La pila esta llena");
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
