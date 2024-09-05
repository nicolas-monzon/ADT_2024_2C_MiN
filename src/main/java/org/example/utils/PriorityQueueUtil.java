package org.example.utils;

import org.example.adt.*;

public class PriorityQueueUtil {

    public static PriorityQueue copy(PriorityQueue queue) {
        PriorityQueue aux = new StaticPriorityQueue();
        PriorityQueue copy = new StaticPriorityQueue();
        while(!queue.isEmpty()) {
            aux.add(queue.getFirst(), queue.getPriority());
            queue.remove();
        }

        while(!aux.isEmpty()) {
            copy.add(aux.getFirst(), aux.getPriority());
            queue.add(aux.getFirst(), aux.getPriority());
            aux.remove();
        }

        return copy;
    }

}
