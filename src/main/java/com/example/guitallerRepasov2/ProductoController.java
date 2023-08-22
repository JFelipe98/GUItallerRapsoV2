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
    //Atributos de la interfaz producto
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
    //Lista observable de elementos del comboBox tipo de producto y país (No implementada)

    public ObservableList<String> tipoProdcuto = FXCollections.observableArrayList("--SELECCIONE--", "Perecederos","Refrigerados","Envasados");
    public  ObservableList<String> paisOrigen = FXCollections.observableArrayList("--SELECCIONE--","Col","Arg","Chil","Ecu","Per");
    public ComboBox comboBox_PaisOrigen;
    public Label lbl_PaisOrigen;
    public Label lbl_Temp_Peso;
    public Label lbl_FechaV;
    public TextField tF_Codigo;
    public TableView<Producto> tablaProducto;
    //public TableColumn<Producto, String> columna_CodigoSanit;
    //public TableView<Producto> tablaProducto2;
    public TableColumn<Producto, String> columna_FechaEnvase;
////Método que inicializa parametros, tablas y condiciones de vista según la elección del comBox
    public void initialize() {
        /*
        Elementos de la tabla de producto, debe llenarse columna a columna con los atributos
        del objeto en cuestión. En este caso es un objeto Producto. el String al final es el nombre
        exacto del atributo en cuestión.
         */
       columna_Codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
       columna_Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
       columna_Descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
       columna_ValorUnit.setCellValueFactory(new PropertyValueFactory<>("valorUni"));
       columna_Stock.setCellValueFactory(new PropertyValueFactory<>("cantidadExi"));

       columna_tipoProducto.setCellValueFactory(new PropertyValueFactory<>("tipoProducto"));
       // Inicialización de las tablas de productos con los atributos de la lista observable de productos
       tablaProducto.setItems(MainApplication.getProductos());
        //tablaProducto2.setItems(MainApplication.getProductos());
        // Inicialización del parametro temperatura/peso (comparten textField) de lo contrario, salta error.
        tF_Temperatura_Peso.setText("0");
// Inicialización del comboBox tipoProducto, dependiendo de la acción, algunos elementos aparecen y desaparecen.
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
    /*
Método que registra los productos.
Se captura la info en variables y dependiendo de la selección del comboBox
instancia un producto y se llama a la función registrarProducto()
del MainAplication.
(Se creó allí para la persistencia de datos mientras la app esté abierta).
La función lo que hace es enviar el cliente instanciado, lo agrega a la lista de observables y
retorna la lista para ser actualizada la tabla.
 */
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
            tablaProducto.setItems(Producto.registrarProductoTabla(p));


        } else if ("Refrigerados".equals(tipoProducto)) {
            ProductoRefrigerado p1 = new ProductoRefrigerado(tipoProducto,codigo,nombre,descripcion,valorUnit,stock,codigoSanit,temperatura);
            tablaProducto.setItems(Producto.registrarProductoTabla(p1));
        } else if ("Envasados".equals(tipoProducto)) {
            ProductoEnvasado p2 = new ProductoEnvasado(tipoProducto,codigo,nombre,descripcion,valorUnit,stock,fechaEnvase,peso);
            tablaProducto.setItems(Producto.registrarProductoTabla(p2));

        } else if("--SELECCIONE--".equals(tipoProducto)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Elija una opción");
            alert.showAndWait();
        }
        //Codigo que "limpia" las casillas para agregar un nuevo producto
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
    /*
    Método que actualiza productos.
    retorna la información de la tabla a las casillas del formulario para ser editadas, a su vez
    elimina el dato actual a la espera de un nuevo registro.
     */
    public void actualizarProducto(){
        Producto productoSeleccionado = tablaProducto.getSelectionModel().getSelectedItem();
        tF_Codigo.setText(productoSeleccionado.getCodigo());
        tF_NombreP.setText(productoSeleccionado.getNombre());
        tF_Descripcion.setText(productoSeleccionado.getDescripcion());
        tF_ValorUnit.setText(productoSeleccionado.getValorUni()+"");
        tF_Stock.setText(productoSeleccionado.getCantidadExi()+"");

        Producto.eliminarProducto(productoSeleccionado);
        tablaProducto.refresh();



    }
    /*
    Método que elimina productos.
    selecciona un producto de la tabla y llama a una función del mainApplication (donde
    está la lista observable) y remueve el dato.
     */
    public void eliminarProducto(){
        Producto productoSeleccionado = tablaProducto.getSelectionModel().getSelectedItem();
        Producto.eliminarProducto(productoSeleccionado);
        tablaProducto.refresh();
    }
/*
Método volver.
Cierra la ventana.
 */
    public void volver() {
        Stage stage = (Stage) this.btn_VolverP.getScene().getWindow();
        stage.close();


    }
}
