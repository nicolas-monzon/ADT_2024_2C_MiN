package org.example.utils;

import org.example.adt.*;

public class SetUtil {

    public static void print(Set set) {
        Set copy = copy(set);
        while(!copy.isEmpty()) {
            int element = copy.choose();
            System.out.println(element);
            copy.remove(element);
        }
    }

    public static Set copy(Set set) {
        Set aux = new StaticSet();
        Set aux2 = new StaticSet();
        while(!set.isEmpty()) {
            int element = set.choose();
            aux.add(element);
            aux2.add(element);
            set.remove(element);
        }

        while(!aux2.isEmpty()) {
            int element = aux2.choose();
            set.add(element);
            aux2.remove(element);
        }

        return aux;
    }

    public static boolean in(int element, Set set) {
        Set copy = copy(set);
        while(!copy.isEmpty()) {
            int value = copy.choose();
            if(value == element) {
                return true;
            }
            copy.remove(value);
        }
        return false;
    }

    public static Set union(Set set, Set set2) {
        Set copy = copy(set);
        Set copy2 = copy(set2);
        while(!copy2.isEmpty()) {
            int element = copy2.choose();
            copy.add(element);
            copy2.remove(element);
        }
        return copy;
    }

    public static Set intersection(Set set, Set set2) {
        Set copy1 = copy(set);
        Set aux = new StaticSet();
        while(!copy1.isEmpty()){
            int element = copy1.choose();
            if (in(element,set2)){
                aux.add(element);
            }
            copy1.remove(element);
        }
        return aux;
    }

    public static void deleteRepeatedElementsAndSort(Stack stack) {
        Set set = new StaticSet();
        while(!stack.isEmpty()) {
            set.add(stack.getTop());
            stack.remove();
        }

        PriorityQueue priorityQueue = new StaticPriorityQueue();
        while(!set.isEmpty()) {
            int element = set.choose();
            priorityQueue.add(element, element);
            set.remove(element);
        }

        while(!priorityQueue.isEmpty()) {
            stack.add(priorityQueue.getPriority());
            priorityQueue.remove();
        }
    }

    public static boolean subseteq(Set set, Set set2) {
        Set copy = copy(set);
        while(!copy.isEmpty()) {
            int element = copy.choose();
            if(!in(element,set2)){
                return false;
            }
            copy.remove(element);
        }
        return true;
    }

}
