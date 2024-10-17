package org.example.adt;

public interface SearchBinaryTree {

    int getRoot();
    void add(int value);
    SearchBinaryTree getLeft();
    SearchBinaryTree getRight();
    void deleteLeft();
    void deleteRight();

}
