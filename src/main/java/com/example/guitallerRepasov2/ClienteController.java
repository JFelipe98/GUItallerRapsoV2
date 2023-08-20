package com.example.guitallerRepasov2;

import Model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

public class ClienteController extends ActionEvent {




    public Button btn_Volver;
    public Label label_Email_Nit;
    public Label label_FechaNacimiento;
    public DatePicker dP_Fecha;
    public TextField tF_Email_Nit;
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
        // Inicializa listaCliente

        comboBox_TipoCliente.setItems(tipoCliente);
        comboBox_TipoCliente.setOnAction( event -> {
            String seleccion = comboBox_TipoCliente.getSelectionModel().getSelectedItem();
            if ("Natural".equals(seleccion)){
                label_Email_Nit.setText("Email");
                label_Email_Nit.setVisible(true);
                tF_Email_Nit.setVisible(true);
                label_FechaNacimiento.setVisible(true);
                dP_Fecha.setVisible(true);
            }
            else{
                label_Email_Nit.setText("NIT");
                label_Email_Nit.setVisible(true);
                tF_Email_Nit.setVisible(true);
                label_FechaNacimiento.setVisible(false);
                dP_Fecha.setVisible(false);

            }
        });


    }

    public void registrarCliente(){

        String nombre = tF_Nombre.getText();
        String apellido = tF_Apellido.getText();
        String identificacion = tF_Identificacion.getText();
        String telefono = tF_Telefono.getText();
        String direccion = tF_Direccion.getText();

        Cliente c1 = new Cliente(nombre,apellido,identificacion,telefono,direccion);
        MainApplication.registrarCliente(c1);

         tF_Nombre.clear();
        tF_Apellido.clear();
        tF_Identificacion.clear();
        tF_Telefono.clear();
        tF_Direccion.clear();
        label_Email_Nit.setVisible(false);
        tF_Email_Nit.setVisible(false);
        label_FechaNacimiento.setVisible(false);
        dP_Fecha.setVisible(false);




    }




    public void volver() throws IOException {
        Stage stage = (Stage) this.btn_Volver.getScene().getWindow();
        stage.close();


    }

}