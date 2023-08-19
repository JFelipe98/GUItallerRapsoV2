package com.example.guitallerRepasov2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ClienteController extends ActionEvent {
    public Button btn_Volver;
    public Label label_Email;
    public Label label_FechaNacimiento;
    public DatePicker dP_Fecha;
    public TextField tF_Email;
    ObservableList<String> tipoCliente = FXCollections.observableArrayList("Natural","Juridico");
    @FXML
    public AnchorPane registroClientes;
    public Label label_Nombre;
    public Label label_Telefono;
    public Label label_Apellido;
    public Label label_RegistroClientes;
    public Label label_Identificacion;
    public Label label_Direccion;
    public  TextField tF_Nombre;
    public TextField tF_Apellido;
    public TextField tF_Telefono;
    public TextField tF_Identificacion;
    public TextField tF_Direccion;
    public Button btn_Registrar;



    public  ComboBox<String> comboBox_TipoCliente = new ComboBox<>(tipoCliente);




    public Button btn_Leer;
    public Button btn_Actualizar;
    public Button btn_Eliminar;

    public  void initialize() {
        comboBox_TipoCliente.setItems(tipoCliente);
        comboBox_TipoCliente.setOnAction( event -> {
            String seleccion = comboBox_TipoCliente.getSelectionModel().getSelectedItem();
            if ("Natural".equals(seleccion)){
                label_Email.setVisible(true);
                tF_Email.setVisible(true);
                label_FechaNacimiento.setVisible(true);
                dP_Fecha.setVisible(true);
            }
            else{
                label_Email.setVisible(false);
                tF_Email.setVisible(false);
                label_FechaNacimiento.setVisible(false);
                dP_Fecha.setVisible(false);

            }
        });



    }

    public void guardarNombre(){

        String nombre = tF_Nombre.getText();
        System.out.println(nombre);
        tF_Nombre.clear();




    }




    public void volver() throws IOException {
        Stage stage = (Stage) this.btn_Volver.getScene().getWindow();
        stage.close();


    }

}