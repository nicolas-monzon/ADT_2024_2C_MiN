package org.example.utils;

import org.example.adt.StaticStack;
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
        Stack aux = new StaticStack();
        Stack aux2 = new StaticStack();

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
        Stack aux = new StaticStack();
        Stack aux2 = new StaticStack();

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
        Stack candidate = new StaticStack();
        Stack aux = new StaticStack();
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
        Stack copy = copy(stack);
        return esCapicuaAux(copy);
    }

    private static boolean esCapicuaAux(Stack stack) {
        Stack aux = copy(stack);
        Stack aux2 = new StaticStack();

        while(!aux.isEmpty()) {
            aux2.add(aux.getTop());
            aux.remove();
        }

        if(!aux2.isEmpty()) {
            while (aux2.getTop() == stack.getTop()) {
                aux2.remove();
                stack.remove();
            }
        }

        return aux.isEmpty();
    }

    public static Stack revert(Stack stack) {
        Stack copy = copy2(stack);
        Stack reverse = new StaticStack();

        while(!copy.isEmpty()) {
            reverse.add(copy.getTop());
            copy.remove();
        }
        return reverse;
    }
}
