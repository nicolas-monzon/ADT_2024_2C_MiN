package org.example.adt;

public class StaticDictionary implements Dictionary {

    private static final int MAX = 10000;

    private final int[][] values;
    private int count;

    public StaticDictionary() {
        this.values = new int[MAX][2];
        this.count = 0;
    }

    @Override
    public void add(int key, int value) {
        if(this.count == 0) {
            this.values[0][0] = key;
            this.values[0][1] = value;
            this.count++;
            return;
        }

        for(int i = 0; i < this.count; i++) {
            if(this.values[i][0] == key) {
                if(this.values[i][1] == value) {
                    return;
                }
                throw new RuntimeException("Ya existe una par clave-valor diferente");
            }
        }

        this.values[this.count][0] = key;
        this.values[this.count][1] = value;
        this.count++;
    }

    @Override
    public void remove(int key, int value) {
        if(this.count == 0) {
            throw new RuntimeException("No se puede eliminar un par de un diccionario vacío");
        }

        for(int i = 0; i < this.count; i++) {
            if(this.values[i][0] == key) {
                if(this.values[i][1] == value) {
                    this.values[i][0] = this.values[this.count-1][0];
                    this.values[i][1] = this.values[this.count-1][1];
                    this.count--;
                    return;
                }
                throw new RuntimeException("No existe par clave-valor. La clave sin embargo, existe.");
            }
        }

        throw new RuntimeException("No existe el par clave-valor.");
    }

    @Override
    public int get(int key) {
        if(this.count == 0) {
            throw new RuntimeException("No se puede obtener el valor de un diccionario vacio");
        }
        for(int i = 0; i < count; i++) {
            if(this.values[i][0] == key) {
                return this.values[i][1];
            }
        }
        throw new RuntimeException("No se puede obtener el valor de una clave que no existe");
    }

    // 1 2
    // 5 9
    // 3 -1

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
