package org.example.utils;

import org.example.adt.NormalStack;
import org.example.adt.Stack;

public class StackUtil {

    public static void print(Stack stack) {
        Stack copy = copy(stack);
        while(!copy.isEmpty()) {
            System.out.println(copy.getTop());
            copy.remove();
        }
    }

    public static void sum(Stack stack) {
        Stack copy = copy(stack);
        int sum = 0;
        while(!copy.isEmpty()) {
            sum += copy.getTop();
            copy.remove();
        }
        System.out.println(sum);
    }

    public static Stack copy(Stack stack) {
        Stack aux = new NormalStack();
        Stack aux2 = new NormalStack();

        while(!stack.isEmpty()) {
            aux.add(stack.getTop());
            aux2.add(stack.getTop());
            stack.remove();
        }

        while(!aux.isEmpty()) {
            stack.add(aux.getTop());
            aux.remove();
        }

        while(!aux2.isEmpty()) {
            aux.add(aux2.getTop());
            aux2.remove();
        }

        return aux;
    }

    public static Stack copy2(Stack stack) {
        Stack aux = new NormalStack();
        Stack aux2 = new NormalStack();

        while(!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }

        while(!aux.isEmpty()) {
            stack.add(aux.getTop());
            aux2.add(aux.getTop());
            aux.remove();
        }

        return aux2;
    }

    public static Stack notRepeatedElements(Stack stack) {
        Stack copy = copy(stack);
        Stack candidate = new NormalStack();
        Stack aux = new NormalStack();
        while(!copy.isEmpty()) {
            candidate.add(copy.getTop());
            copy.remove();
            while(!copy.isEmpty()) {
                if(copy.getTop() != candidate.getTop()) {
                    aux.add(copy.getTop());
                }
                copy.remove();
            }

            while(!aux.isEmpty()) {
                copy.add(aux.getTop());
                aux.remove();
            }
        }

        return revert(copy);
    }

    public static boolean esCapicua(Stack stack) {
        return false;
    }

    public static Stack revert(Stack stack) {
        return null;
    }

}
