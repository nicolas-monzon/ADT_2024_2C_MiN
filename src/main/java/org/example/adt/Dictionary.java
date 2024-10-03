package org.example.adt;

public interface Dictionary {

    void add(int key, int value);
    void remove(int key, int value);

    /**
     * Estrategia: Recorro el arreglo en la primera columna, y cuando encuentre la clave devuelvo el valor de la otra columna
     * Precondición: El diccionario no está vacío
     * Postcondición: Devuelve el valor asociado a la clave si existe
     * @param key la clave de la que se quiere obtener el valor
     * @return la clave asociada al valor
     */
    int get(int key);
    Set getKeys();

}
