package org.example.utils;

import org.example.adt.*;

import java.util.List;

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

    // TODO falta usar copias
    public static MultipleDictionary union(MultipleDictionary m1, MultipleDictionary m2) {
        if(m1 == null || m2 == null) {
            return null;
        }
        if(m1 == null) {
            return m2;
        }
        if(m2 == null) {
            return m1;
        }
        Set m1Keys = m1.getKeys();
        if(m1Keys.isEmpty()) {
            return m2;
        }
        Set m2Keys = m2.getKeys();
        if(m2Keys.isEmpty()) {
            return m1;
        }

        while(!m2Keys.isEmpty()) {
            int key = m2Keys.choose();
            List<Integer> values = m2.get(key);
            for (Integer value : values) {
                m1.add(key, value);
            }
            m2Keys.remove(key);
        }
        return m1;
    }

    public static Dictionary union(Dictionary d1, Dictionary d2) {
        if(d1 == null || d2 == null) {
            return null;
        }
        if(d1 == null) {
            return d2;
        }
        if(d2 == null) {
            return d1;
        }
        Set d1Keys = d1.getKeys();
        if(d1Keys.isEmpty()) {
            return d2;
        }
        Set d2Keys = d2.getKeys();
        if(d2Keys.isEmpty()) {
            return d1;
        }

        Set intersection = SetUtil.intersection(d1Keys, d2Keys);
        if(!intersection.isEmpty()) {
            while(!intersection.isEmpty()) {
                int key = intersection.choose();
                if(d1.get(key) != d2.get(key)) {
                    throw new RuntimeException("No se pueden unir los diccionarios porque existe al menos una clave con un valor asociado distinto");
                }
                intersection.remove(key);
            }
        }

        Set d1KeysAux = d1.getKeys();
        while(!d2Keys.isEmpty()) {
            int key = d2Keys.choose();
            if(SetUtil.in(key, d1KeysAux)) {
                continue;
            }
            d1KeysAux.add(key);
            d1.add(key, d2.get(key));
            d2Keys.remove(key);
        }
        return d1;
    }

    public static Dictionary diferencia(Dictionary d1, Dictionary d2) {
        Dictionary diferencia = new StaticDictionary();
        d2 = intersectionV1(d1, d2);
        Set d1keys = d1.getKeys();
        while (!d1keys.isEmpty()) {
            int key = d1keys.choose();
            if (d2.get(key) != d1.get(key)) {
                diferencia.add(key, d1.get(key));
            }
            d1keys.remove(key);
        }
        return diferencia;
    }

    public static Dictionary diferenciaSimetrica(Dictionary d1, Dictionary d2) {
        return diferencia(union(d1, d2), intersectionV1(d1, d2));
    }

}
