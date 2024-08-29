package org.example;

import org.example.adt.StaticStack;
import org.example.adt.Stack;
import org.example.utils.StackUtil;

public class Main {
    public static void main(String[] args) {
        Stack normalStack = new StaticStack();
        normalStack.add(0);
        normalStack.add(1);
        normalStack.add(2);
        normalStack.add(3);

        StackUtil.sum(normalStack);
        StackUtil.sum(normalStack);
    }

}