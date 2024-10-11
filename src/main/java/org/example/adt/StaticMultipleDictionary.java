package org.example.adt;

import java.util.ArrayList;
import java.util.List;

public class StaticMultipleDictionary implements MultipleDictionary {

    private static final int MAX = 10000;

    private final int[][] values;
    private int count;

    // 0 -> key
    // 1 -> count'
    // [2 ... count + 2)

    public StaticMultipleDictionary() {
        this.values = new int[MAX][MAX];
        this.count = 0;
    }

    @Override
    public void add(int key, int value) {
        if(this.count == 0) {
            this.values[0][0] = key;
            this.values[0][1] = 1;
            this.values[0][2] = value;
            this.count++;
            return;
        }

        for(int i = 0; i < this.count; i++) {
            if(this.values[i][0] == key) {
                int column = this.values[i][1];
                if(column == MAX) {
                    throw new RuntimeException("No hay espacio disponible para un valor nuevo");
                }
                this.values[i][column] = value;
                this.values[i][1]++;
                return;
            }
        }

        if(this.count == MAX) {
            throw new RuntimeException("No hay espacio disponible para una clave nueva");
        }

        this.values[this.count][0] = key;
        this.values[this.count][1] = 1;
        this.values[this.count][2] = value;
        this.count++;
    }

    @Override
    public void remove(int key, int value) {
        if(this.count == 0) {
            throw new RuntimeException("No se puede eliminar un par de un diccionario vacío");
        }

        for(int i = 0; i < this.count; i++) {
            if(this.values[i][0] == key) {
                for(int j = 2; j < this.values[i][1]; j++) {
                    if(this.values[i][j] == value) {
                        for(int k = j; k < this.values[i][1] - 1; k++) {
                            this.values[i][k] = this.values[i][k + 1];
                        }
                        this.values[i][1]--;
                        if(this.values[i][1] == 0) {
                            this.values[i][0] = this.values[this.count-1][0];
                            this.values[i][1] = this.values[this.count-1][1];
                            this.count--;
                        }
                        return;
                    }
                }
                throw new RuntimeException("No existe par clave-valor. La clave sin embargo, existe.");
            }
        }

        throw new RuntimeException("No existe el par clave-valor.");
    }

    @Override
    public List<Integer> get(int key) {
        if(this.count == 0) {
            return new ArrayList<>();
        }
        for(int i = 0; i < count; i++) {
            if(this.values[i][0] == key) {
                List<Integer> result = new ArrayList<>();
                for(int j = 2; j < this.values[i][1]; j++) {
                    result.add(this.values[i][j]);
                }
                return result;
            }
        }
        return new ArrayList<>();
    }

    @Override
    public Set getKeys() {
        if(this.count == 0) {
            return new StaticSet();
        }
        Set result = new StaticSet();
        for(int i = 0; i < count; i++) {
            result.add(this.values[i][0]);
        }
        return result;
    }
}
