package org.example.adt;

import com.sun.jdi.Value;
import org.example.adt.nodes.KeyNode;
import org.example.adt.nodes.ValueNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DynamicMultipleDictionary implements MultipleDictionary {

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
               ValueNode currentValue = current.getValueNode();
               while(currentValue.getNext() != null) {
                   currentValue = currentValue.getNext();
               }
               currentValue.setNext(new ValueNode(value, null));
               return;
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
                if(this.first.getValueNode().getNext() == null) {
                    if(this.first.getValueNode().getValue() == value) {
                        this.first = null;
                        return;
                    }
                    throw new RuntimeException("No existe par clave-valor. La clave sin embargo, existe.");
                }

                ValueNode previousValue = this.first.getValueNode();
                ValueNode currentValue = this.first.getValueNode().getNext();
                while(currentValue != null) {
                    if(currentValue.getValue() == value) {
                        previousValue.setNext(currentValue.getNext());
                        return;
                    }
                    previousValue = currentValue;
                    currentValue = currentValue.getNext();
                }

                throw new RuntimeException("No existe par clave-valor. La clave sin embargo, existe y es única.");
            }
            return;
        }

        KeyNode previous = this.first;
        KeyNode current = this.first.getNext();
        while(current != null) {
            if(current.getKey() == key) {
                if(current.getValueNode().getNext() == null) {
                    if(current.getValueNode().getValue() == value) {
                        previous.setNext(current.getNext());
                        return;
                    }
                    throw new RuntimeException("No existe par clave-valor. La clave sin embargo, existe.");
                }

                ValueNode previousValue = current.getValueNode();
                ValueNode currentValue = current.getValueNode().getNext();
                while(currentValue != null) {
                    if(currentValue.getValue() == value) {
                        previousValue.setNext(currentValue.getNext());
                        return;
                    }
                    previousValue = currentValue;
                    currentValue = currentValue.getNext();
                }

                throw new RuntimeException("No existe par clave-valor. La clave sin embargo, existe y es única.");

            }
            previous = current;
            current = current.getNext();
        }

        throw new RuntimeException("No existe el par clave-valor.");
    }

    @Override
    public List<Integer> get(int key) {
        if(this.first == null) {
            throw new RuntimeException("No se puede obtener el valor de un diccionario vacio");
        }
        KeyNode current = this.first;
        while(current != null) {
            if(current.getKey() == key) {
                List<Integer> result = new LinkedList<>();
                ValueNode currentValue = current.getValueNode();
                while(currentValue != null) {
                    result.add(currentValue.getValue());
                    currentValue = currentValue.getNext();
                }
                return result;
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
