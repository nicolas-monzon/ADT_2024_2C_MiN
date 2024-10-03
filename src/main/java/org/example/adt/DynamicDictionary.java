package org.example.adt;

import org.example.adt.nodes.KeyNode;
import org.example.adt.nodes.ValueNode;

public class DynamicDictionary implements Dictionary {

    private KeyNode first;

    @Override
    public void add(int key, int value) {
        if(this.first == null) {
            this.first = new KeyNode(key, new ValueNode(value, null), null);
            return;
        }

        KeyNode current = this.first;
        while(current.getNext() != null) {
            if(current.getKey() == key) {
                if(current.getValueNode().getValue() == value) {
                    return;
                }
                throw new RuntimeException("Ya existe una par clave-valor diferente");
            }
            current = current.getNext();
        }

        current.setNext(new KeyNode(key, new ValueNode(value, null), null));
    }

    @Override
    public void remove(int key, int value) {
        if(this.first == null) {
            throw new RuntimeException("No se puede eliminar un par de un diccionario vacío");
        }

        if(this.first.getNext() == null) {
            if(this.first.getKey() == key) {
                if(this.first.getValueNode().getValue() == value) {
                    this.first = null;
                }
                throw new RuntimeException("No existe par clave-valor. La clave sin embargo, existe y es única.");
            }
            return;
        }

        KeyNode previous = this.first;
        KeyNode current = this.first.getNext();
        while(current.getNext() != null) {
            if(current.getKey() == key) {
                if(current.getValueNode().getValue() == value) {
                    previous.setNext(current.getNext());
                }
                throw new RuntimeException("No existe par clave-valor. La clave sin embargo, existe.");
            }
            previous = current;
            current = current.getNext();
        }

        if(current.getKey() == key) {
            if(current.getValueNode().getValue() == value) {
                previous.setNext(current.getNext());
            }
            throw new RuntimeException("No existe par clave-valor. La clave sin embargo, existe.");
        }

        throw new RuntimeException("No existe el par clave-valor.");
    }

    @Override
    public int get(int key) {
        if(this.first == null) {
            throw new RuntimeException("No se puede obtener el valor de un diccionario vacio");
        }
        KeyNode current = this.first;
        while(current != null) {
            if(current.getKey() == key) {
                return current.getValueNode().getValue();
            }
            current = current.getNext();
        }

        throw new RuntimeException("No se puede obtener el valor de una clave que no existe");
    }

    @Override
    public Set getKeys() {
        Set result = new DynamicSet();
        if(this.first == null) {
            return result;
        }

        KeyNode current = this.first;
        while(current != null) {
            result.add(current.getKey());
            current = current.getNext();
        }

        return result;
    }
}
