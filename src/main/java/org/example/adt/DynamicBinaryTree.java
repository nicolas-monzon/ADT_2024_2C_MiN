package org.example.adt;

public class DynamicBinaryTree implements BinaryTree {

    private int root;
    private DynamicBinaryTree left;
    private DynamicBinaryTree right;

    public DynamicBinaryTree(int root) {
        this.root = root;
    }

    @Override
    public int getRoot() {
        return root;
    }

    @Override
    public void addLeft(int value) {
        if(this.left != null) {
            throw new RuntimeException("Ya existe un hijo izquierdo");
        }
        this.left = new DynamicBinaryTree(value);
    }

    @Override
    public void addRight(int value) {
        if(this.right != null) {
            throw new RuntimeException("Ya existe un hijo derecho");
        }
        this.right = new DynamicBinaryTree(value);
    }

    @Override
    public BinaryTree getLeft() {
        return this.left;
    }

    @Override
    public BinaryTree getRight() {
        return this.right;
    }

    @Override
    public void deleteLeft() {
        this.left = null;
    }

    @Override
    public void deleteRight() {
        this.right = null;
    }
}
