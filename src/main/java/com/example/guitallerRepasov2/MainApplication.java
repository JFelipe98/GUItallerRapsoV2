package com.example.guitallerRepasov2;

import Model.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainApplication extends Application {
    //Datos predeterminados
    Natural cPrueba = new Natural("Juan", "Ciro", "1094970892", "3003283500", "Camino del puerto",true,"jfciros@uqvirtual.edu.co","1998-10-16");
    Natural cPrueba2 = new Natural("Laura", "Sanchez", "1193123456", "3006720160", "toledo Boulevard",true,"lmsanchezf@uqvirtual.edu.co","2000-05-17");
    Juridico cPrueba3 = new Juridico("Arepas Quesudas","NA","10975674327","3188198242","Barrio Lindaraja",false,"10975674327-4");
    ProductoPerecible pPrueba = new ProductoPerecible("Perecederos","001","Milo","Bebida en polvo",5000.0,20,"2024-01-13");
   ProductoRefrigerado pPrueba2 = new ProductoRefrigerado("Refrigerados","002","Fresa","Fruta",6000.0,300,"A234",12.0);
   ProductoEnvasado pPrueba3 = new ProductoEnvasado("Envasados","003","Yerba Mate","Infusiones",5000.0,20,"2023-07-31",125.0);
    ProductoEnvasado pPrueba4 = new ProductoEnvasado("Envasados","004","Yerba","Infusiones",10000.0,10,"2023-07-31",125.0);

/*
Listas observables de clientes y productos, esenciales para guardar la información del
registro de clientes y productos.
 */
    public static ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    public static ObservableList<Cliente> getClientes() {
        return clientes;
    }
    public static ObservableList<Producto> productos =FXCollections.observableArrayList();
    public static ObservableList<Producto> getProductos() { return productos; }
    public static ObservableList<Venta> ventas =FXCollections.observableArrayList();
    public static ObservableList<Venta> getVentas() {
        return ventas;
    }

    public static void setVenta(ObservableList<Venta> venta) {
        MainApplication.ventas = venta;
    }


    public static void setClientes(ObservableList<Cliente> clientes) {
        MainApplication.clientes = clientes;
    }

    public static void setProductos(ObservableList<Producto> productos) {
        MainApplication.productos = productos;
    }

    @Override
    /*
    método start
    inicia la ventana home que da acceso a las demás ventanas
    agrega los datos predeterminados a la lista observable.
     */
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();


        clientes.add(cPrueba);
        clientes.add(cPrueba2);
        clientes.add(cPrueba3);
        productos.add(pPrueba);
        productos.add(pPrueba2);
        productos.add(pPrueba3);
        productos.add(pPrueba4);


    }

    public static void main(String[] args) {

        launch();
    }




}