package org.example.utils;

import org.example.adt.Dictionary;
import org.example.adt.Set;
import org.example.adt.StaticDictionary;
import org.example.adt.StaticSet;

public class DictionaryUtil {

    // ToDo 2: Hacer el método copy

    public static void print(Dictionary dictionary) {
        Set keys = dictionary.getKeys();
        while(!keys.isEmpty()) {
            int key = keys.choose();
            System.out.println(key + "\t" + dictionary.get(key));
            keys.remove(key);
        }
    }

    // ToDo 1: Hacer el método put. Este método reemplaza el valor para una clave

    // ToDo 3: intersectionV2 que utiliza los métodos in, e intersection de SetUtil
    public static Dictionary intersectionV1(Dictionary d1, Dictionary d2) {
        Dictionary intersection = new StaticDictionary();
        Set d1Keys = d1.getKeys();
        while(!d1Keys.isEmpty()) {
            int key = d1Keys.choose();
            Set d2Keys = d2.getKeys();
            while(!d2Keys.isEmpty()) {
                int key2 = d2Keys.choose();
                if(key == key2) {
                    if(d1.get(key) == d2.get(key2)) {
                        intersection.add(key, d1.get(key));
                    }
                    // Idea: usar un break acá
                }
                d2Keys.remove(key2);
            }
            d1Keys.remove(key);
        }
        return intersection;
    }

    // ToDo 4: Hacer la union, diferencia y diferencia simétrica de diccionarios
    // ToDo 5: Comparar las complejidades de intersectionV1 e intersectionV2

    // Supongamos que d1 representa una función f, entonces queremos dominio e imagen
    // Supongamos que d2 representa una función g, entonces queremos f o g
    // Verificar si f es constante

    public static Set getDomain(Dictionary f) {
        return f.getKeys();
    }

    public static Set getImage(Dictionary f) {
        Set keys = f.getKeys();
        Set results = new StaticSet();
        while(!keys.isEmpty()) {
            int key = keys.choose();
            results.add(f.get(key));
            keys.remove(key);
        }
        return results;
    }

    // f(g(k))
    public static Dictionary composition(Dictionary f, Dictionary g) {
        Set gImage = getImage(g);
        Set fDomain = getDomain(f);
        if(!SetUtil.subseteq(gImage, fDomain)) {
            throw new RuntimeException("No se puede componer f con g");
        }
        Dictionary result = new StaticDictionary();

        Set gDomain = getDomain(g);
        while(!gDomain.isEmpty()) {
            int key = gDomain.choose();
            int gValue = g.get(key);
            int fValue = f.get(gValue);
            result.add(key, fValue);
            gDomain.remove(key);
        }

        return result;
    }

    public static boolean isConstant(Dictionary f) {
        if(f.getKeys().isEmpty()) {
            return true;
        }
        int candidate = f.get(f.getKeys().choose());
        Set keys = f.getKeys();
        while(!keys.isEmpty()) {
            int key = keys.choose();
            if(f.get(key) != candidate) {
                return false;
            }
            keys.remove(key);
        }
        return true;
    }

    // aRb entonces quiero ver si mi diccionario es simétrico.
    // aRb -> existe bRa
    // pares: 2R6 -> 6R2
    // si existe (k, v) entonces quiero que exista (v, k)
    public static boolean isSymmetric(Dictionary relation) {
        Set keys = relation.getKeys();
        while(!keys.isEmpty()) {
            int key = keys.choose();
            int value = relation.get(key);

            Set keysAux = relation.getKeys();
            if(!SetUtil.in(value, keysAux)) {
                return false;
            }

            int value2 = relation.get(value);
            if(value2 != key) {
               return false;
            }

            keys.remove(key);
        }
        return true;
    }



}
