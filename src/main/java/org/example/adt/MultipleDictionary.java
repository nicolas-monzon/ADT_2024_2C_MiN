package org.example.adt;

import java.util.List;

public interface MultipleDictionary {

    void add(int key, int value);
    void remove(int key, int value);
    List<Integer> get(int key);
    Set getKeys();

}
