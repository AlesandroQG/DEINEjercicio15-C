package com.alesandro.ejercicio15c;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import static javafx.scene.control.TableView.TableViewSelectionModel;

import javafx.scene.control.cell.PropertyValueFactory;
import com.alesandro.model.Persona;

import java.util.Arrays;

/**
 * Clase que controla los eventos de la ventana
 */
public class PersonasController {
    @FXML // fx:id="txtNombre"
    private TextField txtNombre; // Value injected by FXMLLoader

    @FXML // fx:id="txtApellidos"
    private TextField txtApellidos; // Value injected by FXMLLoader

    @FXML // fx:id="txtEdad"
    private TextField txtEdad; // Value injected by FXMLLoader

    @FXML // fx:id="tabla"
    private TableView<Persona> tabla; // Value injected by FXMLLoader

    @FXML // fx:id="colNombre"
    private TableColumn<Persona, String> colNombre; // Value injected by FXMLLoader

    @FXML // fx:id="colApellidos"
    private TableColumn<Persona, String> colApellidos; // Value injected by FXMLLoader

    @FXML // fx:id="colEdad"
    private TableColumn<Persona, Integer> colEdad; // Value injected by FXMLLoader

    /**
     * Función que se ejecuta cuando se inicia la ventana
     */
    public void initialize() {
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        colEdad.setCellValueFactory(new PropertyValueFactory("edad"));

        tabla.getColumns().setAll(colNombre, colApellidos, colEdad);
    }

    /**
     * Función que procesa los datos cuándo se pulsa el botón "Agregar Persona"
     *
     * @param event
     */
    @FXML
    void agregar(ActionEvent event) {
        String error = "";
        if (txtNombre.getText().isEmpty()) {
            error += "El campo nombre es obligatorio";
        }
        if (txtApellidos.getText().isEmpty()) {
            if (!error.isEmpty()) {
                error += "\n";
            }
            error += "El campo apellidos es obligatorio";
        }
        if (txtEdad.getText().isEmpty()) {
            if (!error.isEmpty()) {
                error += "\n";
            }
            error += "El campo edad es obligatorio";
        } else {
            try {
                int edad = Integer.parseInt(txtEdad.getText());
            } catch (NumberFormatException e) {
                if (!error.isEmpty()) {
                    error += "\n";
                }
                error += "El campo edad tiene que ser numérico";
            }
        }
        if (!error.isEmpty()) {
            alerta(error);
        } else {
            Persona p = new Persona(txtNombre.getText(), txtApellidos.getText(), Integer.parseInt(txtEdad.getText()));
            ObservableList<Persona> lst = tabla.getItems();
            if (lst.contains(p)) {
                alerta("Esa persona ya existe");
            } else {
                tabla.getItems().add(p);
                confirmacion("Persona añadida correctamente");
                vaciarFormulario();
            }
        }
    }

    /**
     * Función que modifica los datos de una persona cuándo se pulsa el botón "Modificar"
     *
     * @param event
     */
    @FXML
    public void modificar(ActionEvent event) {
        TableViewSelectionModel<Persona> tsm = tabla.getSelectionModel();
        if (tsm.isEmpty()) {
            alerta("Tienes que seleccionar una fila");
        } else {

        }
    }

    /**
     * Función que elimina una persona cuándo se pulsa el botón "Elimina"
     *
     * @param event
     */
    @FXML
    public void eliminar(ActionEvent event) {
        TableViewSelectionModel<Persona> tsm = tabla.getSelectionModel();
        if (tsm.isEmpty()) {
            alerta("Tienes que seleccionar una fila");
        } else {
            ObservableList<Integer> lst = tsm.getSelectedIndices();
            Integer[] indices = new Integer[lst.size()];
            indices = lst.toArray(indices);
            Arrays.sort(indices);
            for (int i = indices.length - 1; i >= 0; i--) {
                tsm.clearSelection(indices[i].intValue());
                tabla.getItems().remove(indices[i].intValue());
            }
            confirmacion("Personas eliminadas correctamente");
            vaciarFormulario();
        }
    }

    /**
     * Función que muestra un mensaje de alerta al usuario
     *
     * @param texto contenido de la alerta
     */
    public void alerta(String texto) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("ERROR");
        alerta.setContentText(texto);
        alerta.showAndWait();
    }

    /**
     * Función que muestra un mensaje de confirmación al usuario
     *
     * @param texto contenido del mensaje
     */
    public void confirmacion(String texto) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Info");
        alerta.setContentText(texto);
        alerta.showAndWait();
    }

    public void vaciarFormulario() {
        tabla.getSelectionModel().clearSelection();
        txtNombre.setText(null);
        txtApellidos.setText(null);
        txtEdad.setText(null);
    }

}
