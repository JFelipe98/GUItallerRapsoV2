package com.example.guitallerRepasov2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class ProductoController extends ActionEvent {
    public TableColumn columna_Pais;
    public TableColumn columna_Peso;
    public TableColumn columna_Temperatura;
    public TableColumn columna_FechaV;
    public TableColumn columna_tipoProducto;
    public TableColumn columna_Stock;
    public TableColumn columna_ValorUnit;
    public TableColumn columna_Descripcion;
    public TableColumn columna_Nombre;
    public TableColumn columna_Codigo;
    public Button btn_VolverP;
    public Button btn_Eliminar;
    public Button btn_Actualizar;
    public Button btn_Registrar;
    public TextField tF_Temperatura_Peso;
    public TextField tF_CodigoSanit;
    public DatePicker dP_FechaV;
    public TextField tF_Stock;
    public TextField tF_ValorUnit;
    public TextField tF_Descripcion;
    public TextField tF_NombreP;
    public TextField tF_Producto;
    public ComboBox comboBox_tipoProducto;

    public ObservableList<String> tipoProdcuto = FXCollections.observableArrayList("--SELECCIONE--", "Perecederos","Refrigerados","Envasados");
    public  ObservableList<String> paisOrigen = FXCollections.observableArrayList("--SELECCIONE--","Col","Arg","Chil","Ecu","Per");
    public ComboBox comboBox_PaisOrigen;
    public Label lbl_PaisOrigen;
    public Label lbl_Temp_Peso;
    public Label lbl_FechaV;

    public void initialize() {
        comboBox_tipoProducto.setItems(tipoProdcuto);
        comboBox_PaisOrigen.setItems(paisOrigen);
        comboBox_tipoProducto.setOnAction(event -> {
            Object seleccion = comboBox_tipoProducto.getSelectionModel().getSelectedItem();
            if ("Perecederos".equals(seleccion)) {
                lbl_FechaV.setText("Fecha de Vencimiento");
                lbl_FechaV.setVisible(true);
                dP_FechaV.setVisible(true);
                tF_CodigoSanit.setVisible(false);
                lbl_Temp_Peso.setVisible(false);
                tF_Temperatura_Peso.setVisible(false);
                lbl_PaisOrigen.setVisible(false);
                comboBox_PaisOrigen.setVisible(false);
            } else if ("Refrigerados".equals(seleccion)) {
                lbl_FechaV.setText("Codigo sanitario");
                lbl_FechaV.setVisible(true);
                dP_FechaV.setVisible(false);
                tF_CodigoSanit.setVisible(true);
                lbl_Temp_Peso.setText("Temperatura");
                lbl_Temp_Peso.setVisible(true);
                tF_Temperatura_Peso.setVisible(true);
                lbl_PaisOrigen.setVisible(false);
                comboBox_PaisOrigen.setVisible(false);
            } else if ("Envasados".equals(seleccion)) {
                lbl_FechaV.setText("Fecha Envasado");
                lbl_FechaV.setVisible(true);
                dP_FechaV.setVisible(true);
                lbl_Temp_Peso.setText("Peso envase");
                lbl_Temp_Peso.setVisible(true);
                tF_Temperatura_Peso.setVisible(true);
                lbl_PaisOrigen.setVisible(true);
                comboBox_PaisOrigen.setVisible(true);

            } else {
                lbl_FechaV.setVisible(false);
                dP_FechaV.setVisible(false);
                lbl_Temp_Peso.setVisible(false);
                tF_Temperatura_Peso.setVisible(false);
                lbl_PaisOrigen.setVisible(false);
                comboBox_PaisOrigen.setVisible(false);

            }

        });


    }

    public void volver() {
        Stage stage = (Stage) this.btn_VolverP.getScene().getWindow();
        stage.close();


    }
}
