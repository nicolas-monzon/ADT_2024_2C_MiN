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

    public static Stack copy(Stack stack) { // C + C + N + N + N + C = 3N + C = N
        Stack aux = new StaticStack(); // C
        Stack aux2 = new StaticStack(); // C

        /* Si tengo dos removes dentro del ciclo
        N = 1 IT = 1
        N = 2 IT = 1
        ...
        N = M IT = M / 2
         */

        // C + N*C = N
        while(!stack.isEmpty()) { // C
            aux.add(stack.getTop()); // C + C = C
            aux2.add(stack.getTop()); // C
            stack.remove(); // C
        }

        // C + N*C = N
        while(!aux.isEmpty()) { // C
            stack.add(aux.getTop()); // C
            aux.remove(); // C
        }

        // N
        while(!aux2.isEmpty()) {
            aux.add(aux2.getTop());
            aux2.remove();
        }

        return aux; // C + C = C
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

    // O(N) + O(C) = O(N + C) = O(N)
    // O(f) + O(g) = O(f + g) = O(max(f, g))
    public static Stack notRepeatedElements(Stack stack) { // O(N) + O(C) + O(C) + O(N^2) + O(N) = O(N^2)
        Stack copy = copy(stack); // N + C + C = N
        Stack candidate = new StaticStack(); // C
        Stack aux = new StaticStack(); // C

        // C + N*(C + C + N + N) = C + N*(2N + C) = C + N*N = C + N^2 = N^2
        while(!copy.isEmpty()) {
            candidate.add(copy.getTop()); // C
            copy.remove(); // C

            // C + N*(C + C) = C + N*C = N
            while(!copy.isEmpty()) {
                // C + max(C, 0) = C + C = C
                if(copy.getTop() != candidate.getTop()) {
                    aux.add(copy.getTop());
                }
                copy.remove(); // C
            }

            // C + N*(C + C) = N
            while(!aux.isEmpty()) {
                copy.add(aux.getTop()); // C
                aux.remove(); // C
            }
        }

        return revert(copy); // N
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

    public static Stack revert(Stack stack) { // N + C + N + C = 2N + C = N
        Stack copy = copy2(stack); // N + C = N
        Stack reverse = new StaticStack(); // C

        // C + N * C = N
        while(!copy.isEmpty()) {
            reverse.add(copy.getTop());
            copy.remove();
        }
        return reverse; // C
    }
}
