package org.example.functions;

import java.util.ArrayList;
import java.util.List;

public class Basic {

    public static void counter() {
        int i = 0;
        while(i < 15) {
            //
            i++;
        }

        for(int j = 0; j < 15; j++) {
            //
        }
    }

    public static void wrapper() {
        try {
            int a = Integer.parseInt("19aa");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void casting() {
        /*byte <= short <= int <= long
                int <= float
                float <= double
                long <= double*/
        int a = 1;
        int b = 2;

        double d = ((double) a) / b;

        int v = (int) Math.floor(2.1);

        for(char c = 'a'; c <= 'z'; c++) {

        }
    }

    public static boolean equals(double x, double y) {
        double epsilon = 0.000000001;
        return y < x + epsilon && y > x - epsilon;
    }

    public static void print() {
        String hello = "Hello";
        hello = hello.toLowerCase();
        System.out.println(hello);
    }

    public static void time() {
        long init = System.currentTimeMillis();
        String hello = "Hello";
        for(int i = 0; i < 30; i++) {
            hello += hello;
        }
        long end = System.currentTimeMillis();
        System.out.println("Tardó: " + (end - init));
    }

    public static void timeV2() {
        long init = System.currentTimeMillis();
        String hello = "Hello";
        for(int i = 0; i < 3000; i++) {
            hello += "Hello";
        }
        long end = System.currentTimeMillis();
        System.out.println("Tardó: " + (end - init));
    }

    public static void timeV3() {
        long init = System.currentTimeMillis();
        StringBuilder hello = new StringBuilder("Hello");
        for(int i = 0; i < 3000; i++) {
            hello.append("Hello");
        }
        long end = System.currentTimeMillis();
        System.out.println("Tardó: " + (end - init));
    }

    public static int identity(int a) {
        return a;
    }

    public static int maxStrict(int a, int b, int c) {
        if(a > b && a > c) {
            return a;
        }
        if(b > a && b > c) {
            return b;
        }
        if(c > a && c > b) {
            return c;
        }
        return -1;
    }

    public static int maxStrictV2(int a, int b, int c) {
        return a > b && a > c ? a : (
                b > a && b > c ? b : (
                        c > a && c > b ? c : -1
                )
        );
    }

    public static void f(boolean p, boolean q) {
        if(p) {
            System.out.println("Hola");
        } else {
            if(q && p) {
                System.out.println("Hola3");
            }
            System.out.println("Hola");
        }
    }

    public static void fV2(boolean p, boolean q) {
        System.out.println("Hola");
        // !p && p == false
        // !p || p == true
        // true || p == true
        // false && p == false
        // false || p == p
        // true && p == p
        // ley de morgan
    }

}
