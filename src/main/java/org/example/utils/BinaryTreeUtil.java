package org.example.utils;

import org.example.adt.BinaryTree;

public class BinaryTreeUtil {
    public static void print(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return;
        }
        System.out.println(binaryTree.getRoot());
        print(binaryTree.getLeft());
        print(binaryTree.getRight());
    }

    public static int total(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }
        int left = total(binaryTree.getLeft());
        int root = binaryTree.getRoot();
        int right = total(binaryTree.getRight());
        return left + right + root;
    }
    
    public static boolean isComplete(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return true;
        }
        if(binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            return true;
        }
        if(binaryTree.getLeft() != null && binaryTree.getRight() != null) {
            return isComplete(binaryTree.getLeft()) && isComplete(binaryTree.getRight());
        }
        return false;
    }
}
