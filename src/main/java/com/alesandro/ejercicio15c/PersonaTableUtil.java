package com.alesandro.ejercicio15c;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import com.alesandro.model.Persona;

/**
 * Clase con utilidades de JavaFX para personas
 */
public class PersonaTableUtil {
    /**
     * Función que obtiene el nombre de la persona de la tabla
     *
     * @return nombre de la persona
     */
    public static TableColumn<Persona, String> getNombreColumn() {
        TableColumn<Persona, String> colNombre = new TableColumn<>("NOMBRE");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        return colNombre;
    }

    /**
     * Función que obtiene los apellidos de la persona de la tabla
     *
     * @return apellidos de la persona
     */
    public static TableColumn<Persona, String> getApellidosColumn() {
        TableColumn<Persona, String> colNombre = new TableColumn<>("APELLIDOS");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        return colNombre;
    }

    /**
     * Función que obtiene la edad de la persona de la tabla
     *
     * @return edad de la persona
     */
    public static TableColumn<Persona, Integer> getEdadColumn() {
        TableColumn<Persona, Integer> colEdad = new TableColumn<>("EDAD");
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        return colEdad;
    }

}
