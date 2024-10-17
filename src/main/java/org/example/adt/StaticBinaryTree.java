package org.example.adt;

public class StaticBinaryTree implements BinaryTree {

    private int indexRoot;
    private final Integer[] values;
    private final int MAX = 1023;

    public StaticBinaryTree(int root) {
        this.values = new Integer[MAX];
        this.indexRoot = 0;
        this.values[indexRoot] = root;
    }

    private StaticBinaryTree(int indexRoot, Integer[] values) {
        this.values = values;
        this.indexRoot = indexRoot;
    }

    @Override
    public int getRoot() {
        return this.values[indexRoot];
    }

    @Override
    public void addLeft(int value) {
        if(this.values[2*indexRoot + 1] != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        this.values[2*indexRoot + 1] = value;
    }

    @Override
    public void addRight(int value) {
        if(this.values[2*indexRoot + 2] != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
        this.values[2*indexRoot + 2] = value;
    }

    @Override
    public BinaryTree getLeft() {
        return new StaticBinaryTree(2*this.indexRoot + 1, this.values);
    }

    @Override
    public BinaryTree getRight() {
        return new StaticBinaryTree(2*this.indexRoot + 2, this.values);
    }

    @Override
    public void deleteLeft() {
        if(this.values[indexRoot*2 + 1] == null) {
            return;
        }
        BinaryTree left = this.getLeft();
        left.deleteLeft();
        left.deleteRight();
        this.values[2*indexRoot + 1] = null;
    }

    @Override
    public void deleteRight() {
        if(this.values[indexRoot*2 + 2] == null) {
            return;
        }
        BinaryTree right = this.getRight();
        right.deleteLeft();
        right.deleteRight();
        this.values[2*indexRoot +2] = null;
    }
}
