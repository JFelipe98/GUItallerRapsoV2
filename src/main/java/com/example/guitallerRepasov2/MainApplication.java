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
    private static ArrayList<Cliente> listaCliente;
    Natural cPrueba = new Natural("Juan", "Ciro", "1094970892", "3003283500", "Camino del puerto",true,"jfciros@uqvirtual.edu.co","1998-10-16");
    Natural cPrueba2 = new Natural("Laura", "Sanchez", "1193123456", "3006720160", "toledo Boulevard",true,"lmsanchezf@uqvirtual.edu.co","2000-05-17");
    Juridico cPrueba3 = new Juridico("Arepas Quesudas","NA","10975674327","3188198242","Barrio Lindaraja",false,"10975674327-4");
    ProductoPerecible pPrueba = new ProductoPerecible("Perecederos","001","Milo","Bebida en polvo",5000.0,20,"2024-01-13");
   ProductoRefrigerado pPrueba2 = new ProductoRefrigerado("Refrigerados","002","Fresa","Fruta",6000.0,300,"A234",12.0);
   ProductoEnvasado pPrueba3 = new ProductoEnvasado("Envasados","003","Yerba Mate","Infusiones",5000.0,20,"2023-07-31",125.0);


    public static ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    public static ObservableList<Cliente> getClientes() {
        return clientes;
    }
    public static ObservableList<Producto> productos =FXCollections.observableArrayList();
    public static ObservableList<Producto> getProductos() { return productos; }
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();

        listaCliente = new ArrayList<>();
        listaCliente.add(cPrueba);
        listaCliente.add(cPrueba2);
        clientes.add(cPrueba);
        clientes.add(cPrueba2);
        clientes.add(cPrueba3);
        productos.add(pPrueba);
        productos.add(pPrueba2);
        productos.add(pPrueba3);



    }

    public static void main(String[] args) {

        launch();
    }
    /*
    public static void registrarCliente(Cliente c){
        listaCliente.add(c);
        for (int i=0;i<listaCliente.size();i++){
            listaCliente.get(i).imprimir();
        }
    }*/
    public static ObservableList registrarClienteTabla(Cliente c){
        clientes.add(c);
       return clientes;
    }

    public static ObservableList eliminarCliente(Cliente c){
        clientes.remove(c);

        return clientes;
    }
    public static ObservableList registrarProductoTabla(Producto p){
        productos.add(p);
        return productos;
    }
    public static ObservableList eliminarProducto(Producto p){
        productos.remove(p);
        return productos;
    }
}