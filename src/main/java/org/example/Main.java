package org.example;

import org.example.adt.Dictionary;
import org.example.adt.StaticDictionary;
import org.example.utils.DictionaryUtil;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new StaticDictionary();
        dictionary.add(1, 1);
        dictionary.add(2, 4);
        dictionary.add(3, 9);
        DictionaryUtil.print(dictionary);
        DictionaryUtil.print(dictionary);
    }

}