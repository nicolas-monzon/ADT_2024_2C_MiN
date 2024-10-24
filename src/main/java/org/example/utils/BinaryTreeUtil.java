package org.example.utils;

import org.example.adt.*;

public class BinaryTreeUtil {
    public static void printPreOrder(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return;
        }
        System.out.println(binaryTree.getRoot());
        printPreOrder(binaryTree.getLeft());
        printPreOrder(binaryTree.getRight());
    }

    public static void printInOrder(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return;
        }
        printInOrder(binaryTree.getLeft());
        System.out.println(binaryTree.getRoot());
        printInOrder(binaryTree.getRight());
    }

    public static void printPostOrder(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return;
        }
        printPostOrder(binaryTree.getLeft());
        printPostOrder(binaryTree.getRight());
        System.out.println(binaryTree.getRoot());
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

    public static boolean isSBT(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return true;
        }
        if(binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            return true;
        }
        return isSBTAux(binaryTree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isSBTAux(BinaryTree binaryTree, int min, int max) {
        if(binaryTree == null) {
            return true;
        }
        if(binaryTree.getRoot() <= min || binaryTree.getRoot() >= max) {
            return false;
        }
        if(binaryTree.getLeft() == null && binaryTree.getRight() == null) {
            return true;
        }
        if(binaryTree.getLeft() != null && binaryTree.getLeft().getRoot() >= binaryTree.getRoot()) {
            return false;
        }
        if(binaryTree.getRight() != null && binaryTree.getRight().getRoot() <= binaryTree.getRoot()) {
            return false;
        }
        return isSBTAux(binaryTree.getLeft(), min, Math.min(max, binaryTree.getRoot())) &&
                isSBTAux(binaryTree.getRight(), Math.max(min, binaryTree.getRoot()), max);
    }

    public static void sort(Stack stack) {
        if(stack == null || stack.isEmpty()) {
            return;
        }
        SearchBinaryTree sbt = new DynamicSearchBinaryTree(stack.getTop());
        stack.remove();
        while(!stack.isEmpty()) {
            sbt.add(stack.getTop());
            stack.remove();
        }
        fillInOrder(sbt, stack);
    }

    private static void fillInOrder(SearchBinaryTree binaryTree, Stack stack) {
        if(binaryTree == null) {
            return;
        }
        fillInOrder(binaryTree.getLeft(), stack);
        stack.add(binaryTree.getRoot());
        fillInOrder(binaryTree.getRight(), stack);
    }

    public static void printByLevel(BinaryTree binaryTree) {
        int height = height(binaryTree);
        for(int i = 0; i < height; i++) {
            printByLevel(binaryTree, i);
        }
    }

    public static int height(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return 0;
        }
        return 1 + Math.max(height(binaryTree.getLeft()), height(binaryTree.getRight()));
    }

    public static void printByLevel(BinaryTree binaryTree, int level) {
        if(binaryTree == null) {
            return;
        }
        if(level == 0) {
            System.out.println(binaryTree.getRoot());
        }
        printByLevel(binaryTree.getLeft(), level - 1);
        printByLevel(binaryTree.getRight(), level - 1);
    }

    public static void printByLevelV2(BinaryTree binaryTree) {
        if(binaryTree == null) {
            return;
        }
        QueueOfBT queueOfBT = new DynamicQueueOfBT();
        queueOfBT.add(binaryTree);

        while(!queueOfBT.isEmpty()) {
            BinaryTree binaryTree1 = queueOfBT.getFirst();
            if(binaryTree1.getLeft() != null) {
                queueOfBT.add(binaryTree1.getLeft());
            }
            if(binaryTree1.getRight() != null) {
                queueOfBT.add(binaryTree1.getRight());
            }

            System.out.println(binaryTree.getRoot());

            queueOfBT.remove();
        }
    }
}
