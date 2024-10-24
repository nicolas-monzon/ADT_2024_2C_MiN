package org.example.adt;

public interface QueueOfBT {

    BinaryTree getFirst();
    void remove();
    void add(BinaryTree value);
    boolean isEmpty();

}
