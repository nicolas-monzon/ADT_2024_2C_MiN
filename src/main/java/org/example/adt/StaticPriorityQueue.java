package org.example.adt;

public class StaticPriorityQueue implements PriorityQueue {

    private static final int MAX = 10000;

    private final int[] values;
    private final int[] priorities;
    private int count;

    public StaticPriorityQueue() {
        this.values = new int[MAX];
        this.priorities = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getFirst() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return values[0];
    }

    @Override
    public int getPriority() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad una cola vacia");
        }
        return priorities[0];
    }

    @Override
    public void remove() {
        if(isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope una pila vacia");
        }
        for(int i = 0; i < count - 1; i++) {
            this.values[i] = this.values[i+1];
            this.priorities[i] = this.priorities[i+1];
        }
        count--;
    }

    @Override
    public void add(int value, int priority) {
        if(this.count == MAX) {
            throw new RuntimeException("La cola esta llena");
        }

        if(this.isEmpty()) {
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        if(this.priorities[count - 1] <= priority) {
            this.values[count] = value;
            this.priorities[count] = priority;
            this.count++;
            return;
        }

        if(this.priorities[0] > priority) {
            for(int i = this.count; i > 0; i--) {
                this.values[i] = this.values[i-1];
                this.priorities[i] = this.priorities[i-1];
            }
            this.values[0] = value;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        int index = -1;
        for(int i = 1; i < this.count; i++) {
            if(this.priorities[i - 1] <= priority && this.priorities[i] > priority) {
                index = i;
                break;
            }
        }
        for(int i = this.count; i > index; i--) {
            this.values[i] = this.values[i-1];
            this.priorities[i] = this.priorities[i-1];
        }

        this.values[index] = value;
        this.priorities[index] = priority;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
