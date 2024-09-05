package org.example;

import org.example.adt.PriorityQueue;
import org.example.adt.StaticPriorityQueue;
import org.example.adt.StaticStack;
import org.example.adt.Stack;
import org.example.utils.StackUtil;

public class Main {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new StaticPriorityQueue();
        priorityQueue.add(1, 2);
        priorityQueue.add(3, 4);
        priorityQueue.remove();
    }

}