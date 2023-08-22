package com.example.guitallerRepasov2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
//import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends ActionEvent {
    public Button btn_Cliente;
    public Button btn_Ventas;
    public Button btn_Productos;


    public void cliente() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registroClientes.fxml"));
       Parent root = loader.load();
       Scene scene = new Scene(root);
       Stage stage = new Stage();
       stage.initModality(Modality.APPLICATION_MODAL);
       stage.setScene(scene);
       stage.showAndWait();

    }
    public void producto() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registroProductos.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

    }

    public void venta() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("registroVentas.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

    }
}