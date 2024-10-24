package org.example.adt;

public class DynamicSearchBinaryTree implements SearchBinaryTree {

    private BinaryTree binaryTree;

    public DynamicSearchBinaryTree(int root) {
        this.binaryTree = new DynamicBinaryTree(root);
    }

    private DynamicSearchBinaryTree(BinaryTree binaryTree) {
        this.binaryTree = binaryTree;
    }

    @Override
    public int getRoot() {
        return this.binaryTree.getRoot();
    }

    @Override
    public void add(int value) {
        if(this.binaryTree.getRoot() == value) {
            throw new RuntimeException("No se puede agregar un elemento que ya existe a un SBT");
        }
        if(this.binaryTree.getRoot() > value) {
            if(this.binaryTree.getLeft() == null) {
                this.binaryTree.addLeft(value);
            } else {
                this.getLeft().add(value);
            }
        } else {
            if(this.binaryTree.getRight() == null) {
                this.binaryTree.addRight(value);
            } else {
                this.getRight().add(value);
            }
        }
    }

    @Override
    public SearchBinaryTree getLeft() {
        return new DynamicSearchBinaryTree(this.binaryTree.getLeft());
    }

    @Override
    public SearchBinaryTree getRight() {
        return new DynamicSearchBinaryTree(this.binaryTree.getRight());
    }

    @Override
    public void deleteLeft() {
        this.binaryTree.deleteLeft();
    }

    @Override
    public void deleteRight() {
        this.binaryTree.deleteRight();
    }
}
