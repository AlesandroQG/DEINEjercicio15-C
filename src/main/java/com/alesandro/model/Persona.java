package com.alesandro.model;

import java.util.Objects;

/**
 * Clase Persona
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;

    /**
     * Constructor con parámetros de persona
     *
     * @param nombre nombre de persona
     * @param apellidos apellidos de persona
     * @param edad edad de persona
     */
    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    /**
     * ToString de objeto persona
     *
     * @return descripción de persona
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }

    /**
     * Getter para el nombre de persona
     *
     * @return nombre de persona
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter para el nombre de persona
     *
     * @param nombre nuevo nombre de persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter para los apellidos de persona
     *
     * @return apellidos de persona
     */
    public String getApellidos() {
        return this.apellidos;
    }

    /**
     * Setter para los apellidos de persona
     *
     * @param apellidos nuevos apellidos de persona
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Getter para la edad de persona
     *
     * @return edad de persona
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Setter para el edad de persona
     *
     * @param edad nueva edad de persona
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre) && Objects.equals(apellidos, persona.apellidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, edad);
    }
}
