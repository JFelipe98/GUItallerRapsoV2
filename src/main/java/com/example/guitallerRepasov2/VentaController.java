package com.example.guitallerRepasov2;

import Model.Producto;
import Model.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Model.DetalleVenta;


public class VentaController extends ActionEvent {
    //Atributos de interfaz

    public TableColumn<Producto, String> columna_Producto;
    public TableColumn<Producto, Integer> columna_Stock;
    public TableColumn<Producto, Double> columna_ValorUnit;
    public TableColumn<Producto, String> columna_Descripcion;
    public TableColumn<Producto, String> columna_Nombre;
    public TableColumn<Producto, String> columna_Codigo;
    public Button btnBuscar;
    public Button btnAgregar;
    public Button btnQuitar;
    public Button btnConfirmar;
    public Button btn_Volver;

    public TextField txtFieldBuscar;
    public TableView<Producto> tablaProducto;
    public TableColumn<DetalleVenta, String> columnaProducto;
    public TableColumn<DetalleVenta, String> columnaCantidad;
    public TableColumn<DetalleVenta, String> columnaSubtotal;
    public TableView<DetalleVenta> tablaDetalle;
    private Venta venta=new Venta();

    public VentaController() {
        tablaDetalle = new TableView<>();
    }

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
        columna_Producto.setCellValueFactory(new PropertyValueFactory<>("tipoProducto"));

        columnaProducto.setCellValueFactory(new PropertyValueFactory<>("producto"));
        columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        columnaSubtotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
        // Inicialización de las tablas de productos con los atributos de la lista observable de productos
        tablaDetalle.setItems(venta.getDetalleVenta());
        tablaProducto.setItems(MainApplication.getProductos());
        //tablaDetalle.setItems(null);
        // Inicialización del parametro temperatura/peso (comparten textField) de lo contrario, salta error.
        //txtFieldBuscar.setText("");
        //columna_tipoProducto.setText("");
    }
    public void volver() {
        Stage stage = (Stage) this.btn_Volver.getScene().getWindow();
        stage.close();


    }
    public void agregarProducto(){
        Producto productoSeleccionado = tablaProducto.getSelectionModel().getSelectedItem();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Cantidad");
        dialog.setHeaderText("Cuantos productos:");
        dialog.showAndWait().ifPresent(result -> {
            DetalleVenta detalle=new DetalleVenta(Integer.parseInt(result),productoSeleccionado);
            venta.getDetalleVenta().add(detalle);
            productoSeleccionado.setCantidadExi(productoSeleccionado.getCantidadExi()-Integer.parseInt(result));

        });
        for(int i=0;i<venta.getDetalleVenta().size();i++){
            System.out.println("Cantidad "+venta.getDetalleVenta().get(i).getCantidad()+"\n Subtotal"+venta.getDetalleVenta().get(i).getSubtotal());
        }
        tablaDetalle.setItems(venta.getDetalleVenta());
        tablaProducto.setItems(MainApplication.getProductos());

        tablaDetalle.refresh();
        tablaProducto.refresh();

    }

    public void buscarProducto() {
        String textoBuscar = txtFieldBuscar.getText();
        Producto prod = venta.buscarProducto(textoBuscar);
        ObservableList<Producto> temp = FXCollections.observableArrayList();
        temp.add(prod);

        if(temp.get(0).getNombre().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Producto no encontrado");

            alert.showAndWait();
        }else{
            System.out.println(temp.size());
            tablaProducto.setItems(temp);
        }



        tablaProducto.refresh();


    }

    public void confirmarVenta(){

        venta.calcularTotal();

        MainApplication.getVentas().add(venta);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación de venta");
        alert.setHeaderText("La venta se registro exitosamente, \n por el valor de:");
        alert.setContentText("IVA: "+ venta.calcularIva()+"\n SUBTOTAL: " + venta.calcularSubtotal() + "\n TOTAL: "+
                venta.getTotal());
        alert.showAndWait();
        Stage stage = (Stage) this.btnConfirmar.getScene().getWindow();
        stage.close();
    }

    public void quitarProducto(){

    }
}