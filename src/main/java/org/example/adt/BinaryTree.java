package org.example.adt;

public interface BinaryTree {

    int getRoot();
    void addLeft(int value);
    void addRight(int value);
    BinaryTree getLeft();
    BinaryTree getRight();
    void deleteLeft();
    void deleteRight();

}
