package org.example;

import org.example.clazz.Persona;
import org.example.functions.Basic;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.nombre = "Claudio";
        persona.dni = 40000000;
        Persona persona2 = new Persona();
        persona2.nombre = "Jose";
        persona2.dni = 40000001;
        persona = persona2;
        persona.nombre = "Mariano";
        System.out.println(persona2.nombre);
        System.out.println(persona.nombre);
    }

    public static Persona copy(Persona persona) {
        Persona copy = new Persona();
        copy.nombre = persona.nombre;
        copy.apellido = persona.apellido;
        copy.dni = persona.dni;
        return copy;
    }



}