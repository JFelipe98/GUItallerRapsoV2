package com.example.guitallerRepasov2;

import Model.Producto;
import Model.ProductoEnvasado;
import Model.ProductoPerecible;
import Model.ProductoRefrigerado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ProductoController extends ActionEvent {
    public TableColumn<Producto,String> columna_Pais;
    public TableColumn<Producto,Double> columna_Peso;
    public TableColumn<Producto,Double> columna_Temperatura;
    public TableColumn<Producto,String> columna_FechaV;
    public TableColumn<Producto,String> columna_tipoProducto;
    public TableColumn<Producto,Integer> columna_Stock;
    public TableColumn<Producto,Double> columna_ValorUnit;
    public TableColumn<Producto,String> columna_Descripcion;
    public TableColumn<Producto,String> columna_Nombre;
    public TableColumn<Producto,String> columna_Codigo;
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
    public ComboBox comboBox_tipoProducto;

    public ObservableList<String> tipoProdcuto = FXCollections.observableArrayList("--SELECCIONE--", "Perecederos","Refrigerados","Envasados");
    public  ObservableList<String> paisOrigen = FXCollections.observableArrayList("--SELECCIONE--","Col","Arg","Chil","Ecu","Per");
    public ComboBox comboBox_PaisOrigen;
    public Label lbl_PaisOrigen;
    public Label lbl_Temp_Peso;
    public Label lbl_FechaV;
    public TextField tF_Codigo;
    public TableView<Producto> tablaProducto;
    public TableColumn<Producto, String> columna_CodigoSanit;
    public TableView<Producto> tablaProducto2;
    public TableColumn<Producto, String> columna_FechaEnvase;

    public void initialize() {
       columna_Codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
       columna_Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
       columna_Descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
       columna_ValorUnit.setCellValueFactory(new PropertyValueFactory<>("valoruni"));
       columna_Stock.setCellValueFactory(new PropertyValueFactory<>("cantidadExi"));
       columna_FechaV.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
       columna_CodigoSanit.setCellValueFactory(new PropertyValueFactory<>("codigoAprob"));
        columna_Temperatura.setCellValueFactory(new PropertyValueFactory<>("tempRecomendada"));
        columna_FechaV.setCellValueFactory(new PropertyValueFactory<>("fechaEnvasado"));
        columna_Peso.setCellValueFactory(new PropertyValueFactory<>("pesoEnvase"));
       columna_FechaEnvase.setCellValueFactory(new PropertyValueFactory<>("pesoEnvase"));
       columna_tipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipoProducto"));
        tablaProducto.setItems(MainApplication.getProductos());
        tablaProducto2.setItems(MainApplication.getProductos());
        tF_Temperatura_Peso.setText("0");

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
                tF_CodigoSanit.setVisible(false);

            }

        });


    }
    public void registrarProducto(){

        String codigo = this.tF_Codigo.getText();
        String nombre = this.tF_NombreP.getText();
        String descripcion = this.tF_Descripcion.getText();
        double valorUnit = Double.parseDouble(tF_ValorUnit.getText());
        int stock = Integer.parseInt(tF_Stock.getText());
        String tipoProducto = (String) comboBox_tipoProducto.getSelectionModel().getSelectedItem();
        String fechaVenci = this.dP_FechaV.getValue()+"";
        String codigoSanit = this.tF_CodigoSanit.getText();
        double temperatura = Double.parseDouble(tF_Temperatura_Peso.getText());
        String fechaEnvase = this.dP_FechaV.getValue()+"";
        double peso = Double.parseDouble(tF_Temperatura_Peso.getText());
        Object paisOrigen = comboBox_PaisOrigen.getSelectionModel().getSelectedItem();
        if("Perecederos".equals(tipoProducto)){
            temperatura=0;
            ProductoPerecible p = new ProductoPerecible(tipoProducto,codigo,nombre,descripcion,valorUnit,stock,fechaVenci);
            tablaProducto.setItems(MainApplication.registrarProductoTabla(p));


        } else if ("Refrigerados".equals(tipoProducto)) {
            ProductoRefrigerado p1 = new ProductoRefrigerado(tipoProducto,codigo,nombre,descripcion,valorUnit,stock,codigoSanit,temperatura);
            tablaProducto.setItems(MainApplication.registrarProductoTabla(p1));
        } else if ("Envasados".equals(tipoProducto)) {
            ProductoEnvasado p2 = new ProductoEnvasado(tipoProducto,codigo,nombre,descripcion,valorUnit,stock,fechaEnvase,peso);
            tablaProducto.setItems(MainApplication.registrarProductoTabla(p2));

        }

        tF_NombreP.clear();
        tF_Codigo.clear();
        tF_Descripcion.clear();
        tF_ValorUnit.clear();
        tF_Stock.clear();
        tF_Temperatura_Peso.setText("0");
        tF_CodigoSanit.clear();
        dP_FechaV.setValue(null);
        comboBox_tipoProducto.getSelectionModel().select(0);
        comboBox_PaisOrigen.getSelectionModel().select(0);


    }

    public void actualizarProducto(){
        Producto productoSeleccionado = tablaProducto.getSelectionModel().getSelectedItem();
        tF_Codigo.setText(productoSeleccionado.getCodigo());
        tF_NombreP.setText(productoSeleccionado.getNombre());
        tF_Descripcion.setText(productoSeleccionado.getDescripcion());
        tF_ValorUnit.setText(productoSeleccionado.getValorUni()+"");
        tF_Stock.setText(productoSeleccionado.getCantidadExi()+"");

        MainApplication.eliminarProducto(productoSeleccionado);
        tablaProducto.refresh();



    }
    public void eliminarProducto(){
        Producto productoSeleccionado = tablaProducto.getSelectionModel().getSelectedItem();
        MainApplication.eliminarProducto(productoSeleccionado);
        tablaProducto.refresh();

    }

    public void volver() {
        Stage stage = (Stage) this.btn_VolverP.getScene().getWindow();
        stage.close();


    }
}
