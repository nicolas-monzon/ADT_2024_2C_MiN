package org.example;

import org.example.adt.BinaryTree;
import org.example.adt.DynamicBinaryTree;
import org.example.utils.BinaryTreeUtil;

// configuracion de mail y nombre de usuario, iniciar el proyecto

// Spring AI

// git commit -m ""
// git add .
// git status
// git stash
// git pull
// git push
// git checkout "feature/qos" -b

// git revert (un commit pusheado)

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new DynamicBinaryTree(5);
        binaryTree.addLeft(3);
        binaryTree.addRight(2);
        binaryTree.getRight().addLeft(1);
        binaryTree.getRight().addRight(1);
        binaryTree.getLeft().addLeft(2);
        binaryTree.getLeft().getLeft().addLeft(1);
        binaryTree.getLeft().getLeft().addRight(1);
        binaryTree.getLeft().addRight(1);
        BinaryTreeUtil.print(binaryTree);
    }

}